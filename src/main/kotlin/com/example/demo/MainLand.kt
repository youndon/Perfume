package com.example.demo.view

import com.github.kiulian.downloader.OnYoutubeDownloadListener
import tornadofx.*
import java.io.File
import java.util.concurrent.Future

fun main() = launch<MainLand>()
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    override val root = form {

    }

}