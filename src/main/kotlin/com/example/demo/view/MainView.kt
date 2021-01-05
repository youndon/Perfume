package com.example.demo.view

import com.sun.org.apache.xpath.internal.operations.Bool
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.control.TreeItem
import javafx.scene.input.KeyCode
import javafx.scene.layout.Border
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import javafx.scene.text.FontPosture
import javafx.util.Duration
import tornadofx.*
import tornadofx.getValue
import tornadofx.setValue
import java.awt.Color.BLUE
import java.awt.List
import java.util.*

class MainView : View("MainView!!") {
    lateinit var dd : Fieldset

  override val root = vbox {
        setPrefSize(400.0, 400.0)
      dd.form
    }


}








/* setOnMouseDragged {
                    this.translateX = it.sceneX
                    this.translateY = it.screenY
                }*/
/*   setOnKeyPressed {
               when (it.code) {
                   KeyCode.LEFT -> translateX-=10
                   KeyCode.RIGHT -> translateX+=10
                   KeyCode.UP -> translateY-=10
                   KeyCode.DOWN -> translateY+=10
               }
           }*/

