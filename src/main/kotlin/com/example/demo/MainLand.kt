package com.example.demo.view

import javafx.scene.control.Alert
import tornadofx.*
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels


fun main() {
    launch<MainLand>()
}
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    override val root = form {
        setPrefSize(300.0, 300.0)
       val url =  textfield("url") {

        }
        val path = textfield("path") {

        }
        button("download").action{
            try {
                val rbc = Channels.newChannel(URL(url.text).openStream())
                val fos = FileOutputStream(path.text)
                fos.channel.transferFrom(rbc, 0, Long.MAX_VALUE)
            }catch (ex:Exception){
                alert(Alert.AlertType.WARNING,ex.message.toString())
            }

        }

    }
}