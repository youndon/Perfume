package com.example.demo.snakeGame

import javafx.scene.canvas.GraphicsContext

interface Renderable {
    fun render(gc: GraphicsContext)
}