package com.example.demo

import com.sun.javafx.css.converters.DurationConverter
import tornadofx.toProperty
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

@ExperimentalTime
fun main() {

    SimpleDateFormat("ss")
        .parse("2000")
        .toString()
        .drop(11)
        .dropLast(9)

}