package com.example.demo.Login

import com.example.demo.CRUD.CRUD_View
import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*

class SignUp_View:View() {
    private val control: SignIn_Control by inject()
    override val root = borderpane {
        center {
            form {
                fieldset("SingUp") {
                    field {
                        textfield(control.signupfirstname) {
                            control.signupfirstnameField = this
                            promptText = "First Name"
                        }
                        textfield(control.signuplastname) {
                            control.signuplastnameField = this
                            promptText = "Last Name"
                        }
                    }
                    field {
                        textfield(control.signupusername) {
                            control.signupusernameField = this
                            promptText = "UserName"
                        }
                    }
                    field {
                        passwordfield(control.signuppassword) {
                            control.signuppasswordField = this
                            promptText = "Password"
                            control.signuppassword.onChange {
                                when (control.signuppassword.value.length) {
                                    in 1..5 -> this.style { backgroundColor.plusAssign(Color.ORANGERED) }
                                    in 6..12 -> this.style { backgroundColor.plusAssign(Color.YELLOW) }
                                    in 13..30 -> this.style { backgroundColor.plusAssign(Color.GREEN) }
                                    else -> this.style { backgroundColor.plusAssign(Color.WHITE) }
                                }
                            }
                            tooltip("put unless 5 char")
                        }
                    }
                    field {
                        passwordfield(control.signupconfirmPassword) {
                            control.signupconfirmpasswordField = this
                            promptText = "confirm password"
                        }
                    }
                }
            }
        }
        bottom {
            vbox {
                button("SingUp") {
                    action {
                        val user = SignIn_User(
                            firstname = control.signupfirstname.value,
                            username = control.signupusername.value,
                            password = control.signuppassword.value
                        )
                        runAsync {
                            control.newUser(user)
                        }.ui {
                            control.newTable(control.signupusername.value)
                            myusername = control.signupusername.value
                            replaceWith(CRUD_View::class)
                        }
                    }
                }.enableWhen {
                    control.signupconfirmPassword.isEqualTo(control.signuppassword)
                }
                button("SigIn") {
                    action {
                        alignment = Pos.CENTER
                        control.signupfirstnameField.clear()
                        control.signuplastnameField.clear()
                        control.signupusernameField.clear()
                        control.signuppasswordField.clear()
                        control.signupconfirmpasswordField.clear()
                        replaceWith(SignIn_View::class)
                    }
                }
            }
        }
    }
}