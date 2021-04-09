package com.example.demo.CRUD

import com.example.demo.CRUD.CRUD_View.Companion.users
import tornadofx.Controller

class CRUD_Control: Controller() {
    fun addUser(firstname: String?, lastname: String?, category:String?, note:String?) {
        val user = CRUD_User(firstname = firstname,lastname = lastname,category = category,note = note)
        val doa = CRUD_DataBase()
        doa.insert(user)
        users.add(user)
    }
}
