package com.example.demo.CRUD

import com.example.demo.Login.myusername
import javafx.beans.property.Property
import java.sql.Connection
import java.sql.Date
import java.sql.DriverManager
import java.time.LocalDate

class CRUD_DataBase{
    private val connection: Connection
    init {
        Class.forName("org.sqlite.JDBC")
        connection = DriverManager.getConnection("jdbc:sqlite:Perfume.db")
    }
    fun insert(user: CRUD_User) {
        val ps = connection.prepareStatement("INSERT INTO $myusername(firstname,lastname,date,category,note) VALUES (?, ?, ?, ?, ?)")
        ps.setString(1,user.firstname)
        ps.setString(2,user.lastname)
        ps.setDate(3, user.date)
        ps.setString(4,user.category)
        ps.setString(5,user.note)
        ps.executeUpdate()
        ps.close()
        connection.close()
    }
    fun readUsers(): ArrayList<CRUD_User> {
        val resultSet = connection.createStatement().executeQuery("SELECT * FROM $myusername")
        val userList = ArrayList<CRUD_User>()
        while (resultSet.next()){
            val id = resultSet.getInt("id")
            val firstname = resultSet.getString("firstname")
            val lastname = resultSet.getString("lastname")
            val date = resultSet.getDate("date")
            val category = resultSet.getString("category")
            val note = resultSet.getString("note")
            userList.plusAssign(CRUD_User(id ,firstname,lastname,date,category,note))
        }
        resultSet.close()
        connection.close()
        return userList
    }

    fun update(
        index:Int, modifyfirstname:String?=null,
        modifylastname:String?=null,
        modifydate: Date? =null,
        modifycategory:String?=null,
        modifynote:String?=null) {
        val ps = connection.prepareStatement("UPDATE $myusername SET firstname = ? , lastname = ? , date = ? , category = ? , note = ? WHERE id = $index ")
        ps.setString(1, modifyfirstname)
        ps.setString(2, modifylastname)
        ps.setDate(3, modifydate)
        ps.setString(4, modifycategory)
        ps.setString(5, modifynote)
        ps.executeUpdate()
        ps.close()
        connection.close()
    }
    fun delete(index: Int) {
        val ps = connection.prepareStatement("DELETE FROM $myusername WHERE id = $index")
        ps.executeUpdate()
        ps.close()
        connection.close()
    }
}
