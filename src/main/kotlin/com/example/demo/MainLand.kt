package com.example.demo.view

import appeanaLib.Coding
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.control.RadioButton
import javafx.scene.control.TextArea
import javafx.scene.text.Text
import tornadofx.*

fun main() {
    launch<MainLand>()
}
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent(){
    override val root = tabpane{

    }
}
