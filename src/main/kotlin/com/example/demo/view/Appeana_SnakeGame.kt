package com.example.demo.view

import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Rectangle
import javafx.stage.Stage
import tornadofx.*
import kotlin.concurrent.thread
import kotlin.math.absoluteValue
import kotlin.random.Random

fun main() {
    launch<MainSnakeGame>()
}
class MainSnakeGame:App(Appeana_SnakeGame::class)

class Appeana_SnakeGame:UIComponent() {    private var head = Rectangle()
    private var food = Circle()
    var num = 0
    private var location = arrayListOf(Pair(0.0,0.0))
    private var snake = arrayListOf<Rectangle>()
    private val keysMap = hashMapOf<KeyCode,Boolean>()
    override val root = hbox {
        setPrefSize(500.0, 500.0)
        head = rectangle {
            height=20.0
            width=20.0
        }
        snake.add(head)
        canvas {
            snake.forEach {
                it.fill=Color.GREENYELLOW
            }
            food = circle {
                radius = 10.0
                fill = Color.GREEN
                translateX = Random.nextDouble(10.0, 480.0)
                translateY = Random.nextDouble(10.0, 480.0)
            }
        }
        addEventFilter(KeyEvent.ANY) {
            keysMap[it.code] = it.eventType == KeyEvent.KEY_PRESSED
        }
    }
    private fun upDate() {
        if (keysMap[KeyCode.UP] == true) snake[0].translateY -= 10
        if (keysMap[KeyCode.DOWN] == true) snake.first().translateY += 10
        if (keysMap[KeyCode.LEFT] == true) snake.first().translateX -= 10
        if (keysMap[KeyCode.RIGHT] == true) snake.first().translateX += 10

        if (snake[0].boundsInParent.intersects(food.boundsInParent)) {
            food.translateX = Random.nextDouble(10.0,480.0)
            food.translateY = Random.nextDouble(10.0,480.0)
            snake.add(head)
        }
    }
    override fun onDock() {
        super.onDock()
        root.requestFocus()
        thread {
            while (true){
                upDate()
                Thread.sleep(50)
            }
        }
    }
}