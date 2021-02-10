package com.example.demo.box

import javafx.stage.Stage
import javafx.scene.layout.VBox
import javafx.scene.canvas.GraphicsContext
import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.App
import tornadofx.launch
import java.lang.Exception
import java.util.*
import kotlin.jvm.JvmStatic

fun main() {
    launch<SnakeGame>()
}
class SnakeGame : App() {
    enum class Dir {
        LEFT, RIGHT, UP, DOWN
    }

    class Corner(var x: Int, var y: Int)

    override fun start(stage: Stage) {
        try {
            newfood()
            val root = VBox()
            val c = Canvas((width * cornersize).toDouble(), (height * cornersize).toDouble())
            val gc = c.graphicsContext2D
            root.children.add(c)
            object : AnimationTimer() {
                var lastTick: Long = 0
                override fun handle(now: Long) {
                    if (lastTick == 0L) {
                        lastTick = now
                        tick(gc)
                        return
                    }
                    if (now - lastTick > 100000 / speed) {
                        lastTick = now
                        tick(gc)
                    }
                }
            }.start()
            val scene = Scene(root, (width - cornersize).toDouble(), (height * cornersize).toDouble())

            // control
            scene.addEventFilter(KeyEvent.KEY_PRESSED) { key: KeyEvent ->
                if (key.code == KeyCode.UP) {
                    direction = Dir.UP
                }
                if (key.code == KeyCode.DOWN) {
                    direction = Dir.DOWN
                }
                if (key.code == KeyCode.LEFT) {
                    direction = Dir.LEFT
                }
                if (key.code == KeyCode.RIGHT) {
                    direction = Dir.RIGHT
                }
            }

            // add start snake part
            snake.add(Corner(width / 2, height / 2))
            snake.add(Corner(width / 2, height / 2))
            snake.add(Corner(width / 2, height / 2))
//            scene.stylesheets.add(javaClass.getResource("application.css").toExternalForm())
            stage.scene = scene
            stage.title = "Snake Game"
            stage.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        var speed = 5
        var foodcolor = 0
        var width = 20
        var height = 20
        var foodX = 0
        var foodY = 0
        var cornersize = 25
        var snake: MutableList<Corner> = ArrayList()
        var direction = Dir.LEFT
        var gameOver = false
        var rond = Random()

        // tick
        fun tick(gc: GraphicsContext) {
            if (gameOver) {
                gc.fill = Color.RED
                gc.font = Font("", 50.0)
                gc.fillText("Game Over", 100.0, 250.0)
                return
            }
            for (i in snake.size - 1 downTo 1) {
                snake[i].x = snake[i - 1].x
                snake[i].y = snake[i - 1].y
            }
            when (direction) {
                Dir.UP -> {
                    snake[0].y--
                    if (snake[0].y < 0) {
                        gameOver = true
                    }
                    snake[0].y++
                    if (snake[0].y > height) {
                        gameOver = true
                    }
                }
                Dir.DOWN -> {
                    snake[0].y++
                    if (snake[0].y > height) {
                        gameOver = true
                    }
                }
                Dir.LEFT -> {
                    snake[0].x--
                    if (snake[0].x < 0) {
                        gameOver = true
                    }
                    snake[0].x++
                    if (snake[0].x > width) {
                        gameOver = true
                    }
                }
                Dir.RIGHT -> {
                    snake[0].x++
                    if (snake[0].x > width) {
                        gameOver = true
                    }
                }
            }
            // eat food
            if (foodX == snake[0].x && foodY == snake[0].y) {
                snake.add(Corner(-1, -1))
                newfood()
            }
            // self destroy
            for (i in 1 until snake.size) {
                if (snake[0].x == snake[i].x && snake[0].y == snake[i].y) {
                    gameOver = true
                    break
                }
            }
            // fill
            // background
            gc.fill = Color.BLACK
            gc.fillRect(0.0, 0.0, (width * cornersize).toDouble(), (height * cornersize).toDouble())

            // score
            gc.fill = Color.WHITE
            gc.font = Font("", 30.0)
            gc.fillText("Score", +(speed - 6).toDouble(), 10.0, 30.0)

            //random color
            var cc = Color.WHITE
            if (foodcolor == 0) {
                cc = Color.ANTIQUEWHITE
            }
            gc.fill = cc
            gc.fillOval(
                (foodX * cornersize).toDouble(),
                (foodY * cornersize).toDouble(),
                cornersize.toDouble(),
                cornersize.toDouble()
            )

            // snake
            for (c in snake) {
                gc.fill = Color.LIGHTGREEN
                gc.fillRect(
                    (c.x * cornersize).toDouble(),
                    (c.y * cornersize).toDouble(),
                    (cornersize - 1).toDouble(),
                    (cornersize - 1).toDouble()
                )
                gc.fill = Color.GREEN
                gc.fillRect(
                    (c.x * cornersize).toDouble(),
                    (c.y * cornersize).toDouble(),
                    (cornersize - 2).toDouble(),
                    (cornersize - 2).toDouble()
                )
            }
        }

        // food
        fun newfood() {
            start@ while (true) {
                foodX = rond.nextInt(width)
                foodY = rond.nextInt(height)
                for (c in snake) {
                    if (c.x == foodX && c.y == foodY) {
                        continue@start
                    }
                }
                foodcolor = rond.nextInt(5)
                speed++
                break
            }
        }
    }
}