package com.example.demo.view

import com.example.demo.box.Monitor
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import tornadofx.*
import kotlin.concurrent.thread

fun main() = launch<MainLand>()
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    override val root = form {
        setPrefSize(300.0, 300.0)
                piechart("RAM") {
                    data(ram())
        }
    }
}

fun ram(): Map<String, Double> {
    return mapOf<String,Double>("free" to Monitor.MEM.freePercent(),
        "used" to Monitor.MEM.usedPercent())

}


