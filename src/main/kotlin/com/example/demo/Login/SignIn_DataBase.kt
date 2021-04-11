package com.example.demo.Login

import com.example.demo.CRUD.CRUD_Model
import com.example.demo.CRUD.CRUD_User
import java.sql.Connection
import java.sql.DriverManager
class SignIn_DataBase {
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
                            "username TEXT," +
                            "password TEXT," +
                            "PRIMARY KEY(id) ); "
                )
                sql.executeUpdate()
                sql.close()
            }catch (ex:Exception){
                println(ex.localizedMessage)
            }
        }
        fun createNewUser(user:SignIn_User):Int{
            val preparedStatement = connection.prepareStatement("INSERT INTO SingUp(firstname,lastname,username,password) VALUES (?,?,?,?)")
            preparedStatement.setString(1,user.firstname)
            preparedStatement.setString(2,user.lastname)
            preparedStatement.setString(3,user.username)
            preparedStatement.setString(4,user.password)
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
                        "date BOLD," +
                        "category TEXT," +
                        "note TEXT," +
                        "day INTEGER," +
                        "month INTEGER," +
                        "year INTEGER," +
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