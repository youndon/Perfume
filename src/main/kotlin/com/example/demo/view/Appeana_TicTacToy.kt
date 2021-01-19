package com.example.demo.view

import javafx.scene.text.Font
import tornadofx.*

fun main() {
        launch<MainApp>()

}
class MainApp: App(MainView::class)

class Appeana_TicTacToy:View()  {
    var cc = "❌"
    var cont = 0
        override val root = vbox {
            if (cont==9){
                // refresh
            }
            (0..2).forEach { _ ->
                buttonbar {
                    (0..2).forEach { _ ->
                        button {
                            setPrefSize(100.0,100.0)
                            font = Font.font("Ubuntu",35.0)
                            action {
                                if (text.isEmpty()){
                                    if (cc=="❌"){
                                        text=cc
                                        cc="Ｏ"
                                    } else if (cc=="Ｏ"){
                                        text=cc
                                        cc="❌"
                                    }
                                    cont+=1
                                }
                            }
                        }
                    }
                }
            }
        }
    }