package com.example.demo.view

import appeanaLib.Coding
import com.github.sarxos.webcam.Webcam
import javafx.application.Platform
import javafx.concurrent.Task
import javafx.embed.swing.SwingFXUtils
import javafx.scene.Camera
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.control.RadioButton
import javafx.scene.control.TextArea
import javafx.scene.image.Image
import javafx.scene.text.Text
import tornadofx.*

fun main() {
        launch<MainLand>()
}
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent(){
    override val root = form{
        setPrefSize(300.0,300.0)
      borderpane {

      }
    }
}
