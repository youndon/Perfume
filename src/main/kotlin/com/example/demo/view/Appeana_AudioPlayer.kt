package com.example.demo.view

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time
import javafx.application.Platform
import javafx.beans.InvalidationListener
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import tornadofx.*
import java.awt.Button
import java.nio.file.Paths
import kotlin.concurrent.thread

fun main() {
    launch<AudioApp>()
}
class AudioApp:App(Appeana_AudioPlayer::class)
class Appeana_AudioPlayer:View() {
    private val song = Media(Paths.get("Coldplay-Flags.mp3").toUri().toString())
    private val mediaplayer = MediaPlayer(song)
    private var play = button("||")
    override val root = gridpane {
        primaryStage.minWidth=500.0
        setPrefSize(500.0, 100.0)
        mediaplayer.isAutoPlay = true
        // title this song:
        mediaplayer.setOnPlaying { // this method use jest once for the class.
            title = "${song.metadata["artist"].toString()}-${song.metadata["title"].toString()}"
        }

        // time slider:
        row {
            alignment=Pos.CENTER
            hbox {
                slider() {
                    setPrefSize(400.0,10.0)
                    mediaplayer.currentTimeProperty().addListener(InvalidationListener {
                        value = mediaplayer.currentTime.toSeconds() / mediaplayer.totalDuration.toSeconds() * 100
                    })
                    valueProperty().addListener(InvalidationListener {
                        if (isPressed) {
                            mediaplayer.seek(mediaplayer.media.duration.multiply(this.value / 100))
                        }
                    })
                }
                label {
                    text = "..."
                }
            }
        }
        // volume slider:
        row {
            hbox {
                paddingTop=20.0
                alignment=Pos.BOTTOM_CENTER
                children.add(play)
                    play.action {
                        if (mediaplayer.status==MediaPlayer.Status.PLAYING){
                            mediaplayer.pause()
                            play.text=">"
                        } else if (mediaplayer.status==MediaPlayer.Status.PAUSED ||
                                    mediaplayer.status==MediaPlayer.Status.HALTED ||
                                      mediaplayer.status== MediaPlayer.Status.STOPPED){
                            mediaplayer.play()
                            play.text="||"
                        }
                    }
                    button("stop").action {
                        mediaplayer.stop()
                        play.text=">"
                    }
                    button("mute").action {
                        if (!mediaplayer.isMute) {
                            mediaplayer.isMute = true
                        } else if (mediaplayer.isMute) {
                            mediaplayer.isMute = false
                        }
                    }
                    slider() {
                        setPrefSize(60.0, 10.0)
                        adjustValue(30.0)
                        valueProperty().addListener(InvalidationListener {
                            if (isPressed) {
                                mediaplayer.volume = value / 100
                            }
                        })
                    }
                }
            }
        }

}