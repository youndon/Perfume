package com.example.demo.view

import com.github.kiulian.downloader.OnYoutubeDownloadListener
import dyorgio.runtime.run.`as`.root.RootExecutor
import javafx.scene.text.Text
import org.json.JSONArray
import tornadofx.*
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.concurrent.Future

fun main() {
    launch<MainLand>()
}
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    override val root = scrollpane {
        form {
            setPrefSize(500.0, 500.0)
            System.setProperty("java.io.tmpdir", "/home/yon/")
            RootExecutor("-Xmx64m").call {
                val pb = Runtime.getRuntime().exec(arrayOf("/bin/bash", "-c", "sudo lshw --help"))
                var line: String?
                val ss = StringBuffer()
                val input = BufferedReader(InputStreamReader(pb.inputStream))
                while (input.readLine().also { line = it } != null) {
                    ss.appendln(line)
                }
                input.close()
                return@call ss
            }.lines().forEach {
                text(it)
            }
        }
    }
}