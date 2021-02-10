package com.example.demo.snakeGame

import com.sun.javafx.scene.traversal.Direction
import javafx.geometry.Point2D

class MovingGameObject : GameObject {
    var direction: Direction? = null

    constructor() {}
    constructor(width: Double, height: Double) : super(width, height) {}
    constructor(position: Point2D) : super(position) {}
    constructor(position: Point2D, width: Double, height: Double) : super(position, width, height) {}
    constructor(position: Point2D, bodySize: Double) : super(position, bodySize) {}
    constructor(position: Point2D, bodySize: Double, direction: Direction?) : super(position, bodySize) {
        this.direction = direction
    }
}