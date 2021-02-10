package com.example.demo.snakeGame

import com.hegyi.botond.controllers.SettingsViewController
import com.sun.javafx.scene.traversal.Direction
import javafx.animation.AnimationTimer
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.geometry.Point2D
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.stage.Stage
import java.io.IOException
import java.util.prefs.Preferences
import kotlin.system.exitProcess

class GameScene(root: Parent) : Scene(root) {
    private val gc: GraphicsContext
    private val canvas: Canvas
    private val WIDTH = 1000
    private val HEIGHT = 700
    private val food: Food
    var snake: Snake? = null
        private set
    private var inGame = false
    private var paused = false
    var isGameOver = false
        private set
    private var score = 0
    private val foodPoint = 100
    private val timer: myTimer
    private var time: Long = 0
    private val prefs: Preferences = Preferences.userRoot().node(SettingsViewController::class.java.name)
    private val UP = "UP"
    private val DOWN = "DOWN"
    private val RIGHT = "RIGHT"
    private val LEFT = "LEFT"
    private var pauseLabel: Label? = null
    private var gameOverLabel: Label? = null
    private var scoreLabel: Label? = null
    private var inGameScoreLabel: Label? = null
    private val myHandlerForArrows = MyHandlerForArrows()
    private val myHandlerForEsc = MyHandlerForEsc()

    constructor(root: Parent, time: Long) : this(root) {
        this.time = time
    }

    init {
        canvas = Canvas(WIDTH.toDouble(), HEIGHT.toDouble())
        (root as Pane).children.add(canvas)
        gc = canvas.graphicsContext2D
        food = Food(PIXELSIZE.toDouble(), PIXELSIZE.toDouble())
        timer = myTimer()

        // check user inputs on the first screen
        addEventHandler(KeyEvent.KEY_PRESSED, myHandlerForArrows)
        addEventHandler(KeyEvent.KEY_PRESSED, myHandlerForEsc)
        initLabels()
        initScreen()
    }


    fun setTime(time: Long) {
        this.time = time
    }

    private fun initLabels() {
        pauseLabel = Label("Paused")
        pauseLabel!!.layoutX = (WIDTH / 2f - 25).toDouble()
        pauseLabel!!.layoutY = (HEIGHT / 2f).toDouble()
        pauseLabel!!.stylesheets.add(javaClass.classLoader.getResource("styles/overallStyle.css").toString())
        gameOverLabel = Label("Game Over!")
        gameOverLabel!!.layoutX = (WIDTH / 2f - 75).toDouble()
        gameOverLabel!!.layoutY = (HEIGHT / 2f - 40).toDouble()
        gameOverLabel!!.stylesheets.add(javaClass.classLoader.getResource("styles/overallStyle.css").toString())
        scoreLabel = Label()
        scoreLabel!!.layoutX = (WIDTH / 2f - 125).toDouble()
        scoreLabel!!.layoutY = (HEIGHT / 2f - 10).toDouble()
        scoreLabel!!.stylesheets.add(javaClass.classLoader.getResource("styles/overallStyle.css").toString())
        if (prefs.getBoolean("renderScore", true)) {
            inGameScoreLabel = Label()
            inGameScoreLabel!!.id = "inGameScoreLabel"
            inGameScoreLabel!!.layoutX = 0.0
            inGameScoreLabel!!.layoutY = 0.0
            inGameScoreLabel!!.stylesheets.add(javaClass.classLoader.getResource("styles/overallStyle.css").toString())
            (root as AnchorPane).children.add(inGameScoreLabel)
        }
    }

    private fun initScreen() {
        score = 0
        if (prefs.getBoolean("renderScore", true)) {
            inGameScoreLabel!!.text = "Score: " + score + "pt."
        }
        renderBackground()
        initSnake()
        food.setRandomPosition(WIDTH, HEIGHT)
        renderGameElements()
    }

    private fun renderBackground() {
        gc.fill = Color.BLACK
        gc.fillRect(0.0, 0.0, WIDTH.toDouble(), HEIGHT.toDouble())
        renderGrid(gc)
    }

    private fun initSnake() {
        snake = Snake(
            Point2D((WIDTH / 2f).toDouble(), (HEIGHT / 2f).toDouble()),
            Point2D((WIDTH / 2f - PIXELSIZE).toDouble(), (HEIGHT / 2f).toDouble()), PIXELSIZE
        )
    }

    private fun renderGrid(gc: GraphicsContext) {
        gc.stroke = Color.GRAY
        run {
            var i = 0
            while (i < WIDTH) {
                gc.strokeLine(i.toDouble(), 0.0, i.toDouble(), HEIGHT.toDouble())
                i += PIXELSIZE
            }
        }
        var i = 0
        while (i < HEIGHT) {
            gc.strokeLine(0.0, i.toDouble(), WIDTH.toDouble(), i.toDouble())
            i += PIXELSIZE
        }
    }

    private fun checkSnake(): Boolean {
        val posX = snake!!.head.position.x
        val posY = snake!!.head.position.y
        return posX >= WIDTH || posX < 0 || posY >= HEIGHT || posY < 0
    }

