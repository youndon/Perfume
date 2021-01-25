package com.example.demo.view

import javafx.application.Platform
import javafx.beans.InvalidationListener
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.scene.text.Font
import javafx.stage.FileChooser
import javafx.util.Duration
import tornadofx.*
import java.awt.Button
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() {  launch<MainTic>()  }

class MainTic:App(MainView::class)
class MainView:View() {
    private var song : Media? = Media(Paths.get(FileChooser().showOpenDialog(primaryStage).toURI().toURL().toString()).toUri().toString())
    private val mediaPlayer = MediaPlayer(song)
    override val root = form {
        setPrefSize(500.0, 100.0)

            // select media:
            button("open file!").action{
                mediaPlayer.pause()

            }

        }


    }
