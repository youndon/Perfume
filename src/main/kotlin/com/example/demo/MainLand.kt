package com.example.demo.view

import tornadofx.App
import tornadofx.UIComponent
import tornadofx.launch
import tornadofx.vbox

fun main() {
    launch<MainLand>()
}
class MainLand:App(MainView::class)

class MainView : UIComponent("...") {
    override val root = vbox {
    }
}