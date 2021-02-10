package com.example.demo.view

import com.example.demo.box.SnakeGame
import javafx.beans.InvalidationListener
import javafx.beans.value.ObservableValue
import javafx.event.Event
import javafx.event.EventDispatchChain
import javafx.event.EventTarget
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Rectangle
import javafx.stage.FileChooser
import javafx.stage.Stage
import jdk.jfr.EventType
import org.opencv.core.Core
import org.opencv.core.Core.rectangle
import sun.audio.AudioPlayer.player
import tornadofx.*
import tornadofx.Stylesheet.Companion.root
import java.nio.file.Paths
import java.text.SimpleDateFormat
import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    launch<MainLand>()
}
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    var head = Rectangle()
    var tail = Rectangle()
    private var snake = arrayListOf<Rectangle>()
    private var food = Circle()
    private val keysMap = hashMapOf<KeyCode,Boolean>()
    override val root =vbox {
        setPrefSize(500.0, 500.0)
        head = rectangle(0,0,20.0,20.0)
        snake.add(head)
        canvas {
            snake.forEach {
                it.fill = Color.HOTPINK
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
        if (keysMap[KeyCode.UP] == true) snake.first().translateY -= 10
        if (keysMap[KeyCode.DOWN] == true) snake.first().translateY += 10
        if (keysMap[KeyCode.LEFT] == true) snake.first().translateX -= 10
        if (keysMap[KeyCode.RIGHT] == true) snake.first().translateX += 10

        if (snake[0].boundsInParent.intersects(food.boundsInParent)) {
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