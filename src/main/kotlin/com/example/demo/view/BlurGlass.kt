package com.example.demo.app
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.application.Platform
import javafx.beans.property.SimpleBooleanProperty
import javafx.embed.swing.SwingFXUtils
import javafx.event.EventHandler
import javafx.scene.*
import javafx.scene.effect.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.stage.*
import javafx.util.Duration
import tornadofx.*
import java.awt.AWTException
import java.awt.Robot
import kotlin.system.exitProcess

fun main() {
    launch<BlurGlassApp>()
}
class BlurGlassApp:App(BlurGlassView::class)
class BlurGlassView : View() {
    override var root = form {
        layout.children.setAll(blurbackground)
        layout.style = "-fx-background-color: null"
        val scene = Scene(layout,400.0, 500.0,Color.TRANSPARENT)
//        Platform.setImplicitExit(false)
        makeSmoke(stage)
        stage.initStyle(StageStyle.TRANSPARENT)
        stage.scene = scene
        stage.show()
        scene.setOnMouseClicked {
            if (it.clickCount==2){
                exitProcess(0)
            }
        }
        blurbackground.image = copyBackground(stage)
        blurbackground.effect = frostEffect
        makeDraggable(stage, layout)
    }

    // copy a background node to be frozen over.
    private fun copyBackground(stage: Stage): Image? {
        return try {
            val image = Robot().createScreenCapture(java.awt.Rectangle(
                stage.x.toInt()
                , stage.y.toInt()
                , stage.width.toInt()
                , stage.height.toInt())
            )
            SwingFXUtils.toFXImage(image, null)
        } catch (e: AWTException) {
            println("The robot of doom strikes!")
            e.printStackTrace()
            null
        }
    }

    // create some content to be displayed on top of the frozen glass panel.
//    private fun createContent(): Label {
//        val label = Label("Create a new question for drop shadow effects.\n\nDrag to move\n\nDouble click to close")
//        label.paddingAll = 10.0
//        label.style = "-fx-font-size: 15px; -fx-text-fill: green;"
//        label.maxWidth = 250.0
//        label.isWrapText = true
//        return label
//    }

    // makes a stage draggable using a given node.
    private fun makeDraggable(stage: Stage, node: Node) {
        var x = 0.0
        var y = 0.0
        node.onMousePressed = EventHandler { mouseEvent: MouseEvent ->
            // record a delta distance for the drag and drop operation.
            x = stage.x - mouseEvent.screenX
            y = stage.y - mouseEvent.screenY
            node.cursor = Cursor.MOVE
        }
        val inDrag = SimpleBooleanProperty(false)
        node.onMouseReleased = EventHandler {
            node.cursor = Cursor.HAND
            if (inDrag.get()) {
//                stage.hide()
                val pause = Timeline(
                    KeyFrame(Duration.millis(50.0),
                        EventHandler {
                            blurbackground.image = copyBackground(stage)
                            layout.children[0] = blurbackground
                            stage.show()
                        })
                )
                pause.play()
            }
            inDrag.set(false)
        }
        node.onMouseDragged = EventHandler { mouseEvent: MouseEvent ->
            stage.x = mouseEvent.screenX + x
            stage.y = mouseEvent.screenY + y
            layout.children[0] = makeSmoke(stage)
            inDrag.set(true)
        }
        node.onMouseEntered = EventHandler { mouseEvent: MouseEvent ->
            if (!mouseEvent.isPrimaryButtonDown) {
                node.cursor = Cursor.HAND
            }
        }
        node.onMouseExited = EventHandler { mouseEvent: MouseEvent ->
            if (!mouseEvent.isPrimaryButtonDown) {
                node.cursor = Cursor.DEFAULT
            }
        }
    }

    private fun makeSmoke(stage: Stage): Rectangle {
        return Rectangle(
            stage.width,
            stage.height,
            Color.BLACK.deriveColor(
                0.0, 1.0, 1.0, 0.5
            )
        )
    }

    companion object {
        private const val BLUR_AMOUNT = 25.0
        private val frostEffect: Effect = BoxBlur(BLUR_AMOUNT, BLUR_AMOUNT, 3)
        private val blurbackground = ImageView()
        private val layout = StackPane()
        private val stage = Stage()

    }
}