package com.example.demo.CRUD

import com.example.demo.CRUD.CRUD_View.Companion.users
import tornadofx.Controller
import java.sql.Date
import java.time.LocalDate

class CRUD_Control: Controller() {
    fun addUser(firstname: String?, lastname: String?,date:Date?, category:String?, note:String?) {
        val user = CRUD_User(firstname = firstname,lastname = lastname,date = date,category = category,note = note)
        val doa = CRUD_DataBase()
        doa.insert(user)
        users.add(user)
    }
}
