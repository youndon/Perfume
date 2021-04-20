package AppeanaFx.p

import javafx.beans.InvalidationListener
import javafx.collections.MapChangeListener
import tornadofx.View
import tornadofx.adapters.Properties
import tornadofx.toProperty

class Properties {
    lateinit var properties:Properties
    init {
        properties.run {
            this.addListener ( InvalidationListener{
            })
            this.addListener(MapChangeListener {
            })
            this.removeListener( InvalidationListener {
            })
            this.removeListener(MapChangeListener {
            })
        }
    }
}