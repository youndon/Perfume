package com.example.demo.view

import com.darkprograms.speech.translator.GoogleTranslate
import javafx.scene.control.ComboBox
import javafx.scene.control.TextArea
import javafx.scene.text.Font
import tornadofx.*
import kotlin.concurrent.thread

fun main() {
    launch<TranslateApp>()
}
class TranslateApp:App(Appeana_Translate::class)
class Appeana_Translate:UIComponent() {
    private var input = TextArea()
    private var output = TextArea()
    private var language = ComboBox<String>()
    override val root = form {
        borderpane {
            left {
                input = textarea {
                    setPrefSize(400.0, 300.0)
                    style {
                        font = Font.font(25.0)
                    }
                }
            }
            right {
                output = textarea {
                    setPrefSize(400.0, 300.0)
                    this.isEditable = false
                    this.isWrapText = true
                    style {
                        font = Font.font(25.0)
                    }
                }
            }
            bottom {
                language = combobox {
                    items = listOf(
                        "ar","eu","ca","cs","nl","en","fi","fr","gl","de","hu","is","it","id","ja","ko",
                        "la","zh","ms","no","pl","xx-piglatin","pt","ro","ru","sr","sk","es","sv","tr","zu"
                    ).observable()
                }
            }
        }
        addEventFilter(javafx.scene.input.KeyEvent.KEY_PRESSED) {
            thread {
//                output.text = GoogleTranslate.translate(language.selectedItem, input.text)
            }.start()
        }
    }
}