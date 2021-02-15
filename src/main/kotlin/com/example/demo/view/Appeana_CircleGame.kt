package com.example.demo.view

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import tornadofx.*
import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    launch<CircleApp>()
}
class CircleApp: App(Appeana_CircleGame::class)
class Appeana_CircleGame: UIComponent(){
    private var player = Circle()
    private var food = Circle()
    private val keysMap = hashMapOf<KeyCode,Boolean>()
    override val root =vbox {
        setPrefSize(500.0,500.0)
        canvas {
            player =circle {
                radius =10.0
                fill = Color.HOTPINK
            }
            food = circle {
                radius = 10.0
                fill = Color.INDIGO
                translateX = Random.nextDouble(10.0,480.0)
                translateY = Random.nextDouble(10.0,480.0)
            }
        }
        addEventFilter(KeyEvent.ANY){
            keysMap[it.code] = it.eventType == KeyEvent.KEY_PRESSED
        }
    }
    private fun upDate(){

        if (keysMap[KeyCode.UP]==true) player.translateY-=10
        if (keysMap[KeyCode.DOWN]==true) player.translateY+=10
        if (keysMap[KeyCode.LEFT]==true) player.translateX-=10
        if (keysMap[KeyCode.RIGHT]==true) player.translateX+=10

        if (player.boundsInParent.intersects(food.boundsInParent)){
            food.translateX = Random.nextDouble(10.0,480.0)
            food.translateY = Random.nextDouble(10.0,480.0)
            player.radius+=3.0
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