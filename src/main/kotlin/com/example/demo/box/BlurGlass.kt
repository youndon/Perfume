package com.example.demo.box
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.beans.property.SimpleBooleanProperty
import javafx.embed.swing.SwingFXUtils
import javafx.event.EventHandler
import javafx.scene.*
import javafx.scene.control.Button
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
import tornadofx.Stylesheet.Companion.button
import java.awt.AWTException
import java.awt.Robot
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.system.exitProcess

fun main() {
    launch<BlurGlassView>()
}
//class BlurGlassApp:App(BlurGlassView::class)
class BlurGlassView : App() {
    private val BLUR_AMOUNT = 25.0
    private val frostEffect = BoxBlur(BLUR_AMOUNT, BLUR_AMOUNT, 3)
    private val blurbackground = ImageView()
    private val layout = StackPane()
    override fun start(stage: Stage) {
        layout.children.setAll(blurbackground)
        layout.children.setAll()
        layout.style = "-fx-background-color: null"
        makeSmoke(stage)
        stage.initStyle(StageStyle.TRANSPARENT)
        stage.scene = Scene(layout,400.0, 500.0,Color.TRANSPARENT).also { it ->
            it.setOnMouseClicked {
                if (it.clickCount==2){
                    exitProcess(0)
                }
            }
        }
        stage.show()
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
        return Rectangle(stage.width,stage.height,Color.BLUE.deriveColor(
                1.0, 0.5, 0.5, 0.5
            )
        )
    }
}