package com.example.demo.snakeGame

import javafx.scene.image.ImageView

internal object Assets {
    var snake_head = ImageView(Assets::class.java.classLoader.getResource("images/head.png").toString())
    var snake_body = ImageView(Assets::class.java.classLoader.getResource("images/body.png").toString())
    var apple = ImageView(Assets::class.java.classLoader.getResource("images/apple.png").toString())
}