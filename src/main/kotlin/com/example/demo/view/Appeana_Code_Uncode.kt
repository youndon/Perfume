package com.example.demo.view

import appeanaLib.Coding
import javafx.scene.control.Button
import javafx.scene.control.RadioButton
import javafx.scene.control.TextArea
import javafx.scene.text.Text
import tornadofx.*

fun main() {
    launch<Code_UncodeApp>()
}
class Code_UncodeApp:App(Appeana_Code_Uncode::class)
class Appeana_Code_Uncode :UIComponent(){
    private var binary = RadioButton()
    private var hex = RadioButton()
    private var octal = RadioButton()
    private var convert = Button()
    private var input = TextArea()
    private var output = Text()
    override val root = form {
        setPrefSize(700.0,600.0)
        borderpane{
            top{
                hbox {
                    spacing = 10.0
                    convert = button("convert!") {
                        action {
                            when {
                                binary.isSelected -> {
                                    output.text = Coding().textToBinary(input.text).toString()
                                }
                                hex.isSelected -> {
                                    output.text = Coding().textToHex(input.text).toString()
                                }
                                octal.isSelected -> {
                                    output.text = Coding().textToOctal(input.text).toString()
                                }
                            }
                        }
                    }
                    togglegroup {
                        binary = radiobutton("binary")
                        hex = radiobutton("hex")
                        octal = radiobutton("octal")
                    }
                }
            }
            left{
                input = textarea {
                    setPrefSize(350.0,600.0)
                }
            }
            right{
                output = text {
                }
            }
        }

    }
}