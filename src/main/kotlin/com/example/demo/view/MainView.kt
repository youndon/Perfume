package com.example.demo.view

import com.example.demo.app.Styles
import com.sun.scenario.effect.ImageData
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.layout.BackgroundSize
import javafx.scene.shape.Shape
import tornadofx.*
import tornadofx.Stylesheet.Companion.button
import tornadofx.Stylesheet.Companion.form
import java.awt.Color
import java.io.File
import java.nio.file.Paths
import javax.swing.Icon
import javax.swing.text.Style
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask
import java.text.SimpleDateFormat

import java.text.DateFormat
import java.util.*
import javafx.scene.layout.Background

import javafx.scene.layout.BackgroundPosition

import javafx.scene.layout.BackgroundRepeat

import javafx.scene.layout.BackgroundImage
import java.awt.Container
import java.net.URL
import java.nio.file.Path
import javax.swing.text.StyleConstants.setBackground

fun main() {  launch<MainTic>()  }

class MainTic:App(MainView::class)

class MainView:View() {
    override val root: Parent
        get() = TODO("Not yet implemented")
}