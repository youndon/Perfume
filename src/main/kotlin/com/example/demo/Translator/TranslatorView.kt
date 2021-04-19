package com.example.demo.Translator

import com.darkprograms.speech.translator.GoogleTranslate
import javafx.scene.control.ComboBox
import javafx.scene.control.TextArea
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.text.Font
import tornadofx.*

class TranslatorView: UIComponent() {
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
                    output.text = GoogleTranslate.translate(language.selectedItem?.second, input.text)
                }
            }
            right {
                language = combobox {
                    items = lang().observable()
                }
            }
        }
    }
    companion object{
        private fun lang(): List<Pair<String?, String?>> {
            val language = listOf("Arabic", "eu", "ca", "cs", "nl", "English", "fi", "fr", "gl", "de", "hu", "is", "it", "id", "ja", "ko",
                "la", "zh", "ms", "no", "pl", "xx-piglatin", "pt", "ro", "ru", "sr", "sk", "es", "sv", "tr", "zu")
            val keyword = listOf("ar", "eu", "ca", "cs", "nl", "en", "fi", "fr", "gl", "de", "hu", "is", "it", "id", "ja", "ko",
                "la", "zh", "ms", "no", "pl", "xx-piglatin", "pt", "ro", "ru", "sr", "sk", "es", "sv", "tr", "zu")
            return language.zip(keyword)
        }
    }
}



//Cannot access 'javafx.event.EventTarget' which is a supertype of 'com.example.demo.Translator.TranslatorView'. Check your module classpath for missing or conflicting dependencies
