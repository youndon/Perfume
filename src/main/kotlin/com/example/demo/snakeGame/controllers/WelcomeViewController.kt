package com.hegyi.botond.controllers

import com.example.demo.snakeGame.MyLogger.WARN
import javafx.stage.Stage
import javafx.scene.Parent
import javafx.fxml.FXMLLoader
import java.lang.Exception
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import com.example.demo.snakeGame.GameScene
import javafx.scene.control.Button
import kotlin.system.exitProcess

class WelcomeViewController {
    private val startBtn: Button? = null
    private val settingsBtn: Button? = null
    private val scoreBtn: Button? = null
    private var root: Parent? = null
    private var parentView: Stage? = null
    private val difficulty: Long = 100000000
    fun exit() {
        exitProcess(0)
    }
    fun startBtnAction() {
        val root = AnchorPane()
        parentView = startBtn!!.scene.window as Stage
        parentView!!.scene = GameScene(root, difficulty)
        parentView!!.centerOnScreen()
        parentView!!.show()
    }

    fun settingsBtnAction() {
        parentView = settingsBtn!!.scene.window as Stage
        setView(parentView, "views/SettingsView.fxml")
    }

    fun scoreBtnAction() {
        parentView = scoreBtn!!.scene.window as Stage
        setView(parentView, "views/ScoreView.fxml")
    }

    private fun setView(stage: Stage?, location: String) {
        try {
            root = FXMLLoader.load(javaClass.classLoader.getResource(location))
        } catch (ex: Exception) {
            WARN("$location file not found")
            exitProcess(0)
        }
        stage!!.scene = Scene(root)
        stage.show()
    }
}