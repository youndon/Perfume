package com.example.demo.appeanaFx.a

import javafx.scene.image.Image
import tornadofx.*
import tornadofx.App
import java.awt.image.BufferedImage
import java.io.InputStream

private class App {
    lateinit var app :App
    lateinit var uiComponent: UIComponent
    init {
        app.run {
            this.configBasePath
            this.primaryView
            this.resources
            this.scope
            this.workspace
            this.createPrimaryScene(uiComponent) // todo
            this.inject<Controller>() // usage: val some:<Component> by inject()
            this.k(this.javaClass) // todo
            this.onBeforeShow(uiComponent) // todo
            this.shouldShowPrimaryStage()
            this.trayicon(BufferedImage(0,0,0),""){} // todo
        }
    }
}