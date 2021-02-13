package com.example.demo.view

import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.util.Duration.ZERO
import javafx.util.Duration.seconds
import tornadofx.*


fun main() {
    launch<MainLand>()
}
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    override val root = hbox {
        setPrefSize(230.0,170.0)
        (0..5).forEach { ti ->
            label {
                val ss = Timeline(
                    KeyFrame(ZERO, {
                            when (ti) {
                                0 -> {text = BC().hh().replaceFirst('◯',' ').replaceFirst('◯',' ')}
                                1 -> {text = BC().h().replaceFirst('◯',' ')}
                                2 -> {text = BC().mm().replaceFirst('◯',' ')}
                                3 -> {text = BC().m()}
                                4 -> {text = BC().ss().replaceFirst('◯',' ')}
                                5 -> {text = BC().s()}
                            }
                        }),
                    KeyFrame(seconds(1.0)))
                ss.cycleCount = Animation.INDEFINITE
                ss.play()
                style{
                    fontSize = 2.pc
                }
            }
        }
    }
}