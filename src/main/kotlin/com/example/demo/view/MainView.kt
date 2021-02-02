package com.example.demo.view

import com.example.demo.app.Styles
import com.sun.corba.se.impl.presentation.rmi.DynamicMethodMarshallerImpl
import com.sun.corba.se.pept.transport.EventHandler
import com.sun.scenario.effect.ImageData
import javafx.embed.swing.SwingFXUtils
import javafx.geometry.Bounds
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.ButtonType
import javafx.scene.control.TextArea
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.shape.Shape
import tornadofx.*
import tornadofx.Stylesheet.Companion.button
import tornadofx.Stylesheet.Companion.form
import java.awt.Color
import java.nio.file.Paths
import javax.swing.Icon
import javax.swing.text.Style
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask
import java.text.SimpleDateFormat

import java.text.DateFormat
import java.util.*

import javafx.scene.text.Font
import javafx.stage.FileChooser
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle
import java.awt.AWTException
import java.awt.Container
import java.awt.Robot
import java.awt.Transparency.TRANSLUCENT
import java.io.*
import java.net.URI
import java.net.URL
import java.nio.file.Path
import javax.print.DocFlavor
import javax.swing.text.StyleConstants.setBackground
import kotlin.reflect.jvm.jvmName

fun main() {  launch<ViewApp>()  }

class ViewApp:App(TestView::class)

class TestView:View(){

    override val root = gridpane{
        setPrefSize(200.0,200.0)

    }
}
