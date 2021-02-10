package com.example.demo.snakeGame

import com.hegyi.botond.controllers.SettingsViewController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.launch
import java.util.prefs.Preferences
import kotlin.system.exitProcess

fun main() {
    launch<App>()
}
class App : Application() {
    private var prefs: Preferences? = null
    private val UP = "UP"
    private val DOWN = "DOWN"
    private val RIGHT = "RIGHT"
    private val LEFT = "LEFT"
    override fun start(primaryStage: Stage) {
        var root: Parent? = null
        try {
            root = FXMLLoader.load(javaClass.classLoader.getResource("views/WelcomeView.fxml"))
        } catch (ex: Exception) {
            MyLogger.WARN("views/WelcomeView.fxml file not found.")
            exitProcess(0)
        }
        try {
            primaryStage.icons.add(Image(javaClass.classLoader.getResourceAsStream("images/snake_icon.png")))
        } catch (ex: Exception) {
            MyLogger.WARN("images/snake_icon.png file not found.")
            exitProcess(0)
        }
        primaryStage.title = "Snake"
        primaryStage.scene = Scene(root, WIDTH.toDouble(), HEIGHT.toDouble())
        primaryStage.isResizable = false
        primaryStage.centerOnScreen()
        setDefCont()
        primaryStage.show()
    }

    // reset the controls to default
    // every time the application started
    private fun setDefCont() {
        MyLogger.INFO("set controls")
        prefs = Preferences.userRoot().node(SettingsViewController::class.java.name)
        prefs!!.put(UP, UP)
        prefs!!.put(DOWN, DOWN)
        prefs!!.put(RIGHT, RIGHT)
        prefs!!.put(LEFT, LEFT)
        prefs!!.putBoolean("renderScore", false)
    }

    companion object {
        const val WIDTH = 400
        const val HEIGHT = 400
    }
}