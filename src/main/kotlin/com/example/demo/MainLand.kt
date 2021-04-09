package com.example.demo.view

import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.geometry.Orientation
import javafx.scene.paint.Color
import org.nield.dirtyfx.beans.DirtyObjectProperty
import org.nield.dirtyfx.beans.DirtyStringProperty
import org.nield.dirtyfx.extensions.addTo
import org.nield.dirtyfx.tracking.CompositeDirtyProperty
import tornadofx.*
import java.time.LocalDate

fun main() {
    launch<MainLand>()
}
class MainLand:App(MainView::class)

class MainView : UIComponent() {
    override val root = vbox {
    }
}