package com.hegyi.botond.controllers

import com.example.demo.snakeGame.MyLogger.WARN
import javafx.stage.Stage
import javafx.scene.Parent
import javafx.fxml.FXMLLoader
import java.lang.Exception
import javafx.scene.Scene
import javafx.event.ActionEvent
import javafx.scene.control.Button
import kotlin.system.exitProcess

abstract class GoBack {
    fun back(actionEvent: ActionEvent) {
        val button = actionEvent.source as Button
        val stage = button.scene.window as Stage
        var root: Parent? = null
        try {
            root = FXMLLoader.load(javaClass.classLoader.getResource("views/WelcomeView.fxml"))
        } catch (ex: Exception) {
            WARN("views/WelcomeView.fxml file not found")
            exitProcess(0)
        }
        stage.scene = Scene(root)
        stage.show()
    }
}