package com.example.demo.view

import javafx.scene.Parent
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.text.Font
import javafx.stage.FileChooser
import tornadofx.*
import java.io.*

fun main() {
    launch<TextEditorApp>()
}
class TextEditorApp:App(Appeana_TextEditor::class)
class Appeana_TextEditor : UIComponent() {
    var cc = textarea()
    var fc = FileChooser()
    override val root = gridpane {
        cc.font = Font.font("Manjari Thin", 30.0)
        fc.initialDirectory = File("/home/")
        fc.initialFileName = "untitled.txt"
        fc.title
        fc.extensionFilters
        fc.selectedExtensionFilter
        primaryStage.setOnCloseRequest {
            val alert = alert(
                Alert.AlertType.CONFIRMATION,
                "the header!!", "content",
                ButtonType.YES, ButtonType.NO, ButtonType.CANCEL,
                title = "title"
            )
            when (alert.result) {
                ButtonType.YES -> {
                    saveFile()
                }
                ButtonType.NO -> {
                    this@Appeana_TextEditor.close()
                }
            }

        }
        row {
            buttonbar {
                button("save").action { saveFile() }
                button("open").action {
                    openFile()
                }
            }
        }
        row {
            children.add(cc)
        }

    }

    private fun saveFile() {
        fc.title = "dialog title"
        fc.showSaveDialog(primaryStage)?.runCatching {
            BufferedWriter(PrintWriter(this)).apply {
                write(cc.text)
                close()
            }
        }
    }

    private fun openFile() {
        fc.title = "dialog title"
        cc.selectAll()
        runCatching {
            var text: String
            BufferedReader(FileReader(fc.showOpenDialog(primaryStage)))
                .use { buffReader ->
                    buffReader.readLine().also { text = it } != null
                    cc.appendText(text)
                }
        }
    }
}
