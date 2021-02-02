package com.example.demo.view

import javafx.application.Application
import javafx.beans.value.ChangeListener
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.input.KeyCode
import javafx.scene.paint.Color
import javafx.scene.text.Font
import net.objecthunter.exp4j.ExpressionBuilder
import tornadofx.*
import kotlin.math.absoluteValue
import javafx.beans.value.ObservableValue
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.layout.*

import javafx.scene.layout.TilePane
import javafx.scene.text.TextAlignment

import javafx.stage.Stage
import javafx.stage.StageStyle
import java.awt.Label
import java.awt.TextField
import java.awt.event.ActionEvent
import java.beans.EventHandler
import java.nio.channels.SelectableChannel

fun main() {
    launch<Appeana_Calculator>()
}
class Appeana_Calculator:App(CalculatorView::class)
class CalculatorView() : View() {
    // the buttons:
    val list = listOf(
        listOf("AV", "(", ")", "AC"),
        listOf("7", "8", "9", "/"),
        listOf("4", "5", "6", "*"),
        listOf("1", "2", "3", "-"),
        listOf("0", ".", "=", "+")
    )
    override val root = vbox {
        setPrefSize(400.0, 500.0)
        primaryStage.isResizable = false
        primaryStage.initStyle(StageStyle.TRANSPARENT)
        val input = textfield() {
            alignment = Pos.CENTER_RIGHT
            prefHeight = 70.0
            font = Font.font("Ubuntu Light", 40.0)
            style {
                textFill = Color.WHITE
                backgroundColor += Color.DARKSLATEGRAY
            }

            // to filter type of input(Numbers & MathematicsSymbols).
            textProperty().onChange {
                if (!text.matches("\\d*".toRegex())) {
                    text = text.replace("[^\\d+*/\\-().^%e]".toRegex(), "")
                }
            }
        }
        val result = label("0") {
            minHeight = 70.0
            style {
                useMaxWidth = true
                paddingRight = 10.0
                alignment = Pos.CENTER_RIGHT
                font = Font.font("Ubuntu Light", 33.0)
                textFill = Color.WHITE
                backgroundColor += Color.DARKSLATEGRAY
            }
        }

        //
        setOnKeyPressed {
            when (it.code) {
                KeyCode.ENTER -> try {
                    result.text = ExpressionBuilder(input.text).build().evaluate().toBigDecimal().toString()
                    input.clear()
                } catch (ex: Exception) {
                    result.text = "0"
                    input.clear()
                }
            }
        }
        gridpane {
            list.forEach {
                row {
                    style {
                        paddingRight = 20
                        paddingBottom = 7
                        backgroundColor += Color.DARKSLATEGRAY
                    }
                    it.toList().forEach {
                        button(it.toString()) {
                            setPrefSize(100.0, 100.0)
                            style {
                                font = Font.font("Ubuntu Light", 23.0)
                                textFill = Color.BLACK
//                                backgroundRadius += CssBox(10.px, 10.px, 10.px, 10.px)
                            }
                            action {
                                if (it == "=") {
                                    try {
                                        result.text =
                                            ExpressionBuilder(input.text).build().evaluate().toBigDecimal().toString()
                                        input.clear()
                                    } catch (ex: Exception) {
                                        result.text = "0"
                                        input.clear()
                                    }
                                } else if (it == "C") {
                                    result.text = "0"
                                    input.clear()
                                } else {
                                    input.text += it
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}