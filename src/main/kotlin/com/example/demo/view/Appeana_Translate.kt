package com.example.demo.view

import com.darkprograms.speech.translator.GoogleTranslate
import javafx.scene.control.ComboBox
import javafx.scene.control.TextArea
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.text.Font
import tornadofx.*

fun main() {
    launch<TranslateApp>()
}
class TranslateApp:App(Appeana_Translate::class)
class Appeana_Translate:UIComponent() {
    private var input = TextArea()
    private var output = TextArea()
    private var language = ComboBox<Pair<String?,String?>>()
    override val root = vbox {
        hbox {
            input = textarea {
                setPrefSize(400.0, 300.0)
                this.isWrapText = true
                style {
                    font = Font.font(25.0)
                }
            }
            addEventFilter(KeyEvent.KEY_PRESSED) {
                when (it.code) {
                    KeyCode.ENTER -> output.text =
                        GoogleTranslate.translate(language.selectedItem?.component2(), input.text)
                    else -> output.text = Exception().localizedMessage
                }
            }
            output = textarea {
                setPrefSize(400.0, 300.0)
                this.isEditable = false
                this.isWrapText = true
                style {
                    font = Font.font(25.0)
                }
            }
        }
        borderpane {
            left {
                button("Done").action {
                    output.text = GoogleTranslate.translate(language.selectedItem?.component2(), input.text)
                }
            }
            right {
                language = combobox {
                    items = lang().observable()
                }
            }
        }
    }
}

private fun lang(): List<Pair<String?, String?>> {
    val keyword = listOf("العربية", "eu", "ca", "cs", "nl", "en", "fi", "fr", "gl", "de", "hu", "is", "it", "id", "ja", "ko",
        "la", "zh", "ms", "no", "pl", "xx-piglatin", "pt", "ro", "ru", "sr", "sk", "es", "sv", "tr", "zu")
    val language = listOf("ar", "eu", "ca", "cs", "nl", "en", "fi", "fr", "gl", "de", "hu", "is", "it", "id", "ja", "ko",
                        "la", "zh", "ms", "no", "pl", "xx-piglatin", "pt", "ro", "ru", "sr", "sk", "es", "sv", "tr", "zu")
    return keyword.zip(language)
}