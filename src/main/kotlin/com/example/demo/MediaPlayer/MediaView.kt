package com.example.demo.MediaPlayer

import javafx.beans.InvalidationListener
import javafx.geometry.Pos
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.scene.paint.Color
import javafx.stage.FileChooser
import javafx.stage.Stage
import tornadofx.*
import java.nio.file.Paths
import java.text.SimpleDateFormat

class MediaView: UIComponent() {
    private var mediaplayer: MediaPlayer? = null
    private var totaltime = label("--:--")
    private var currenttime = label("--:--")
    private var slider = slider {
        setPrefSize(400.0, 10.0)
        valueProperty().addListener(InvalidationListener {
            if (isPressed) {
                mediaplayer?.seek(mediaplayer?.media!!.duration.multiply(value / 100))
            }
        })
    }
    private var volumeslder = slider {
        setPrefSize(70.0, 10.0)
        adjustValue(30.0)
        valueProperty().addListener(InvalidationListener {
            if (isPressed) {
                mediaplayer?.volume = value / 100
            }
        })
    }
    private var playbutton = button {
        style {
            backgroundColor.plusAssign(Color.BLACK)
            shape = Max.PLAY.shape
        }
    }
    private val buttons = listOf(Max.PRIVIES, Max.STOP, Max.NEXT, Max.OPEN, Max.SETTING, Max.LOOP, Max.MUTE)

    override val root = gridpane {
        primaryStage.minWidth = 500.0
        setPrefSize(500.0, 100.0)
        row {
            hbox {
                alignment = Pos.CENTER
                paddingTop = 20.0 ; paddingLeft = 16.0
                children.add(currenttime)
                children.add(slider)
                children.add(totaltime)
            }
        }
        row {
            hbox {
                spacing = 20.0
                paddingTop = 25.0
                this.alignment = Pos.BOTTOM_CENTER
                useMaxWidth=true
                children.add(playbutton)
                playbutton.action {
                    if (mediaplayer?.status == MediaPlayer.Status.PLAYING) {
                        mediaplayer?.pause()
                        playbutton.style {
                            backgroundColor.plusAssign(Color.BLACK)
                            shape = Max.PLAY.shape
                        }
                    } else if (mediaplayer?.status == MediaPlayer.Status.PAUSED || mediaplayer?.status == MediaPlayer.Status.HALTED || mediaplayer?.status == MediaPlayer.Status.STOPPED) {
                        mediaplayer?.play()
                        playbutton.style {
                            backgroundColor.plusAssign(Color.BLACK)
                            shape = Max.PAUSE.shape
                        }
                    }
                }
                buttons.forEach {
                    button {
                        style {
                            backgroundColor.plusAssign(Color.BLACK)
                            shape = it.shape
                        }
                        action {
                            if (it.id == "open") {
                                mediaplayer?.stop()
                                mediaplayer = open(primaryStage)
                                mediaplayer?.isAutoPlay = true
                                mediaplayer?.setOnPlaying { // this method use jest once for the class.
                                    title =
                                        "${mediaplayer!!.media.metadata["artist"].toString()}-${mediaplayer!!.media.metadata["title"].toString()}"
                                    playbutton.style {
                                        backgroundColor.plusAssign(Color.BLACK)
                                        shape = Max.PAUSE.shape
                                    }
                                }
                                mediaplayer?.currentTimeProperty()!!.addListener(InvalidationListener {
                                    currenttime.text = SimpleDateFormat("ss")
                                        .parse(mediaplayer?.currentTime!!.toSeconds().toString())
                                        .toString().drop(11).dropLast(9)
                                        .trimStart { it == '0' }
                                        .trimStart { it == ':' }
                                    totaltime.text = SimpleDateFormat("ss")
                                        .parse(mediaplayer?.totalDuration!!.toSeconds().toString())
                                        .toString().drop(11).dropLast(9)
                                        .trimStart { it == '0' }
                                        .trimStart { it == ':' }
                                    slider.value =
                                        mediaplayer?.currentTime!!.toSeconds() / mediaplayer?.totalDuration!!.toSeconds() * 100
                                })
                            } else if (it.id == "stop") {
                                mediaplayer?.stop()
                                playbutton.style {
                                    backgroundColor.plusAssign(Color.BLACK)
                                    shape = Max.PLAY.shape
                                }
                            } else if (it.id == "mute") {
                                if (mediaplayer?.isMute == false) {
                                    mediaplayer?.isMute = true
                                    this.style {
                                        backgroundColor.plusAssign(Color.BLACK)
                                        shape = Max.MUTE_OFF.shape
                                    }
                                } else if (mediaplayer?.isMute == true) {
                                    mediaplayer?.isMute = false
                                    this.style {
                                        backgroundColor.plusAssign(Color.BLACK)
                                        shape = Max.MUTE.shape
                                    }
                                }
                            }
                        }
                    }
                }
                children.add(volumeslder)
            }
        }
    }
    companion object{
        fun open(stage: Stage?) =
            MediaPlayer(
                Media(
                    Paths.get(
                        FileChooser()
                            .showOpenDialog(stage)
                            .toURI()
                            .toURL()
                            .toExternalForm()
                    ).toString()
                )
            )
    }
}
