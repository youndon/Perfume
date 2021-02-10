package com.example.demo.snakeGame

import java.util.logging.Level
import java.util.logging.Logger

object MyLogger {
    private val LOGGER = Logger.getLogger(MyLogger::class.java.name)
    @JvmStatic
    fun INFO(msg: String?) {
        LOGGER.log(Level.INFO, msg)
    }

    @JvmStatic
    fun WARN(msg: String?) {
        LOGGER.log(Level.WARNING, msg)
    }
}