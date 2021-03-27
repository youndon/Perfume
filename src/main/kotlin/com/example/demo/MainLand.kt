package com.example.demo.view

import com.github.kiulian.downloader.OnYoutubeDownloadListener
import dyorgio.runtime.run.`as`.root.RootExecutor
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.scene.web.HTMLEditor
import org.json.JSONArray
import tornadofx.*
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.concurrent.Future
import javax.swing.text.StyledEditorKit

fun main() {
    launch<MainLand>()
}
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    var tt = HTMLEditor()
    override val root = scrollpane {

    }
}