    private fun renderGameElements() {
        snake!!.render(gc)
        food.render(gc)
        snake!!.render(gc)
    }

    private fun renderGameOverMsg() {
        scoreLabel!!.text = "Your score: $score"

        // TODO: add button for save
        val restartBtn = Button("Restart")
        restartBtn.layoutX = (WIDTH / 2f - 125).toDouble()
        restartBtn.layoutY = (HEIGHT / 2f + 50).toDouble()
        restartBtn.stylesheets.add(javaClass.classLoader.getResource("styles/GameOverStyle.css").toString())
        val exitBtn = Button("Exit")
        exitBtn.layoutX = (WIDTH / 2f - 50).toDouble()
        exitBtn.layoutY = (HEIGHT / 2f + 100).toDouble()
        exitBtn.stylesheets.add(javaClass.classLoader.getResource("styles/GameOverStyle.css").toString())
        val backBtn = Button("Back")
        backBtn.layoutX = (WIDTH / 2f + 30).toDouble()
        backBtn.layoutY = (HEIGHT / 2f + 50).toDouble()
        backBtn.stylesheets.add(javaClass.classLoader.getResource("styles/GameOverStyle.css").toString())
        exitBtn.onMouseClicked = EventHandler { exitProcess(0) }
        restartBtn.onMouseClicked = EventHandler {
            isGameOver = false
            (root as AnchorPane).children.removeAll(gameOverLabel, scoreLabel, restartBtn, exitBtn, backBtn)
            food.setRandomPosition(WIDTH, HEIGHT)
            addEventHandler(KeyEvent.KEY_PRESSED, myHandlerForArrows)
            initScreen()
        }
        backBtn.onMouseClicked = EventHandler { e: MouseEvent? ->
            val stage = window as Stage
            var root: Parent? = null
            try {
                root = FXMLLoader.load(javaClass.classLoader.getResource("views/WelcomeView.fxml"))
            } catch (e1: IOException) {
                MyLogger.WARN("views/WelcomeView.fxml file not found")
                exitProcess(0)
            }
            stage.scene = Scene(root)
            stage.centerOnScreen()
            stage.show()
        }
        (root as AnchorPane).children.addAll(gameOverLabel, scoreLabel, restartBtn, exitBtn, backBtn)
    }

    private inner class myTimer : AnimationTimer() {
        private var lastUpdate: Long = 0
        override fun start() {
            super.start()
            inGame = true
        }

        override fun handle(now: Long) {
            // if the game isn't paused it will refresh the screen in every 100 milliseconds
            if (now - lastUpdate >= time) {
                addEventHandler(KeyEvent.KEY_PRESSED, myHandlerForArrows)
                lastUpdate = now
                snake!!.move()
                if (snake!!.head.intersect(food)) {
                    do {
                        food.setRandomPosition(WIDTH, HEIGHT)
                    } while (snake!!.intersect(food))
                    score += foodPoint
                    snake!!.grow()
                    if (prefs.getBoolean("renderScore", true)) {
                        inGameScoreLabel!!.text = "Score: " + score + "pt."
                    }
                }
                renderGameElements()
                if (snake!!.collide() || checkSnake()) {
                    isGameOver = true
                }
                if (isGameOver) {
                    // stop the timer
                    stop()
                    renderGameOverMsg()
                }
            }
        }
    }

    private inner class MyHandlerForEsc : EventHandler<KeyEvent> {
        override fun handle(event: KeyEvent) {
            val kc = event.code
            if (kc == KeyCode.ESCAPE && inGame) {
                if (paused) {
                    timer.start()
                    (root as AnchorPane).children.remove(pauseLabel)
                } else {
                    timer.stop()
                    (root as AnchorPane).children.add(pauseLabel)
                }
                paused = !paused
            }
        }
    }

    private inner class MyHandlerForArrows : EventHandler<KeyEvent> {
        override fun handle(event: KeyEvent) {
            val kc = event.code
            val key = kc.toString()
            if ((key == prefs[RIGHT, ""] || key == prefs[LEFT, ""] || key == prefs[UP, ""] || key == prefs[DOWN, ""])
                && !isGameOver
            ) {
                timer.start()
                paused = false
            }
            if (key == prefs[RIGHT, ""] && snake!!.direction != Direction.LEFT) {
                snake!!.direction = Direction.RIGHT
            } else {
                if (key == prefs[LEFT, ""] && snake!!.direction != Direction.RIGHT) {
                    snake!!.direction = Direction.LEFT
                } else {
                    if (key == prefs[DOWN, ""] && snake!!.direction != Direction.UP) {
                        snake!!.direction = Direction.DOWN
                    } else {
                        if (key == prefs[UP, ""] && snake!!.direction != Direction.DOWN) {
                            snake!!.direction = Direction.UP
                        }
                    }
                }
            }
            removeEventHandler(KeyEvent.KEY_PRESSED, this)
        }
    }

    companion object {
        const val PIXELSIZE = 25
    }

}