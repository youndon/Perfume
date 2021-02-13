package com.example.demo.view

import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.util.Duration
import tornadofx.*
import java.time.LocalTime

fun main() {
    launch<BinaryClockApp>()
}
class BinaryClockApp:App(Appeana_BinaryClock::class)
class Appeana_BinaryClock:UIComponent(){
    override val root = hbox {
        setPrefSize(230.0,170.0)
        (0..5).forEach { ti ->
            label {
                val ss = Timeline(
                    KeyFrame(Duration.ZERO, {
                        when (ti) {
                            0 -> {text = BC().hh().replaceFirst('◯',' ').replaceFirst('◯',' ')}
                            1 -> {text = BC().h().replaceFirst('◯',' ')}
                            2 -> {text = BC().mm().replaceFirst('◯',' ')}
                            3 -> {text = BC().m()}
                            4 -> {text = BC().ss().replaceFirst('◯',' ')}
                            5 -> {text = BC().s()}
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
class BC {
    private fun go(): LocalTime = LocalTime.now()
    private fun binary(a:Any) : String {
        return when (a) {
            '1' -> "◯\n◯\n◯\n⬤"
            '2' -> "◯\n◯\n⬤\n◯"
            '3' -> "◯\n◯\n⬤\n⬤"
            '4' -> "◯\n⬤\n◯\n◯"
            '5' -> "◯\n⬤\n◯\n⬤"
            '6' -> "◯\n⬤\n⬤\n◯"
            '7' -> "◯\n⬤\n⬤\n⬤"
            '8' -> "⬤\n◯\n◯\n◯"
            '9' -> "⬤\n◯\n◯\n⬤"
            else -> "◯\n◯\n◯\n◯"
        }
    }
    // seconds.
    fun s():String {
        return binary(go().second.toString().last())
    }
    fun ss(): String {
        return if (go().second in 0..9) " \n◯\n◯\n◯"
        else binary(go().second.toString().first())
    }
    // minute.
    fun m():String {
        return binary(go().minute.toString().last())
    }
    fun mm(): String {
        return if (go().minute in 0..9) " \n◯\n◯\n◯"
        else binary(go().minute.toString().first())
    }
    // hours.
    fun h():String {
        return binary(go().hour.toString().last())
    }
    fun hh(): String {
        return if (go().hour in 0..9) " \n \n◯\n◯"
        else binary(go().hour.toString().first())
    }
}