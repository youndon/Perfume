package com.example.demo.BinaryClock

import java.time.LocalTime

class BinaryControl {
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