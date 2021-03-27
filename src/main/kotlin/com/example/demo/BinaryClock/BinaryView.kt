package com.example.demo.BinaryClock

import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.util.Duration
import tornadofx.*
class BinaryView: UIComponent(){
    override val root = hbox {
        setPrefSize(230.0,170.0)
        (0..5).forEach { ti ->
            label {
                val ss = Timeline(
                    KeyFrame(Duration.ZERO, {
                        when (ti) {
                            0 -> {text = BinaryControl().hh().replaceFirst('◯',' ').replaceFirst('◯',' ')}
                            1 -> {text = BinaryControl().h().replaceFirst('◯',' ')}
                            2 -> {text = BinaryControl().mm().replaceFirst('◯',' ')}
                            3 -> {text = BinaryControl().m()}
                            4 -> {text = BinaryControl().ss().replaceFirst('◯',' ')}
                            5 -> {text = BinaryControl().s()}
                        }
                    }),
                    KeyFrame(Duration.seconds(1.0))
                )
                ss.cycleCount = Animation.INDEFINITE
                ss.play()
                style{
                    fontSize = 2.pc
                }
            }
        }
    }

}

