package com.example.demo.view

import com.github.kiulian.downloader.OnYoutubeDownloadListener
import javafx.scene.text.Text
import tornadofx.*
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.concurrent.Future

fun main() = launch<MainLand>()
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    override val root = vbox{
        setPrefSize(500.0, 500.0)

        
    }

}