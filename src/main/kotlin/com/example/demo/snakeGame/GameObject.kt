package com.example.demo.snakeGame

import javafx.geometry.Point2D
import javafx.geometry.Rectangle2D
import javafx.scene.canvas.GraphicsContext
import java.util.*

open class GameObject : Renderable {
    var position: Point2D
    var width = 0.0
    var height = 0.0
    var isAlive: Boolean
        protected set

    constructor() {
        position = Point2D(0.0, 0.0)
        isAlive = true
    }

    constructor(width: Double, height: Double) {
        position = Point2D(0.0, 0.0)
        this.width = width
        this.height = height
        isAlive = true
    }

    constructor(position: Point2D) {
        this.position = position
        isAlive = true
    }

    constructor(position: Point2D, width: Double, height: Double) {
        this.position = position
        this.width = width
        this.height = height
        isAlive = true
    }

    constructor(position: Point2D, bodySize: Double) {
        this.position = position
        width = bodySize
        height = bodySize
        isAlive = true
    }

    fun die() {
        isAlive = false
    }

    override fun render(gc: GraphicsContext) {
        if (isAlive) {
            gc.fillRect(position.x + 1, position.y + 1, width - 2, height - 2)
        }
    }

    private val boundary: Rectangle2D
        get() = Rectangle2D(position.x, position.y, width, height)

    fun intersect(other: GameObject): Boolean {
        return boundary.intersects(other.boundary)
    }

    fun setRandomPosition(width: Int, height: Int) {
        val random = Random()
        position = Point2D(
            (random.nextInt(width / GameScene.PIXELSIZE) * GameScene.PIXELSIZE).toDouble(),
            (random.nextInt(height / GameScene.PIXELSIZE) * GameScene.PIXELSIZE).toDouble()
        )
    }
}