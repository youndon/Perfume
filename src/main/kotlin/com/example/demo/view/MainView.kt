package com.example.demo.view

import com.example.demo.app.Styles
import com.sun.corba.se.impl.presentation.rmi.DynamicMethodMarshallerImpl
import com.sun.corba.se.pept.transport.EventHandler
import com.sun.scenario.effect.ImageData
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.ButtonType
import javafx.scene.control.TextArea
import javafx.scene.image.Image
import javafx.scene.layout.BackgroundSize
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
import javafx.scene.layout.Background

import javafx.scene.layout.BackgroundPosition

import javafx.scene.layout.BackgroundRepeat

import javafx.scene.layout.BackgroundImage
import javafx.scene.text.Font
import javafx.stage.FileChooser
import java.awt.Container
import java.io.*
import java.net.URL
import java.nio.file.Path
import javax.print.DocFlavor
import javax.swing.text.StyleConstants.setBackground

fun main() {  launch<MainTic>()  }

class MainTic:App(MainView::class)

class MainView:View() {
    var cc = textarea()
    var fc = FileChooser()
    override val root = gridpane {
        cc.font = Font.font("Manjari Thin", 30.0)
        fc.initialDirectory = File("/home/")
        primaryStage.setOnCloseRequest {
            val alert = alert(
                Alert.AlertType.CONFIRMATION,
                "the header!!",
                "content",
                ButtonType.YES,
                ButtonType.NO,
                ButtonType.CANCEL,
                title = "title"
            )
            when (alert.result) {
                ButtonType.YES -> {
                    save()
                }
                ButtonType.NO -> {
                    this@MainView.close()
                }
            }

        }
        row {
            buttonbar {
                button("save").action { save() }
                button("open").action {
                    cc.selectAll()
                    runCatching {
                        var text: String
                        BufferedReader(FileReader(fc.showOpenDialog(primaryStage)))
                            .use { buffReader ->
                                buffReader.readLine().also { text = it } != null
                                cc.appendText(text)
                            }
                    }
                }
            }
        }
            row {
                children.add(cc)
            }

    }
        private fun save(){
            fc.title = "Save As"
            fc.showSaveDialog(primaryStage) ?. runCatching{
                BufferedWriter(PrintWriter(this)).apply {
                    write(cc.text)
                    close()
                }
            }
        }
}