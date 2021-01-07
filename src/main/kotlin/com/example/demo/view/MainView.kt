package com.example.demo.view

import javafx.scene.input.KeyCode
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import sun.security.x509.Extension
import tornadofx.*

open class MainView() : View("MainView!!") {
    override val root = form {
        setPrefSize(400.0, 500.0)
        val input = textfield() {
            setOnKeyPressed {
                when(it.code) {
                    KeyCode.ENTER -> text = try {
                        ExpressionBuilder(text).build().evaluate().toString()
                    } catch (ex: Exception) {
                        "ops!!"
                    }
                }
            }
        }
        buttonbar { button("pro").action { tooltip("coming soon") };button("(").action { input.text+="(" };button(")").action { input.text+=")" };button("C").action { input.text = "" } }
        buttonbar { button("7").action { input.text+="7" };button("8").action { input.text+="8" };button("9").action { input.text+="9" };button("/").action { input.text+="/" } }
        buttonbar { button("4").action { input.text+="4" };button("5").action { input.text+="5" };button("6").action { input.text+="6" };button("*").action { input.text+="*" } }
        buttonbar { button("1").action { input.text+="1" };button("2").action { input.text+="2" };button("3").action { input.text+="3" };button("-").action { input.text+="-" } }
        buttonbar { button("0").action { input.text+="0" };button(".").action { input.text+="." };
            button("=").action { input.text = try {
                     ExpressionBuilder(input.text).build().evaluate().toString()
                           } catch (ex: Exception) {
            "ops!!"
        } };button("+").action { input.text+="+" } }

    }
}