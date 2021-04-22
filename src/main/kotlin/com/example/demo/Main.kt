package com.example.demo.view

import com.github.thomasnield.rxkotlinfx.tabSelections
import javafx.scene.control.Button
import javafx.scene.control.SplitPane
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import tornadofx.*


fun main() {
    launch<MainLand>()
}
 class MainLand:App(MainView::class)
class MainView:View() {
    override val root = pane {

    }
}
