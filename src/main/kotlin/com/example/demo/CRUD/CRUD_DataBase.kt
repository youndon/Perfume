package com.example.demo.CRUD

import com.example.demo.Login.SignIn_Control
import java.sql.Connection
import java.sql.DriverManager

class CRUD_DataBase{
    val connection: Connection
    init {
        Class.forName("org.sqlite.JDBC")
        connection = DriverManager.getConnection("jdbc:sqlite:Perfume.db")
    }
    fun insert(user: CRUD_User) {
        val ps = connection.prepareStatement("INSERT INTO ${SignIn_Control().myusername}(firstname,lastname,category,note) VALUES (?, ?, ?, ?)")
        ps.setString(1,user.firstname)
        ps.setString(2,user.lastname)
        ps.setString(3,user.category)
        ps.setString(4,user.note)
        ps.executeUpdate()
        ps.close()
        connection.close()
    }
    fun readUsers(): ArrayList<CRUD_User> {
        val resultSet = connection.createStatement().executeQuery("SELECT * FROM ${SignIn_Control().myusername}")
        val userList = ArrayList<CRUD_User>()
        while (resultSet.next()){
            val id = resultSet.getInt("id")
            val firstname = resultSet.getString("firstname")
            val lastname = resultSet.getString("lastname")
            val category = resultSet.getString("category")
            val note = resultSet.getString("note")
            userList.plusAssign(CRUD_User(id ,firstname,lastname,category,note))
        }
        resultSet.close()
        connection.close()
        return userList
    }

    fun update(index:Int, modifyfirstname:String?=null,
               modifylastname:String?=null,
               modifycategory:String?=null,
               modifynote:String?=null) {
        val ps = connection.prepareStatement("UPDATE ${SignIn_Control().myusername} SET firstname = ? , lastname = ? , category = ? , note = ? WHERE id = $index ")
        ps.setString(1, modifyfirstname)
        ps.setString(2, modifylastname)
        ps.setString(3, modifycategory)
        ps.setString(4, modifynote)
        ps.executeUpdate()
        ps.close()
        connection.close()
    }
    fun delete(index: Int) {
        val ps = connection.prepareStatement("DELETE FROM ${SignIn_Control().myusername} WHERE id = $index")
        ps.executeUpdate()
        ps.close()
        connection.close()
    }
}
