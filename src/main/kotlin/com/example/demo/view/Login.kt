package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

fun main() {
    launch<LoginApp>()
}
class LoginApp:App(Login::class)
class HomePage:View(){
    val controller :HomePageController by inject()
    override val root = borderpane{
        center {
            label(controller.update()) {  }
        }
    }
}

class Login:View() {
    val username = SimpleStringProperty()
    val password = SimpleStringProperty()
    val controller:LoginController by inject()
     override val root = borderpane{
        center{
            form{
                fieldset {
                    field {
                        textfield {
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
                            replaceWith(HomePage::class)
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
    val name = SimpleStringProperty()
    val username = SimpleStringProperty()
    private val password = SimpleStringProperty()
    private val controller:SingUpController by inject()
    override val root =borderpane{
        center {
            form{
                fieldset {
                    field {
                        textfield(name) {
                            promptText ="firstname"
                        }

                    }
                    field {
                        textfield(username) {
                            promptText ="password"
                        }

                    }
                    field {
                        passwordfield(password) {
                            promptText="confirm password"
                        }

                    }
                }

            }
        }
        bottom {
            button("SingUp") {
                action{
                    val user = User(name = name.value,
                        username = username.value,
                        password = password.value
                    )
                    runAsync {
                        controller.newUser(user)
                    }.ui{
                        myusername = username.value
                        replaceWith(HomePage::class)
                    }
                }
            }
        }
    }
}

var myusername = ""

class LoginController:Controller(){
    fun loginUser(username: String?, password: String?) {
        val database=Database()
        database.checkAccontExist(username!!,password!!)
    }
}

class SingUpController:Controller(){
    fun newUser(user: User) {
        val database=Database()
            database.createNewUser(user)
    }
}

class HomePageController:Controller(){
    fun update(database: Database = Database()):String {
        return database.selectName(myusername)
    }
}

data class User(val id:Int?=null,val name:String? =null,val username:String?=null,val password: String?=null)

