package com.example.demo.view

import AppeanaFx.s.Selectable
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
import javafx.scene.layout.Border
import javafx.scene.layout.BorderStroke

import javafx.scene.layout.TilePane
import javafx.scene.text.TextAlignment

import javafx.stage.Stage
import java.awt.Label
import java.awt.TextField
import java.awt.event.ActionEvent
import java.beans.EventHandler
import java.nio.channels.SelectableChannel


@Suppress("NON_EXHAUSTIVE_WHEN")
open class MainView() : View("MainView!!") {

    override val root = form {
        setPrefSize(400.0, 500.0)
        primaryStage.isResizable = false

        val input = textfield() {
            alignment = Pos.CENTER_RIGHT
            prefHeight = 70.0
            font = Font.font(30.0)

            // to filter type of input(Numbers & MathematicsSymbols).
            textProperty().onChange {
                    if (!text.matches("\\d*".toRegex())) {
                        text = text.replace("[^\\d+*/\\-().^%!]".toRegex(), "")
                    }
                }
        }
        val result = label("0") {
            prefHeight = 70.0
            font = Font.font(30.0)
            }


        setOnKeyPressed {
            when (it.code) {
                KeyCode.ENTER ->  try {
                    result.text =ExpressionBuilder(input.text).build().evaluate().toString()
                    input.clear()
                } catch (ex: Exception) {
                   result.text = "0"
                   input.clear()
                }
            }
        }

        buttonbar { button("pro").action { tooltip("coming soon") };button("(").action { input.text+="(" };button(")").action { input.text+=")" };button("C").action { input.clear() } }
        buttonbar { button("7").action { input.text+="7" };button("8").action { input.text+="8" };button("9").action { input.text+="9" };button("/").action { input.text+="/" } }
        buttonbar { button("4").action { input.text+="4" };button("5").action { input.text+="5" };button("6").action { input.text+="6" };button("*").action { input.text+="*" } }
        buttonbar { button("1").action { input.text+="1" };button("2").action { input.text+="2" };button("3").action { input.text+="3" };button("-").action { input.text+="-" } }
        buttonbar { button("0").action { input.text+="0" };button(".").action { input.text+="." };
            button("=").action {
                 try {
                     result.text =ExpressionBuilder(input.text).build().evaluate().toString()
                    input.clear()
                } catch (ex: Exception) {
                     result.text = "0"
                     input.clear()
                 }
            };button("+").action { input.text+="+" } }


    }
}

