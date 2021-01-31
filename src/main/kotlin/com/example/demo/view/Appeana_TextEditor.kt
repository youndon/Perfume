package com.example.demo.view

import tornadofx.*

fun main() {
    launch<TextEditorApp>()
}
class TextEditorApp:App(Appeana_TextEditor::class)
class Appeana_TextEditor : View("My View") {
    var ss = listOf("open","add","setting","save")
    override val root = gridpane {
        row {
            buttonbar {
                ss.forEach {
                    button(it) {
                        this.action {
                            if (it=="save"){

                            }
                        }
                        this.style{
                            if (it==""){

                            }
                        }
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
