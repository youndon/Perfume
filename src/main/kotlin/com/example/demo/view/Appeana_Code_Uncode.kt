package com.example.demo.view

import appeanaLib.Coding
import appeanaLib.Decoding
import javafx.scene.control.Alert
import javafx.scene.control.TabPane
import javafx.scene.control.TextArea
import tornadofx.*

fun main() {
    launch<Code_UncodeApp>()
}
class Code_UncodeApp:App(Appeana_Code_Uncode::class)
class Appeana_Code_Uncode :UIComponent(){

    @ExperimentalUnsignedTypes
    override val root = tabpane {
        setPrefSize(700.0,600.0)
        tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
        tab("text") {
            val controller = listOf("binary","hex","octal","integer")
            var input = TextArea()
            var output = TextArea()
            borderpane {
                top {
                    hbox {
                       paddingAll = 10 ; spacing = 10.0
                        togglegroup {
                            controller.forEach {
                                radiobutton(it) {
                                    this.action {
                                        when(it){
                                            "integer"-> output.text = Coding.`linesToText&Binary&Octal&Hex`(input.text.lines()).first
                                            "binary"-> output.text = Coding.`linesToText&Binary&Octal&Hex`(input.text.lines()).second.first
                                            "hex"-> output.text = Coding.`linesToText&Binary&Octal&Hex`(input.text.lines()).second.second
                                            "octal"-> output.text = Coding.`linesToText&Binary&Octal&Hex`(input.text.lines()).second.third
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                left {
                    input = textarea {
                        setPrefSize(350.0, 600.0)
                    }
                }
                right {
                    flowpane {
                        output = textarea {
                            setPrefSize(350.0, 600.0)
                            this.isEditable=false

                        }
                    }
                }
            }
        }
        tab("binary") {
            val controller = listOf("text","hex","octal","integer","decimal")
            var input = TextArea()
            var output = TextArea()
            borderpane {
                top {
                    hbox {
                        paddingAll = 10 ; spacing = 10.0
                        togglegroup {
                            controller.forEach {
                                radiobutton(it) {
                                    this.action {
                                        try{
                                            when(it) {
                                                "text" -> output.text = Decoding.Binary.`binToText&Integer`(input.text.lines()).first
                                                "integer" -> output.text = Decoding.Binary.`binToText&Integer`(input.text.lines()).second
                                                "decimal" -> output.text = Decoding.Binary.binaryToDouble(input.text.lines())
                                                "hex" -> output.text = Decoding.Binary.`binToHex&Octal`(input.text.lines()).first
                                                "octal" -> output.text = Decoding.Binary.`binToHex&Octal`(input.text.lines()).second
                                            }
                                        }catch (ex:Exception){
                                            alert(Alert.AlertType.WARNING,ex.localizedMessage)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                left {
                    input = textarea {
                        setPrefSize(350.0, 600.0)
                    }
                }
                right {
                    flowpane {
                        output = textarea {
                            setPrefSize(350.0, 600.0)
                            this.isEditable=false

                        }
                    }
                }
            }
        }
        tab("hex") {
            val controller = listOf("binary","text","octal","integer")
            var input = TextArea()
            var output = TextArea()
            borderpane {
                top {
                    hbox {
                        paddingAll = 10 ; spacing = 10.0
                        togglegroup {
                            controller.forEach {
                                radiobutton(it) {
                                    this.action {
                                        when(it){
                                            "text" -> output.text = Decoding.Hex.`hexToText&Integer`(input.text.lines()).first
                                            "integer" -> output.text = Decoding.Hex.`hexToText&Integer`(input.text.lines()).second
                                            "binary" -> output.text = Decoding.Hex.`hexToHex&Octal`(input.text.lines()).first
                                            "octal" -> output.text = Decoding.Hex.`hexToHex&Octal`(input.text.lines()).second
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                left {
                    input = textarea {
                        setPrefSize(350.0, 600.0)
                    }
                }
                right {
                    flowpane {
                        output = textarea {
                            setPrefSize(350.0, 600.0)
                            this.isEditable=false

                        }
                    }
                }
            }
        }

        tab("octal") {
            val controller = listOf("binary","hex","text","integer")
            var input = TextArea()
            var output = TextArea()
            borderpane {
                top {
                    hbox {
                        paddingAll = 10 ; spacing = 10.0
                        togglegroup {
                            controller.forEach {
                                radiobutton(it) {
                                    this.action {
                                        when(it){
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                left {
                    input = textarea {
                        setPrefSize(350.0, 600.0)
                    }
                }
                right {
                    flowpane {
                        output = textarea {
                            setPrefSize(350.0, 600.0)
                            this.isEditable=false

                        }
                    }
                }
            }
        }
        tab("integer") {
            val controller = listOf("binary","hex","octal","text")
            var input = TextArea()
            var output = TextArea()
            borderpane {
                top {
                    hbox {
                        paddingAll = 10 ; spacing = 10.0
                        togglegroup {
                            controller.forEach {
                                radiobutton(it) {
                                    this.action {
                                        when(it){
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                left {
                    input = textarea {
                        setPrefSize(350.0, 600.0)
                    }
                }
                right {
                    flowpane {
                        output = textarea {
                            setPrefSize(350.0, 600.0)
                            this.isEditable=false

                        }
                    }
                }
            }
        }

        tab("decimal") {
            val controller = listOf("binary","hex","octal","integer")
            var input = TextArea()
            var output = TextArea()
            borderpane {
                top {
                    hbox {
                        paddingAll = 10 ; spacing = 10.0
                        togglegroup {
                            controller.forEach {
                                radiobutton(it) {
                                    this.action {
                                        when(it){
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                left {
                    input = textarea {
                        setPrefSize(350.0, 600.0)
                    }
                }
                right {
                    flowpane {
                        output = textarea {
                            setPrefSize(350.0, 600.0)
                            this.isEditable=false

                        }
                    }
                }
            }
        }
    }
}