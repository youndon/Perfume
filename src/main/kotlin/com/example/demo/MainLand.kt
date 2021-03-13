package com.example.demo.view

import com.example.demo.box.Monitor
import com.sun.org.apache.xml.internal.dtm.Axis
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hyperic.sigar.Sigar
import tornadofx.*

fun main() = launch<MainLand>()
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    override val root = form {
    }
}

fun down() {

}


