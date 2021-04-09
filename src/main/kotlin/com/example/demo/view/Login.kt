package com.example.demo.view

import CrudView
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.sql.Connection
import java.sql.DriverManager

fun main() = launch<LoginApp>()

var myusername = ""

class LoginApp:App(Login::class)

class Login:View() {
    val username = SimpleStringProperty()
    val password = SimpleStringProperty()
    val controller:Control by inject()
     override val root = borderpane{
        center{
            form{
                fieldset("Login") {
                    field {
                        textfield(username) {
                            promptText ="username"
                            requestFocus()
                        }
                    }
                    field {
                        passwordfield(password) {
                            promptText = "password"
                            requestFocus()
                        }
                    }
                }
            }
        }
        bottom {
            vbox {
                button("Login") {
                    action {
                        runAsync {
                            controller.loginUser(username.value,password.value)
                        }.ui {
                            myusername = username.value
                            replaceWith(CrudView::class)
                        }
                    }
                }
                button("SingUp") {
                    action {
                        replaceWith(SingUp::class)
                    }
                }
            }
        }
    }
}

class SingUp:View(){
    val firstname = SimpleStringProperty()
    val lastname = SimpleStringProperty()
    val username = SimpleStringProperty()
    private val password = SimpleStringProperty()
    private val controller:Control by inject()
    override val root =borderpane{
        center {
            form{
                fieldset("SingUp") {
                    field {
                        textfield(firstname) {
                            promptText ="First Name"
                        }
                        textfield(lastname) {
                            promptText ="Last Name"
                        }
                    }
                    field {
                        textfield(username) {
                            promptText ="UserName"
                        }
                    }
                    field {
                        passwordfield(password) {
                            promptText="Password"
                        }
                    }
//                    field {
//                        passwordfield(password) {
//                            promptText = "confirm password"
//                        }
//                    }
                }
            }
        }
        bottom {
            vbox {
                button("SingUp") {
                    action {
                        val user = User(
                            name = firstname.value,
                            username = username.value,
                            password = password.value
                        )
                        runAsync {
                            controller.newUser(user)
                        }.ui {
                            controller.newTable(username.value)
                            myusername = username.value
                            replaceWith(CrudView::class)
                        }
                    }
                }
                button("Login").action {
                    replaceWith(Login::class)
                }
            }
        }
    }
}

class Control:Controller() {
    fun loginUser(username: String, password: String) {
        Database().checkAccountExist(username, password)
    }
    fun newUser(user: User) {
        Database().createNewUser(user)
    }
    fun newTable(username:String) {
        Database().createUserNameTable(username)
    }
}

 data class User(val id:Int?=null,val name:String? =null,val username:String?=null,val password: String?=null)

 class Database {
    private val connection: Connection
    //    init {
//        Class.forName("com.mysql.cj.jdbc.Driver")
//        connection = DriverManager.getConnection("jdbc:msql://localhost:3306/landbase","land","copione25163")
//    }
    init {
        Class.forName("org.sqlite.JDBC")
        connection = DriverManager.getConnection("jdbc:sqlite:Perfume.db")

        try{
            val sql = connection.prepareStatement(
                "CREATE TABLE SingUp " +
                        "(id INTEGER," +
                        "firstname TEXT, " +
                        "lastname TEXT," +
                        "password TEXT," +
                        "PRIMARY KEY(id) ); "
            )
            sql.executeUpdate()
            sql.close()
        }catch (ex:Exception){
            println(ex.localizedMessage)
        }
    }
    fun createNewUser(user:User):Int{
        val preparedStatement = connection.prepareStatement("INSERT INTO SingUp(name,username,password) VALUES (?,?,?)")
        preparedStatement.setString(1,user.name)
        preparedStatement.setString(2,user.username)
        preparedStatement.setString(3,user.password)
        val rowCont = preparedStatement.executeUpdate()
        preparedStatement.close()
        return rowCont
    }

    fun checkAccountExist(username: String, password: String): Boolean {
        val preparedStatement = connection.prepareStatement("SELECT id FROM SingUp WHERE username = ? AND password = ?")
        preparedStatement.setString(1,username)
        preparedStatement.setString(2,password)
        val resultSet = preparedStatement.executeQuery()
        resultSet.next()
        val id = resultSet.getInt("id")
        preparedStatement.close()
        return id > 0
    }
    fun createUserNameTable(username: String) {
        val sql = connection.prepareStatement(
            "CREATE TABLE $username " +
                    "(id INTEGER," +
                    "firstname TEXT, " +
                    "lastname TEXT," +
                    "date BOLD, " +
                    "category TEXT," +
                    "note TEXT," +
                    "PRIMARY KEY(id) ); "
        )
        sql.executeUpdate()
        sql.close()
        connection.close()
    }
     fun selectUserName(username: String):String {
         val preparedStatement = connection.prepareStatement("SELECT * FROM SingUp WHERE username = ?")
         preparedStatement.setString(1,username)
         val resultSet = preparedStatement.executeQuery()
         resultSet.next()
         val name = resultSet.getString("name") ?: ""
         preparedStatement.close()
         return name
     }
}