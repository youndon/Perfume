package com.example.demo.Calculator

import javafx.geometry.Pos
import javafx.scene.input.KeyCode
import javafx.scene.paint.Color
import javafx.scene.text.Font
import net.objecthunter.exp4j.ExpressionBuilder
import tornadofx.*

class CalculatorView() : UIComponent() {
    // the buttons:
    val list = listOf(
        listOf("AV", "(", ")", "C"),
        listOf("7", "8", "9", "/"),
        listOf("4", "5", "6", "*"),
        listOf("1", "2", "3", "-"),
        listOf("0", ".", "=", "+")
    )
    override val root = vbox {
        setPrefSize(400.0, 500.0)
        primaryStage.isResizable = false
        val input = textfield() {
            alignment = Pos.CENTER_RIGHT
            prefHeight = 70.0
            font = Font.font("Ubuntu Light", 40.0)
            style {
                textFill = Color.WHITE
                backgroundColor += Color.DARKSLATEGRAY
            }

            // to filter type of input(Numbers & MathematicsSymbols) only.
            textProperty().onChange {
                if (!text.matches("\\d*".toRegex())) {
                    text = text.replace("[^\\d+*/\\-().]".toRegex(),"")
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
        // To show the result when enter key preesed.
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