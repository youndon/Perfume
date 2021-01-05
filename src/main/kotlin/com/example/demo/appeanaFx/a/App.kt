package com.example.demo.appeanaFx.a

import tornadofx.*
import tornadofx.App

private class App {
    lateinit var app :App

    init {
        app.run {
            this.configBasePath
            this.primaryView
            this.resources
            this.scope
            this.workspace
//            this.createPrimaryScene() todo
//            this.fire() // todo
            this.inject<Controller>() // usage: val some:<Component> by inject()
            this.k(this.javaClass) // todo
//            this.onBeforeShow() // todo
            this.shouldShowPrimaryStage()
//            this.trayicon() // todo
        }
    }
}