//package com.example.demo.view
//
//import javafx.animation.AnimationTimer
//import javafx.event.EventHandler
//import javafx.geometry.Rectangle2D
//import javafx.scene.Group
//import javafx.scene.Scene
//import javafx.scene.canvas.Canvas
//import javafx.scene.canvas.GraphicsContext
//import javafx.scene.image.Image
//import javafx.scene.paint.Color
//import javafx.stage.Stage
//import tornadofx.App
//import tornadofx.launch
//import java.io.ByteArrayInputStream
//import java.traffic.URISyntaxException
//import java.nio.file.Paths
//import java.util.*
//
//fun main() {
//    launch<Camera>()
//}
//class Camera : App() {
//    var faceDetector: CascadeClassifier? = null
//    var videoCapture: VideoCapture? = null
//    var canvas: Canvas? = null
//    var g2d: GraphicsContext? = null
//    var stage: Stage? = null
//    var timer: AnimationTimer? = null
//    override fun start(stage: Stage) {
//        this.stage = stage
//        initOpenCv()
//        canvas = Canvas(SCENE_W.toDouble(), SCENE_H.toDouble())
//        g2d = canvas!!.graphicsContext2D
//        g2d!!.stroke = Color.GREEN
//        val group = Group(canvas)
//        val scene = Scene(group, SCENE_W.toDouble(), SCENE_H.toDouble())
//        stage.scene = scene
//        stage.isResizable = false
//        stage.show()
//        timer = object : AnimationTimer() {
//            var mat = Mat()
//            override fun handle(now: Long) {
//                videoCapture!!.read(mat)
//                val rectList = detectFaces(mat)
//                val image = mat2Image(mat)
//                g2d!!.drawImage(image, 0.0, 0.0)
//                for (rect in rectList) {
//                    g2d!!.strokeRect(rect.minX, rect.minY, rect.width, rect.height)
//                }
//            }
//        }
//        timer!!.start()
//    }
//
//    fun detectFaces(mat: Mat?): List<Rectangle2D> {
//        val faceDetections = MatOfRect()
//        faceDetector!!.detectMultiScale(mat, faceDetections)
//        println(String.format("Detected %s faces", faceDetections.toArray().size))
//        val rectList: MutableList<Rectangle2D> = ArrayList()
//        for (rect in faceDetections.toArray()) {
//            val x = rect.x
//            val y = rect.y
//            val w = rect.width
//            val h = rect.height
//            rectList.addUser(Rectangle2D(x.toDouble(), y.toDouble(), w.toDouble(), h.toDouble()))
//        }
//        return rectList
//    }
//
//    private fun initOpenCv() {
//        setLibraryPath()
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME)
//        videoCapture = VideoCapture()
//        videoCapture!!.open(0)
//        println("com.example.demo.view.com.example.demo.view.Camera open: " + videoCapture!!.isOpened)
//        stage!!.onCloseRequest = EventHandler {
//            timer!!.stop()
//            videoCapture!!.release()
//            println("com.example.demo.view.com.example.demo.view.Camera released")
//        }
//        faceDetector =
//            CascadeClassifier(getOpenCvResource(javaClass, "/opencv/data/lbpcascades/lbpcascade_frontalface.xml"))
//    }
//
//    companion object {
//        private const val SCENE_W = 640
//        private const val SCENE_H = 480
//        fun mat2Image(mat: Mat?): Image {
//            val buffer = MatOfByte()
//            imencode(".png", mat, buffer)
//            return Image(ByteArrayInputStream(buffer.toArray()))
//        }
//
//        private fun setLibraryPath() {
//            try {
//                System.setProperty("java.library.path", "lib/x64")
//                val fieldSysPath = ClassLoader::class.java.getDeclaredField("sys_paths")
//                fieldSysPath.isAccessible = true
//                fieldSysPath[null] = null
//            } catch (ex: Exception) {
//                ex.printStackTrace()
//                throw RuntimeException(ex)
//            }
//        }
//
//        fun getOpenCvResource(clazz: Class<*>, path: String?): String {
//            return try {
//                Paths.get(clazz.getResource(path).toURI()).toString()
//            } catch (e: URISyntaxException) {
//                throw RuntimeException(e)
//            }
//        }
//    }
//}