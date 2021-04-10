package com.example.demo.Login

import com.example.demo.CRUD.CRUD_View
import com.example.demo.CRUD.Glyphs.signInGlyph
import tornadofx.*

class SignIn_View:View() {
    private val controller: SignIn_Control by inject()
    override val root = borderpane {
        center {
            form {
                fieldset("SignIn") {
                    field {
                        textfield(controller.signinusername) {
                            controller.signinusernameField = this
                            promptText = "username"
                            requestFocus()
                        }
                    }
                    field {
                        passwordfield(controller.signinpassword) {
                            controller.signinpasswordField = this
                            promptText = "password"
                            requestFocus()
                        }
                    }
                }
            }
        }
        bottom {
            vbox {
                button("SignIn", signInGlyph) {
                    action {
                        runAsync {
                            controller.loginUser(controller.signinusername.value, controller.signinpassword.value)
                        }.ui {
                            myusername = controller.signinusername.value
                            controller.signinusernameField.clear();controller.signinpasswordField.clear()
                            replaceWith(CRUD_View::class)
                        }
                    }
                }
                button("SingUp") {
                    action {
                        controller.signinusernameField.clear();controller.signinpasswordField.clear()
                        replaceWith(SignUp_View::class)
                    }
                }
            }
        }
    }
}