package com.example.demo.view

import javafx.beans.InvalidationListener
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.scene.paint.Color
import javafx.stage.FileChooser
import javafx.stage.Stage
import tornadofx.*
import java.nio.file.Paths
import java.text.SimpleDateFormat

fun main() {
    launch<MainLand>()
}
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent(){
    override val root =vbox {

    }
}
