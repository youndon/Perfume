package com.example.demo.view

import com.github.axet.vget.VGet
import javafx.scene.control.Alert
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
       val url =  textfield(" https://www.youtube.com/watch?v=ZfYfhk1vB64") {

        }
        val path = textfield("/yon/home/") {

        }

        button("download").action{
            try {
                val v = VGet(URL(url.text), File(path.text))
//                v.download()
                println(v.video.title)
            }catch (ex:Exception){
                alert(Alert.AlertType.WARNING,ex.message.toString())
            }

        }

    }
}