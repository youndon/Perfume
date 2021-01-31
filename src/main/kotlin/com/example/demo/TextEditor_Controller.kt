package com.example.demo

import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.fxml.Initializable
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.stage.Stage
import javafx.stage.FileChooser
import java.util.ResourceBundle
import javafx.scene.control.ButtonType
import javafx.scene.control.CheckMenuItem
import javafx.scene.control.TextArea
import java.io.*
import java.net.URL

class TextEditor_Controller : Initializable {
    @FXML
    private val textArea: TextArea? = null
    private var stage: Stage? = null
    private val fileChooser = FileChooser()
    override fun initialize(location: URL, resources: ResourceBundle) {
        fileChooser.initialDirectory = File(System.getProperty("user.home"))
        fileChooser.extensionFilters.addAll(FileChooser.ExtensionFilter("Text", "*.txt"),
                                            FileChooser.ExtensionFilter("All Files", "*.*"))
    }

    fun init(myStage: Stage?) {
        stage = myStage
    }

    @FXML
    fun exit() {
        if (textArea!!.text.isEmpty()) {
            Platform.exit()
            return
        }
        val alert = Alert(
            Alert.AlertType.CONFIRMATION,
            "Exit without saving?",
            ButtonType.YES,
            ButtonType.NO,
            ButtonType.CANCEL
        )
        alert.title = "Confirm"
        alert.showAndWait()
        if (alert.result == ButtonType.YES) {
            Platform.exit()
        }
        if (alert.result == ButtonType.NO) {
            save()
            Platform.exit()
        }
    }

    @FXML
    private fun save() {
        try {
            fileChooser.title = "Save As"
            val file = fileChooser.showSaveDialog(stage)
            if (file != null) {
                val savedText = PrintWriter(file)
                val out = BufferedWriter(savedText)
                out.write(textArea!!.text)
                out.close()
            }
        } catch (e: FileNotFoundException) {
            println("Error: $e")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @FXML
    fun openFile() {
        fileChooser.title = "Open File"
        val file = fileChooser.showOpenDialog(stage)
        if (file != null) {
            textArea!!.clear()
            readText(file)
        }
    }

    // sets the textArea to the text of the opened file
    private fun readText(file: File) {
        var text: String
            kotlin.runCatching {
            BufferedReader(FileReader(file)).use { buffReader ->
                while (buffReader.readLine().also { text = it } != null) {
                    textArea!!.appendText(text.trimIndent())
                }
            }
        }
    }

    //TODO add confirmation window if text editor has text and wasn't saved
    @FXML
    fun newFile() {
        textArea!!.clear()
    }

    @FXML
    fun about() {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = "About"
        alert.headerText = "A project just for fun written by abrand."
        alert.contentText = "github.com/abrandell"
        alert.showAndWait()
    }

    // TODO Add a proper font-size menu && color selection
    @FXML
    fun fontSize(e: ActionEvent) {
        when ((e.source as CheckMenuItem).id) {
            "small" -> textArea!!.style = "-fx-font-size: 14px"
            "default" -> textArea!!.style = "-fx-font-size: 22px"
            "large" -> textArea!!.style = "-fx-font-size: 30px"
            else -> textArea!!.style = "-fx-font-size: 22px"
        }
    }
}