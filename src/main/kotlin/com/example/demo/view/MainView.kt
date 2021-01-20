package com.example.demo.view

import javafx.scene.text.Font
import tornadofx.*

class MainView :View() {
    override val root = form {
        setPrefSize(200.0, 200.0)
        /*
        with(primaryStage){
            fullScreenExitHint // return the hint when full screen is active.
            isFullScreen
            isAlwaysOnTop // for make the window always visible on top.
            isResizable
            fullScreenExitKeyCombination // TODO: 14.01.2021
            title
            icons
            isIconified
            isMaximized // for toke all the screen size when is open
            modality
            style
            maxHeight
            maxWidth
            minHeight
            minWidth
        }
         */
        var cc = "❌"
        var cont = 0
        var dd = (0..8).toList()
        datagrid(dd) {
           minHeight=300.0
           minWidth=300.0
            cellWidth = 80.0
            cellHeight = 80.0
            cellCache {
                button {
                   useMaxWidth=true
                    useMaxHeight=true
                    font = Font.font("Ubuntu", 33.0)
                    if (cont == 8) {
                        dd.forEach {

                        }
                    }
                    setOnMouseClicked {
                        if (text.isEmpty()) {
                            if (cc == "❌") {
                                text = cc
                                cc = "Ｏ"
                            } else if (cc == "Ｏ") {
                                text = cc
                                cc = "❌"
                            }
                            cont += 1
                        }
                    }
                }
            }

        }
    }
}