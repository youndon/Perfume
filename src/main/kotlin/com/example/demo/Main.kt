package com.example.demo.view

import javafx.scene.AccessibleRole
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonBar.ButtonData
import tornadofx.*
import javax.accessibility.AccessibleText


class MainLand:App(MainView::class){

     companion object{
         @JvmStatic
         fun main(args: Array<String>) {
             launch<MainLand>()
         }
     }
 }
class MainView:View() {
    override val root = pane {
      button {
      }
    }
}

