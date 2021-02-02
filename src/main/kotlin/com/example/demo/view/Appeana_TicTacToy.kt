package com.example.demo.view

import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.layout.GridPane
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
    private val close =
        "M17.59 5L12 10.59L6.41 5L5 6.41L10.59 12L5 17.59L6.41 19L12 13.41L17.59 19L19 17.59L13.41 12L19 6.41L17.59 5Z"
    var myshape = close
    var box = arrayListOf(
        listOf(button(){id="7"},button(){id="8"},button(){id="9"}),
        listOf(button(){id="4"},button(){id="5"},button(){id="6"}),
        listOf(button(){id="1"},button(){id="2"},button(){id="3"})
    )

    override val root = vbox {
        buttonbar {
            paddingRight = 50.0
            button("reset!") {
                setPrefSize(200.0, 60.0)
                style {
                    fontSize = 20.pt //Dimension(10.0,Dimension.LinearUnits.px)
                    fontFamily = "Ubuntu_Light"
                    backgroundColor += Color.DARKGRAY
                    backgroundRadius += CssBox(30.px, 30.px, 30.px, 30.px)
                }
                action {
                    box.forEach { list ->
                        list.forEach {
                            it.style {
                                shape = ""
                            }
                        }
                    }
                }
            }
        }
        gridpane {
            box.forEach {
                row {
                    it.forEach {
                        children.add(it)
                        it.setPrefSize(100.0, 100.0)
                           it.action {
                            if (it.shapeProperty().isNotDirty) {
                                if (myshape == close) {
                                    it.style {
                                        shape = myshape
                                        backgroundColor += Color.RED
                                        myshape = circle
                                    }
                                } else if (myshape == circle) {
                                    it.style {
                                        shape = myshape
                                        backgroundColor += Color.BLUE
                                        myshape = close
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