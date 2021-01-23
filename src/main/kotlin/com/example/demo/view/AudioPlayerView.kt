package com.example.demo.view

import javafx.geometry.Pos
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import tornadofx.*
import java.nio.file.Paths

class AudioPlayerView:View() {
    private val song = Media(Paths.get("Coldplay-Flags.mp3").toUri().toString())
    private val mediaplayer = MediaPlayer(song)
    override val root = borderpane {
        minHeight=100.0
        minWidth=500.0
            top {
                hbox {
                    paddingTop=20.0
                    alignment=Pos.CENTER
                    label("../..") {
                        paddingRight=15.0
                    }
                    progressbar {
                        setPrefSize(400.0,0.0)

                    }
                    label("../..") {
                        paddingLeft=15.0
                    }
                }
            }
            bottom {
                hbox {
                    alignment= Pos.CENTER
                    paddingBottom=10.0
                    button("play").action {
                        mediaplayer.play()
                    }
                    button("resume").action{
                    }
                    button("<<")
                    button("stop").action {
                    }
                    button(">>") {  }
                    button("loop").action {
                    }

                }
            }
        }


}