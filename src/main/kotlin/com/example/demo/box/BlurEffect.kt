
import javafx.beans.binding.Bindings
import javafx.scene.Scene

import javafx.stage.StageStyle

import javafx.scene.control.Slider

import javafx.beans.property.SimpleDoubleProperty

import javafx.beans.property.DoubleProperty
import javafx.geometry.Insets
import javafx.scene.effect.DropShadow
import javafx.scene.layout.Region

import javafx.scene.layout.StackPane
import javafx.scene.paint.Color

import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch

fun main() {
    launch<BlurEffectApp>()
}
class BlurEffectApp: App() {
    override fun start(stage: Stage) {
        val root = StackPane()
        root.style = "-fx-background-color: null;"
        root.padding = Insets(10.0)
        val doubleProperty: DoubleProperty = SimpleDoubleProperty(0.0)
        val region = Region()
        region.styleProperty().bind(
            Bindings
                .concat("-fx-background-radius:20; -fx-background-color: rgba(56, 176, 209, ")
                .concat(doubleProperty)
                .concat(");")
        )
        region.effect = DropShadow(10.0, Color.GREY)
        val slider = Slider(0.0, 1.0, .3)
        doubleProperty.bind(slider.valueProperty())
        root.children.addAll(region, slider)
        stage.initStyle(StageStyle.TRANSPARENT)
        val scene = Scene(root, 300.0, 250.0)
        scene.fill = Color.TRANSPARENT
        stage.title = "Hello World!"
        stage.scene = scene
        stage.show()
    }
}