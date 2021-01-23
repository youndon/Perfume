package com.example.demo.app

import javafx.scene.text.FontWeight
import tornadofx.*
import java.awt.Color
import java.awt.Font

class Styles : Stylesheet() {
    private val heading by cssclass()
    init {
        label and heading  {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.LIGHT
        }
    }
}