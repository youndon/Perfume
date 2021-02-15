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
    private var head = Rectangle()
    private var tail = Rectangle()
    private var food = Circle()
    private var snake = arrayListOf<Rectangle>()
    private var location = arrayListOf(Pair(0.0,0.0))
    private val keysMap = hashMapOf<KeyCode,Boolean>()
    override val root = stackpane {
        setPrefSize(500.0,500.0)
        head =rectangle {
            width=10.0
            height=10.0
            fill = Color.HOTPINK
        }
        tail =rectangle {
            width=10.0
            height=10.0
            fill = Color.BROWN
        }
        snake.add(tail)
        canvas {
            food = circle {
                radius = 10.0
                fill = Color.INDIGO
                translateX = Random.nextDouble(10.0,480.0)
                translateY = Random.nextDouble(10.0,480.0)
            }
        }
        addEventFilter(KeyEvent.ANY){ keyEvent ->
            keysMap[keyEvent.code] = keyEvent.eventType == KeyEvent.KEY_PRESSED
            location.add(Pair(head.translateX,head.translateY))
            (snake).withIndex().forEach {
                snake[it.index].translateX = location.asReversed().drop(1)[it.index].first
                snake[it.index].translateY = location.asReversed().drop(1)[it.index].second
            }
        }
    }
    private fun upDate(){

//        if (keysMap[KeyCode.UP]==true) head.translateY-=10
//        if (keysMap[KeyCode.DOWN]==true) head.translateY+=10
//        if (keysMap[KeyCode.LEFT]==true) head.translateX-=10
//        if (keysMap[KeyCode.RIGHT]==true) head.translateX+=10


        if (head.boundsInParent.intersects(food.boundsInParent)){
            food.translateX = Random.nextDouble(10.0,480.0)
            food.translateY = Random.nextDouble(10.0,480.0)
            snake.add(tail)
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

