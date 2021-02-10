package com.example.demo.snakeGame

import javafx.geometry.Point2D
import javafx.scene.canvas.GraphicsContext

class Food : GameObject {
    constructor(width: Double, height: Double) : super(width, height) {}
    constructor(position: Point2D, width: Double, height: Double) : super(position, width, height) {}

    override fun render(gc: GraphicsContext) {
        gc.drawImage(Assets.apple.image, position.x, position.y)
    }
}