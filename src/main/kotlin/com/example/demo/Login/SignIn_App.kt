package com.example.demo.Login

import javafx.stage.Stage
import tornadofx.App

class SignIn_App: App(SignIn_View::class){
    override fun start(stage: Stage) {
        super.start(stage)
        stage.width=300.0
        stage.height=400.0
        stage.isResizable=false
    }
}