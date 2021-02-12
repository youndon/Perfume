package com.example.demo.view

import com.example.demo.box.BC
import javafx.beans.InvalidationListener
import javafx.event.Event
import javafx.event.EventType
import javafx.scene.control.Label
import javafx.scene.input.KeyEvent
import tornadofx.*

fun main() {
    launch<MainLand>()
}
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    val time = arrayListOf(BC().hh(),BC().h(),BC().mm(),BC().m(),BC().ss(),BC().s())
    override val root = hbox {
        setPrefSize(200.0, 200.0)
        time.forEach {
            vbox {
                it.forEach {
                    label {
                        text = it.toString()
                        style {
                            fontSize = 35.px
                        }
                    }
                }
                }
            }
        }
}