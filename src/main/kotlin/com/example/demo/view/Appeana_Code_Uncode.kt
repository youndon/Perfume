package com.example.demo.view

import com.example.demo.box.Converter
import javafx.scene.control.Alert
import javafx.scene.control.TabPane
import javafx.scene.control.TextArea
import tornadofx.*
fun main() {
    launch<Code_UncodeApp>()
}
class Code_UncodeApp:App(Appeana_Code_Uncode::class)
class Appeana_Code_Uncode :UIComponent(){

    @ExperimentalStdlibApi
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
                                            "binary"-> output.text = Converter.Text(input.text.lines()).bin()
                                            "hex"-> output.text = Converter.Text(input.text.lines()).hex()
                                            "octal"-> output.text = Converter.Text(input.text.lines()).octal()
                                            "integer"-> output.text = Converter.Text(input.text.lines()).integer()
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
                                                "text" -> output.text = Converter.Bin(input.text.lines()).txt()
                                                "integer" -> output.text =Converter.Bin(input.text.lines()).integer()
                                                "hex" -> output.text =Converter.Bin(input.text.lines()).hex()
                                                "octal" -> output.text =Converter.Bin(input.text.lines()).octal()
                                                "decimal" -> output.text =Converter.Bin(input.text.lines()).decimal()
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
                                            "binary" -> output.text = Converter.Hex(input.text.lines()).bin()
                                            "text" -> output.text = Converter.Hex(input.text.lines()).txt()
                                            "octal" -> output.text = Converter.Hex(input.text.lines()).octal()
                                            "integer" -> output.text = Converter.Hex(input.text.lines()).integer()
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
                                            "binary" -> output.text = Converter.Oct(input.text.lines()).bin()
                                            "hex" -> output.text = Converter.Oct(input.text.lines()).hex()
                                            "text" -> output.text = Converter.Oct(input.text.lines()).txt()
                                            "integer" -> output.text = Converter.Oct(input.text.lines()).integer()
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
                                            "binary" -> output.text = Converter.Int(input.text.lines()).bin()
                                            "hex" -> output.text = Converter.Int(input.text.lines()).hex()
                                            "octal" -> output.text = Converter.Int(input.text.lines()).octal()
                                            "text" -> output.text = Converter.Int(input.text.lines()).txt()
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
            val controller = listOf("binary")
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
                                            "binary" -> output.text = Converter.Decimal(input.text.lines()).bin()
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