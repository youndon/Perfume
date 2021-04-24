package com.example.demo.view

import dorkbox.console.output.Color
import javafx.scene.shape.QuadCurve
import tornadofx.*


class MainLand:App(MainView::class){

     companion object{
         @JvmStatic
         fun main(args: Array<String>) {
             launch<MainLand>()
         }
     }
 }

class MainView:View() {
    override val root = form {
       squeezebox {
       }
    }
}

