package com.example.demo.view

import com.example.demo.box.BC
import javafx.beans.InvalidationListener
import javafx.event.Event
import javafx.event.EventType
import javafx.scene.control.Label
import javafx.scene.input.KeyEvent
import tornadofx.*
import javafx.animation.Animation

import javafx.animation.KeyFrame

import java.time.LocalTime

import javafx.animation.Timeline
import javafx.event.ActionEvent

import javafx.fxml.FXML
import javafx.scene.Parent
import javafx.util.Duration.*
import java.time.Duration


fun main() {
    launch<MainLand>()
}
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    val time = arrayListOf(BC().ss(), BC().s())
    var txt = Label()
    override val root = hbox {

        label {
            val ss = Timeline(
                KeyFrame(
                    ZERO, {
//                            LocalTime.now().hour.toString() + ":" + LocalTime.now().minute.toString() + ":" + LocalTime.now().second.toString()
                    }),
                KeyFrame(seconds(1.0))
            )
            ss.cycleCount = Animation.INDEFINITE
            ss.play()
        }
    }

}
//    override val root = hbox {
//        setPrefSize(200.0, 200.0)
//        time.forEach {
//            vbox {
//                it.forEach {
//                    label {
//                        text = it.toString()
//                        style {
//                            fontSize = 35.px
//                        }
//                    }
//                }
//            }
//        }
//    }
