package com.example.demo.view

import javafx.scene.Parent
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCombination
import javafx.stage.Modality
import javafx.stage.StageStyle
import tornadofx.*

class MainView :View(){
    override val root = form {
        setPrefSize(200.0,200.0)
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

    }
}