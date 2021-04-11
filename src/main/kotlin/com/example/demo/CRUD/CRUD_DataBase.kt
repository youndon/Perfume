package com.example.demo.CRUD

import com.example.demo.Login.myusername
import javafx.beans.property.Property
import java.sql.Connection
import java.sql.DriverManager
import java.time.LocalDate

class CRUD_DataBase {
    private val connection: Connection

    init {
        Class.forName("org.sqlite.JDBC")
        connection = DriverManager.getConnection("jdbc:sqlite:Perfume.db")
    }

    fun insert(user: CRUD_User) {
        val ps =
            connection.prepareStatement("INSERT INTO $myusername(firstname,lastname,date,category,note,day,month,year) VALUES (?,?,?,?,?,?,?,?)")
        ps.setString(1, user.firstname)
        ps.setString(2, user.lastname)
        ps.setObject(3, user.localdate)
        ps.setString(4, user.category)
        ps.setString(5, user.note)
        ps.setInt(6, user.day)
        ps.setInt(7, user.month)
        ps.setInt(8, user.year)
        ps.executeUpdate()
        ps.close()
        connection.close()
    }

    fun readUsers(): ArrayList<CRUD_User> {
        val resultSet = connection.createStatement().executeQuery("SELECT * FROM $myusername")
        val userList = ArrayList<CRUD_User>()
        while (resultSet.next()) {
            val id = resultSet.getInt("id")
            val firstname = resultSet.getString("firstname")
            val lastname = resultSet.getString("lastname")
            val date = resultSet.getString("date")
            val category = resultSet.getString("category")
            val note = resultSet.getString("note")
            val day = resultSet.getInt("day")
            val month = resultSet.getInt("month")
            val year = resultSet.getInt("year")
            userList.plusAssign(CRUD_User(id, firstname, lastname, date, category, note, day, month, year))
        }
        resultSet.close()
        connection.close()
        return userList
    }

    fun update(
        index: Int, modifyfirstname: String? = null,
        modifylastname: String? = null,
        modifydate: String? = null,
        modifycategory: String? = null,
        modifynote: String? = null,
        modifyday: Int = 10,
        modifymonth: Int = 10,
        modifyyear: Int = 2010
    ) {
        val ps =
            connection.prepareStatement("UPDATE $myusername SET firstname=? ,lastname=? ,date=? ,category=? ,note=? ,day=? ,month=? ,year=? WHERE id = $index ")
        ps.setString(1, modifyfirstname)
        ps.setString(2, modifylastname)
        ps.setString(3, modifydate)
        ps.setString(4, modifycategory)
        ps.setString(5, modifynote)
        ps.setInt(6,modifyday)
        ps.setInt(7,modifymonth)
        ps.setInt(8,modifyyear)
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
