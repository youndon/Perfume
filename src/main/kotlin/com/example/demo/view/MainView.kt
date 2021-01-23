package com.example.demo.view

import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.scene.text.Font
import javafx.util.Duration
import tornadofx.*
import java.awt.Button
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.concurrent.thread
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() {  launch<MainTic>()  }

class MainTic:App(MainView::class)
class MainView:View() {
    private val song = Media(Paths.get("Coldplay-Flags.mp3").toUri().toString())
    private val mediaPlayer = MediaPlayer(song)
    override val root = form {
        setPrefSize(500.0,100.0)
        mediaPlayer.isAutoPlay=true
        mediaPlayer.volume=0.0
        mediaPlayer.cycleCount=1
        mediaPlayer.balance=0.0
        mediaPlayer.rate= 1.0
        mediaPlayer.currentRate
        mediaPlayer.bufferProgressTime
        mediaPlayer.startTime= Duration.seconds(0.0)
        mediaPlayer.stopTime= song.duration
        mediaPlayer.seek(Duration.seconds(50.0))
        mediaPlayer.setOnPlaying {
            title = "${song.metadata["artist"].toString()}-${song.metadata["title"].toString()}"
            text ("") {
                thread {
                    (0..song.duration.toSeconds().toInt()).forEach {
                        text = (it.toDouble()).toString()
                        Thread.sleep(1000)
                    }
                }
            }
            progressbar {
                setPrefSize(400.0,1.0)
                thread {
                    (0..song.duration.toSeconds().toInt()).forEach { it ->
                        progress = it.toDouble()/song.duration.toSeconds().toInt()
                        Thread.sleep(1000)
                    }
                }
            }
        }

        button("done").action {
        }
        button("dispose").action {
            mediaPlayer.dispose()
        }
    }

}