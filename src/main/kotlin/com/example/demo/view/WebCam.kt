package com.example.demo.view

import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.event.EventHandler
import javafx.geometry.Rectangle2D
import javafx.scene.Group
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.Image
import javafx.scene.paint.Color
import javafx.stage.Stage
import javafx.stage.WindowEvent
import org.opencv.core.*
import org.opencv.highgui.Highgui.imencode
import org.opencv.highgui.VideoCapture
import org.opencv.objdetect.CascadeClassifier
import tornadofx.App
import tornadofx.View
import tornadofx.form
import tornadofx.launch
import java.io.ByteArrayInputStream
import java.net.URISyntaxException
import java.nio.file.Paths
import java.util.ArrayList

class WebCam : View() {
    override val root = form{

    }
}