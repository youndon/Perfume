package com.example.demo.view

import java.sql.Connection
import java.sql.DriverManager

class Database {
    private val connection:Connection
    init {
        Class.forName("com.mysql.cj.jdbc.Driver")
        connection = DriverManager.getConnection("jdbc:msql://localhost:3306/landbase","land","copione25163")
    }

    fun createNewUser(user:User):Int{
        val preparedStatement = connection.prepareStatement("INSERT INTO user(name,username,password) VALUES (?,?,?)")
        preparedStatement.setString(1,user.name)
        preparedStatement.setString(2,user.username)
        preparedStatement.setString(3,user.password)
        val rowCont = preparedStatement.executeUpdate()
        preparedStatement.close()
        return rowCont
    }
    fun selectName(username: String):String {
        val preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ?")
        preparedStatement.setString(1,username)
        val resultSet = preparedStatement.executeQuery()
        resultSet.next()
        val name = resultSet.getString("name") ?: ""
        preparedStatement.close()
        return name
    }
    fun checkAccontExist(username: String, password: String): Boolean {
        val preparedStatement = connection.prepareStatement("SELECT id FROM user WHERE username = ? AND password = ?")
        preparedStatement.setString(1,username)
        preparedStatement.setString(2,password)
        val resultSet = preparedStatement.executeQuery()
        resultSet.next()
        val id = resultSet.getInt("id")
        preparedStatement.close()
        return id > 0
    }
}