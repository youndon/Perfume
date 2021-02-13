package com.example.demo.box

import java.time.LocalTime

class BC() {
    private fun go(): LocalTime = LocalTime.now()
    private fun binary(a:Any) : String {
        return when (a) {
            '1' -> "0001";'2' -> "0010";'3' -> "0011"
            '4' -> "0100";'5' -> "0101";'6' -> "0110"
            '7' -> "0111";'8' -> "1000";'9' -> "1001"
            else -> "0000"
        }
    }
    // seconds.
    fun s():String {
        return binary(go().second.toString().last())
    }
     fun ss(): String {
        return if (go().second in 0..9) " 000"
        else binary(go().second.toString().first())
    }
    // minute.
     fun m():String {
        return binary(go().minute.toString().last())
    }
     fun mm(): String {
        return if (go().minute in 0..9) " 000"
        else binary(go().minute.toString().first())
    }
    // hours.
     fun h():String {
        return binary(go().hour.toString().last())
    }
         fun hh(): String {
        return if (go().hour in 0..9) "  00"
        else binary(go().hour.toString().first())
    }
}