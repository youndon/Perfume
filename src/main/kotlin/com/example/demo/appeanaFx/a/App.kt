package AppeanaFx.a

import javafx.beans.property.SimpleObjectProperty
import jdk.jfr.Frequency
import tornadofx.*
import tornadofx.App
import java.awt.image.BufferedImage

class App {
    val appProperty = SimpleObjectProperty<App>()
    var app by appProperty

    init {
        app.run {
            this.configBasePath
            this.primaryView
            this.resources
            this.scope
            this.workspace
//            this.createPrimaryScene() todo
//            this.fire() // todo
            this.inject<Controller>() // usage: val some:<Component> by inject()
            this.k(this.javaClass) // todo
//            this.onBeforeShow() // todo
            this.shouldShowPrimaryStage()
//            this.trayicon() // todo
        }
    }
}