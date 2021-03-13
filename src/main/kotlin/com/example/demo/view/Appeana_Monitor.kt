package com.example.demo.view

import tornadofx.*

fun main() {
    launch<MonitorApp>()
}
class MonitorApp:App(Appeana_Monitor::class)
class Appeana_Monitor :UIComponent(){
    override val root = form {


    }
}