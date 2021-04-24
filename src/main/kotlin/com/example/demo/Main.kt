package com.example.demo.view

import com.github.thomasnield.rxkotlinfx.valueSelections
import javafx.print.PrinterJob
import javafx.scene.AccessibleRole
import javafx.scene.control.*
import javafx.scene.control.ButtonBar.ButtonData
import javafx.stage.Window
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
    override val root = vbox {
       checkbox("qdfqsd") {
           this.isAllowIndeterminate
           this.isIndeterminate
           this.isSelected
       }
    }
}

