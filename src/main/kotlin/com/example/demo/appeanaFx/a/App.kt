package com.example.demo.appeanaFx.a

import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.*
import tornadofx.App
import java.awt.image.BufferedImage
import java.io.InputStream
import java.nio.file.Path

private class App:App() {
    lateinit var app :App
    lateinit var uiComponent: UIComponent
    init {
        app.run {
            this.primaryView
            this.resources
            this.scope
            this.workspace
            this.createPrimaryScene(uiComponent) // todo
            this.inject<Controller>() // usage: val some:<Component> by inject()
            this.k(this.javaClass) // todo
            this.trayicon(BufferedImage(0,0,0),""){} // todo
        }

    }

    override fun start(stage: Stage) {
        super.start(stage)
    }

    override fun stop() {
        super.stop()
    }

    override fun createPrimaryScene(view: UIComponent): Scene {
        return super.createPrimaryScene(view)
    }

    override fun onBeforeShow(view: UIComponent) {
        super.onBeforeShow(view)
    }

    override fun shouldShowPrimaryStage(): Boolean {
        return super.shouldShowPrimaryStage()
    }

    override fun init() {
        super.init()
    }

    override fun loadConfig(): ConfigProperties {
        return super.loadConfig()
    }

    override val config: ConfigProperties
        get() = super.config

    override val configBasePath: Path
        get() = super.configBasePath

    override val configPath: Path
        get() = super.configPath

}