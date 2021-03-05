package com.example.demo.view

import tornadofx.*

class Appeana_Translate:UIComponent() {
    override val root = form{
        borderpane {
            left {
                textarea {
                    setPrefSize(300.0,300.0)
                }
            }
            right {
                textarea {
                    setPrefSize(300.0,300.0)

                }
            }
        }
    }
}