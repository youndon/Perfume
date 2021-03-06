package com.example.demo.box

import javafx.scene.Scene
import javafx.scene.control.ScrollPane
import javafx.scene.effect.GaussianBlur
import javafx.scene.image.Image
import javafx.scene.image.ImageView

import javafx.scene.layout.StackPane
import javafx.scene.shape.Rectangle

import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch
import java.nio.file.Paths


fun main() {
    launch<PartiallyBlurredImage>()
}

class PartiallyBlurredImage : App() {
    private val width = 600.0
    private val height = 800.0
    override fun start(stage: Stage) {
        val plainImage = createImageView()
        val blurredImage = createImageView()
        blurredImage.effect = GaussianBlur(20.0)
        plainImage.clip = Rectangle(0.0, 0.0, width / 2, height)
        blurredImage.clip = Rectangle(width / 2, 0.0, width / 2, height)
        val scene = Scene(ScrollPane(StackPane(plainImage, blurredImage)))
        stage.scene = scene
        stage.show()
    }

    private fun createImageView(): ImageView {
        val imageView = ImageView(Image(Paths.get("accept them or walk away.jpeg").toUri().toString()))
        imageView.fitWidth = width
        imageView.fitHeight = height
        imageView.isPreserveRatio = true
        return imageView
    }

}