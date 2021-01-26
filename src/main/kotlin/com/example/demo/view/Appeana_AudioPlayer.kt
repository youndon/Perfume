package com.example.demo.view

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time
import javafx.application.Platform
import javafx.beans.InvalidationListener
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundImage
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.scene.paint.Color
import tornadofx.*
import java.awt.Button
import java.io.File
import java.net.URI
import java.net.URL
import java.nio.file.Paths
import java.text.SimpleDateFormat
import kotlin.concurrent.thread
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

fun main() {
    launch<AudioApp>()
}
class AudioApp:App(Appeana_AudioPlayer::class)
class Appeana_AudioPlayer:View() {
    private val song = Media(Paths.get("Coldplay-Flags.mp3").toUri().toString())
    private val mediaplayer = MediaPlayer(song)
    private var play = button(){
        style{
            setPrefSize(20.0,20.0)
            backgroundColor+= Color.BLACK
            shape = "M12 22C6.47967 21.994 2.00606 17.5204 2 12V11.8C2.10993 6.30455 6.63459 1.92797 12.1307 2.0009C17.6268 2.07382 22.0337 6.5689 21.9978 12.0654C21.9619 17.5618 17.4966 21.9989 12 22ZM11.984 20H12C16.4167 19.9956 19.9942 16.4127 19.992 11.996C19.9898 7.57931 16.4087 4.00002 11.992 4.00002C7.57528 4.00002 3.99421 7.57931 3.992 11.996C3.98979 16.4127 7.56729 19.9956 11.984 20ZM15 16H13V8.00002H15V16ZM11 16H9V8.00002H11V16Z"
        }
    }
    private var totaltime = label("")
    @ExperimentalTime
    override val root = gridpane {
        primaryStage.minWidth=500.0
        setPrefSize(500.0, 100.0)
        mediaplayer.isAutoPlay = true

        // title this song:
        mediaplayer.setOnPlaying { // this method use jest once for the class.
            title = "${song.metadata["artist"].toString()}-${song.metadata["title"].toString()}"
            mediaplayer.currentTimeProperty().addListener(InvalidationListener {
               totaltime.text = SimpleDateFormat("ss")
                    .parse(mediaplayer.totalDuration.toSeconds().toString())
                    .toString()
                    .drop(11)
                    .dropLast(9)
                   .trimStart { it=='0' }
                   .trimStart { it==':' }
            }).toString()

        }
        row {

        }
        row {
            alignment=Pos.CENTER
            hbox {
                // currentTime of this media:
                label {
                    mediaplayer.currentTimeProperty().addListener(InvalidationListener {
                        text = SimpleDateFormat("ss")
                            .parse(mediaplayer.currentTime.toSeconds().toString())
                            .toString()
                            .drop(11)
                            .dropLast(9)
                            .trimStart { it=='0' }
                            .trimStart { it==':' }
                    })
                }
                // time slider:
                slider() {
                    setPrefSize(400.0,10.0)
                    mediaplayer.currentTimeProperty().addListener(InvalidationListener {
                        value = mediaplayer.currentTime.toSeconds() / mediaplayer.totalDuration.toSeconds() * 100
                    })
                    valueProperty().addListener(InvalidationListener {
                        if (isPressed) {
                            mediaplayer.seek(mediaplayer.media.duration.multiply(value / 100))
                        }
                    })
                }

                // totalDuration of this media:
               children.add(totaltime)
            }
        }
        row {
            hbox {
                paddingTop=20.0
                alignment=Pos.BOTTOM_CENTER

                // play/resume button:
                children.add(play)
                    play.action {
                        if (mediaplayer.status==MediaPlayer.Status.PLAYING){
                            mediaplayer.pause()
                            play.style{
                                setPrefSize(20.0,20.0)
                                backgroundColor+= Color.BLACK
                                shape = "M12 22C6.47715 22 2 17.5228 2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12C21.9939 17.5203 17.5203 21.9939 12 22ZM4 12.172C4.04732 16.5732 7.64111 20.1095 12.0425 20.086C16.444 20.0622 19.9995 16.4875 19.9995 12.086C19.9995 7.68451 16.444 4.10977 12.0425 4.086C7.64111 4.06246 4.04732 7.59876 4 12V12.172ZM10 16.5V7.5L16 12L10 16.5Z"
                            }
                        } else if (mediaplayer.status==MediaPlayer.Status.PAUSED || mediaplayer.status==MediaPlayer.Status.HALTED || mediaplayer.status== MediaPlayer.Status.STOPPED){
                            mediaplayer.play()
                            play.style {
                                setPrefSize(20.0,20.0)
                                backgroundColor+= Color.BLACK
                                shape = "M12 22C6.47967 21.994 2.00606 17.5204 2 12V11.8C2.10993 6.30455 6.63459 1.92797 12.1307 2.0009C17.6268 2.07382 22.0337 6.5689 21.9978 12.0654C21.9619 17.5618 17.4966 21.9989 12 22ZM11.984 20H12C16.4167 19.9956 19.9942 16.4127 19.992 11.996C19.9898 7.57931 16.4087 4.00002 11.992 4.00002C7.57528 4.00002 3.99421 7.57931 3.992 11.996C3.98979 16.4127 7.56729 19.9956 11.984 20ZM15 16H13V8.00002H15V16ZM11 16H9V8.00002H11V16Z"
                            }
                        }
                    }
                // stop button:
                    button("stop").action {
                        mediaplayer.stop()
                        play.style{
                            setPrefSize(20.0,20.0)
                            backgroundColor+= Color.BLACK
                            shape = "M12 22C6.47715 22 2 17.5228 2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12C21.9939 17.5203 17.5203 21.9939 12 22ZM4 12.172C4.04732 16.5732 7.64111 20.1095 12.0425 20.086C16.444 20.0622 19.9995 16.4875 19.9995 12.086C19.9995 7.68451 16.444 4.10977 12.0425 4.086C7.64111 4.06246 4.04732 7.59876 4 12V12.172ZM10 16.5V7.5L16 12L10 16.5Z"
                        }
                    }
                // mute button:
                    button("mute").action {
                        if (!mediaplayer.isMute) {
                            mediaplayer.isMute = true
                        } else if (mediaplayer.isMute) {
                            mediaplayer.isMute = false
                        }
                    }
                // volume slider:
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