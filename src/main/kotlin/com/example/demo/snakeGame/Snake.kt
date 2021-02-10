package com.example.demo.snakeGame

import com.sun.javafx.scene.traversal.Direction
import javafx.geometry.Point2D
import javafx.scene.SnapshotParameters
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import java.util.*

class Snake(head: Point2D?, tail: Point2D?, private val bodySize: Int) : Renderable {
    private val body = LinkedList<MovingGameObject>()
    private var tail: MovingGameObject? = null
    var direction = Direction.RIGHT
    val head: MovingGameObject
        get() = body.first
    val neck: MovingGameObject
        get() = body[1]

    fun getBody(index: Int): MovingGameObject {
        return body[index]
    }

    fun getTail(): MovingGameObject {
        return body.last
    }

    val length: Int
        get() = body.size

    fun move() {
        tail = body.pollLast()
        when (direction) {
            Direction.UP -> {
                val newPos = head.position.subtract(0.0, bodySize.toDouble())
                body.addFirst(MovingGameObject(newPos, bodySize.toDouble(), direction))
            }
            Direction.DOWN -> {
                val newPos = head.position.add(0.0, bodySize.toDouble())
                body.addFirst(MovingGameObject(newPos, bodySize.toDouble(), direction))
            }
            Direction.LEFT -> {
                val newPos = head.position.subtract(bodySize.toDouble(), 0.0)
                body.addFirst(MovingGameObject(newPos, bodySize.toDouble(), direction))
            }
            Direction.RIGHT -> {
                val newPos = head.position.add(bodySize.toDouble(), 0.0)
                body.addFirst(MovingGameObject(newPos, bodySize.toDouble(), direction))
            }
        }
    }

    fun grow() {
        body.add(MovingGameObject())
    }

    fun intersect(other: GameObject): Boolean {
        for (i in 0 until length) {
            if (other.intersect(body[i])) {
                return true
            }
        }
        return false
    }

    fun collide(): Boolean {
        for (i in 1 until length) {
            if (head.position == getBody(i).position) {
                return true
            }
        }
        return false
    }

    override fun render(gc: GraphicsContext) {
        when (direction) {
            Direction.RIGHT -> {
                Assets.snake_head.rotate = -90.0
            }
            Direction.DOWN -> {
                Assets.snake_head.rotate = 0.0
            }
            Direction.UP -> {
                Assets.snake_head.rotate = 180.0
            }
            Direction.LEFT -> {
                Assets.snake_head.rotate = 90.0
            }
        }
        gc.drawImage(
            Assets.snake_head.snapshot(SnapshotParameters(), null),
            head.position.x + 1,
            head.position.y + 1, 23.0, 23.0
        )
        gc.drawImage(
            Assets.snake_body.image,
            neck.position.x + 1,
            neck.position.y + 1, 23.0, 23.0
        )
        if (tail != null) {
            gc.fill = Color.BLACK
            tail!!.render(gc)
        }
    }

    init {
        body.add(MovingGameObject(head!!, bodySize.toDouble()))
        body.add(MovingGameObject(tail!!, bodySize.toDouble()))
    }
}