package com.example.demo.box

import com.github.sarxos.webcam.Webcam
import javafx.application.Application
import javafx.application.Platform
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.concurrent.Task
import javafx.embed.swing.SwingFXUtils
import javafx.event.EventHandler
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.FlowPane
import javafx.stage.Stage
import tornadofx.launch
import java.awt.image.BufferedImage

fun main() {
    launch<WebCamAppLauncher>()
}
open class WebCamAppLauncher : Application() {
    private var bottomCameraControlPane: FlowPane? = null
    private var topPane: FlowPane? = null
    private var root: BorderPane? = null
    private val cameraListPromptText = "Choose Camera"
    private var imgWebCamCapturedImage: ImageView? = null
    private var webCam: Webcam? = null
    private var stopCamera = false
    private var grabbedImage: BufferedImage? = null
    var imageProperty: ObjectProperty<Image> = SimpleObjectProperty()
    private var webCamPane: BorderPane? = null
    private var btnCamreaStop: Button? = null
    private var btnCamreaStart: Button? = null
    private var btnCameraDispose: Button? = null
    override fun start(primaryStage: Stage) {
        primaryStage.title = "Connecting WebCam Using Sarxos API"
        root = BorderPane()
        topPane = FlowPane()
        topPane!!.alignment = Pos.CENTER
        topPane!!.hgap = 20.0
        topPane!!.orientation = Orientation.HORIZONTAL
        topPane!!.prefHeight = 40.0
        root!!.top = topPane
        webCamPane = BorderPane()
        webCamPane!!.style = "-fx-background-color: #ccc;"
        imgWebCamCapturedImage = ImageView()
        webCamPane!!.center = imgWebCamCapturedImage
        root!!.center = webCamPane
        createTopPanel()
        bottomCameraControlPane = FlowPane()
        bottomCameraControlPane!!.orientation = Orientation.HORIZONTAL
        bottomCameraControlPane!!.alignment = Pos.CENTER
        bottomCameraControlPane!!.hgap = 20.0
        bottomCameraControlPane!!.vgap = 10.0
        bottomCameraControlPane!!.prefHeight = 40.0
        bottomCameraControlPane!!.isDisable = true
        createCameraControls()
        root!!.bottom = bottomCameraControlPane
        primaryStage.scene = Scene(root)
        primaryStage.height = 700.0
        primaryStage.width = 600.0
        primaryStage.centerOnScreen()
        primaryStage.show()
        Platform.runLater { setImageViewSize() }
    }

    private fun setImageViewSize() {
        val height = webCamPane!!.height
        val width = webCamPane!!.width
        imgWebCamCapturedImage!!.fitHeight = height
        imgWebCamCapturedImage!!.fitWidth = width
        imgWebCamCapturedImage!!.prefHeight(height)
        imgWebCamCapturedImage!!.prefWidth(width)
        imgWebCamCapturedImage!!.isPreserveRatio = true
    }

    private fun createTopPanel() {
        val lbInfoLabel = Label("Select Your WebCam Camera")
        val options: ObservableList<WebCamInfo> = FXCollections.observableArrayList()
        topPane!!.children.add(lbInfoLabel)
        for ((webCamCounter, webcam) in Webcam.getWebcams().withIndex()) {
            val webCamInfo = WebCamInfo()
            webCamInfo.webCamIndex = webCamCounter
            webCamInfo.webCamName = webcam.name
            options.add(webCamInfo)
        }
        val cameraOptions = ComboBox<WebCamInfo>()
        cameraOptions.items = options
        cameraOptions.promptText = cameraListPromptText
        cameraOptions.selectionModel.selectedItemProperty().addListener { arg0, arg1, arg2 ->
            if (arg2 != null) {
                println("WebCam Index: " + arg2.webCamIndex + ": WebCam Name:" + arg2.webCamName)
                initializeWebCam(arg2.webCamIndex)
            }
        }
        topPane!!.children.add(cameraOptions)
    }

    private fun initializeWebCam(webCamIndex: Int) {
        val webCamTask: Task<Void?> = object : Task<Void?>() {
            @Throws(Exception::class)
            override fun call(): Void? {
                if (webCam != null) {
                    disposeWebCamCamera()
                    Webcam.getWebcams()[webCamIndex]
                                webCam?.open()
                } else {
                    Webcam.getWebcams()[webCamIndex]
                                webCam?.open()
                }
                startWebCamStream()
                return null
            }
        }
        val webCamThread = Thread(webCamTask)
        webCamThread.isDaemon = true
        webCamThread.start()
        bottomCameraControlPane!!.isDisable = false
        btnCamreaStart!!.isDisable = true
    }

    protected fun startWebCamStream() {
        stopCamera = false
        val task: Task<Void?> = object : Task<Void?>() {
            @Throws(Exception::class)
            override fun call(): Void? {
                while (!stopCamera) {
                    try {
                        if (webCam!!.image.also { grabbedImage = it } != null) {
                            Platform.runLater {
                                val mainiamge: Image = SwingFXUtils
                                    .toFXImage(grabbedImage, null)
                                imageProperty.set(mainiamge)
                            }
                            grabbedImage!!.flush()
                        }
                    } catch (e: Exception) {
                    }
                }
                return null
            }
        }
        val th = Thread(task)
        th.isDaemon = true
        th.start()
        imgWebCamCapturedImage!!.imageProperty().bind(imageProperty)
    }

    private fun createCameraControls() {
        btnCamreaStop = Button()
        btnCamreaStop!!.onAction = EventHandler { stopWebCamCamera() }
        btnCamreaStop!!.text = "Stop Camera"
        btnCamreaStart = Button()
        btnCamreaStart!!.onAction = EventHandler { startWebCamCamera() }
        btnCamreaStart!!.text = "Start Camera"
        btnCameraDispose = Button()
        btnCameraDispose!!.text = "Dispose Camera"
        btnCameraDispose!!.onAction = EventHandler { disposeWebCamCamera() }
        bottomCameraControlPane!!.children.add(btnCamreaStart)
        bottomCameraControlPane!!.children.add(btnCamreaStop)
        bottomCameraControlPane!!.children.add(btnCameraDispose)
    }

    protected fun disposeWebCamCamera() {
        stopCamera = true
        webCam!!.close()
//        Webcam.shutdown()
        btnCamreaStart!!.isDisable = true
        btnCamreaStop!!.isDisable = true
    }

    private fun startWebCamCamera() {
        stopCamera = false
        startWebCamStream()
        btnCamreaStop!!.isDisable = false
        btnCamreaStart!!.isDisable = true
    }

    private fun stopWebCamCamera() {
        stopCamera = true
        btnCamreaStart!!.isDisable = false
        btnCamreaStop!!.isDisable = true
    }

    internal inner class WebCamInfo {
        var webCamName: String? = null
        var webCamIndex = 0
        override fun toString(): String {
            return webCamName!!
        }
    }
}