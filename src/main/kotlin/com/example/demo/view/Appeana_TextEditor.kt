package com.example.demo.view

import tornadofx.*

fun main() {
    launch<TextEditorApp>()
}
class TextEditorApp:App(Appeana_TextEditor::class)
class Appeana_TextEditor : View("My View") {
    var ss = listOf("open","add","setting")
    override val root = gridpane {
        row {
            buttonbar {
                ss.forEach {
                    button(it) {

                    }
                }
            }
        }
        row {
            textarea {

            }
        }
    }
}
