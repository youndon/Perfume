package com.example.demo.view

import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.text.Font
import javafx.stage.Stage
import tornadofx.*
import kotlin.reflect.KClass

fun main() { launch<MainApp>() }

class MainApp: App(Appeana_TicTacToy::class)

class Appeana_TicTacToy : View() {
    var cc = "❌"
    override val root = vbox {
           (0..2).forEach { _ ->
               buttonbar {
                   (0..2).forEach { _ ->
                       button("") {
                           setPrefSize(100.0, 100.0)
                           font = Font.font("Ubuntu", 35.0)
                           action {
                               if (text.isEmpty()) {
                                   if (cc == "❌") {
                                       text = cc
                                       cc = "Ｏ"
                                   } else if (cc == "Ｏ") {
                                       text = cc
                                       cc = "❌"
                                   }
                               }
                           }
                       }
                   }
               }
           }
    }
}
