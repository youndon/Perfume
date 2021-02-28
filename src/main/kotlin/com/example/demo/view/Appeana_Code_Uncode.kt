package com.example.demo.view

import appeanaLib.Coding
import appeanaLib.Uncoding
import javafx.scene.control.Alert
import javafx.scene.control.TabPane
import javafx.scene.control.TextArea
import net.objecthunter.exp4j.ExpressionBuilder
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
                                            "binary"-> output.text = Coding.linesToBinary(input.text.lines())
                                            "hex"-> output.text = Coding.linesToHex(input.text.lines())
                                            "octal"-> output.text = Coding.linesToOctal(input.text.lines())
                                            "integer"-> output.text = Coding.linesToInteger(input.text.lines())
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
                                                "text" -> output.text = Uncoding.Binary.binaryToText(input.text.lines())
                                                "integer" -> output.text = Uncoding.Binary.binaryToInteger(input.text.lines())
                                                "decimal" -> output.text = Uncoding.Binary.binaryToDouble(input.text.lines())
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
                        /*
                        try {
                            textProperty().onChange {
                                if (!text.matches("\\d*".toRegex())) {
                                    text = text.replace("[^\\d ]".toRegex(), "")
                                }
                            }
                        } catch (ex: Exception) {
                            alert(Alert.AlertType.WARNING,ex.localizedMessage)
                        }
                         */
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