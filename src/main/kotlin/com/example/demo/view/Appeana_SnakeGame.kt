package com.example.demo.view

import com.example.demo.box.SnakeGame
import javafx.animation.AnimationTimer
import javafx.scene.Parent
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import sun.audio.AudioPlayer.player
import tornadofx.*
import java.util.*
import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    launch<MainSnakeGame>()
}
class MainSnakeGame:App(Appeana_SnakeGame::class)
class Appeana_SnakeGame:UIComponent() {
    override val root = stackpane {

    }
}
