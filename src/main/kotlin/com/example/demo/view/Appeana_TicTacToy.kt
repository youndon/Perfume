package com.example.demo.view

import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.paint.Color
import javafx.scene.shape.Shape
import javafx.scene.text.Font
import javafx.stage.Stage
import tornadofx.*
import kotlin.reflect.KClass

fun main() { launch<MainApp>() }

class MainApp: App(Appeana_TicTacToy::class)

class Appeana_TicTacToy : View() {
    val circle = "M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"
    val close = "M17.59 5L12 10.59L6.41 5L5 6.41L10.59 12L5 17.59L6.41 19L12 13.41L17.59 19L19 17.59L13.41 12L19 6.41L17.59 5Z"
    var myshape = close
    override val root = vbox {
        (0..2).forEach { _ ->
            buttonbar {
                (0..2).forEach { _ ->
                    button {
                        style {
                            setPrefSize(100.0, 100.0)
                        }
                        action {
                            if (this.shapeProperty().isNotDirty) {
                                if (myshape == close) {
                                    this.style {
                                        shape = myshape
                                        backgroundColor += Color.RED
                                        myshape = circle
                                    }
                                } else if (myshape==circle){
                                    this.style {
                                        shape=myshape
                                        backgroundColor += Color.BLUE
                                        myshape=close
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
