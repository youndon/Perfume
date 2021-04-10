package com.example.demo.Login

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import tornadofx.Controller
import tornadofx.singleAssign

class SignIn_Control: Controller() {
    fun loginUser(username: String, password: String) {
        SignIn_DataBase().checkAccountExist(username, password)
    }

    fun newUser(user: SignIn_User) {
        SignIn_DataBase().createNewUser(user)
    }

    fun newTable(username: String) {
        SignIn_DataBase().createUserNameTable(username)
    }

    val signinusername = SimpleStringProperty()
    val signinpassword = SimpleStringProperty()
    var signinusernameField: TextField by singleAssign()
    var signinpasswordField: PasswordField by singleAssign()
    val signupfirstname = SimpleStringProperty()
    val signuplastname = SimpleStringProperty()
    val signupusername = SimpleStringProperty()
    val signuppassword = SimpleStringProperty()
    val signupconfirmPassword = SimpleStringProperty()
    var signupfirstnameField: TextField by singleAssign()
    var signuplastnameField: TextField by singleAssign()
    var signupusernameField: TextField by singleAssign()
    var signuppasswordField: PasswordField by singleAssign()
    var signupconfirmpasswordField: PasswordField by singleAssign()
}