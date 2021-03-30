package com.example.demo.view

import User
import UserModel
import com.github.kiulian.downloader.OnYoutubeDownloadListener
import dyorgio.runtime.run.`as`.root.RootExecutor
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.layout.BorderPane
import javafx.scene.shape.Path
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.scene.web.HTMLEditor
import org.json.JSONArray
import tornadofx.*
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.net.URL
import java.nio.file.Paths
import java.util.concurrent.Future
import javax.swing.text.StyledEditorKit

fun main() {
    launch<MainLand>()
}
class MainLand:App(Workspace::class)

class PersonEditor : UIComponent() {
    override val root = vbox {

    }
}