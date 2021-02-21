package com.example.demo.view

import com.github.axet.vget.VGet
import dorkbox.notify.Notify
import javafx.scene.control.Alert
import javafx.scene.control.RadioButton
import tornadofx.*
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels
import java.io.File
import java.util.concurrent.atomic.AtomicBoolean


fun main() {
    launch<MainLand>()
}
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    override val root = form {
        setPrefSize(300.0, 300.0)

    }
}