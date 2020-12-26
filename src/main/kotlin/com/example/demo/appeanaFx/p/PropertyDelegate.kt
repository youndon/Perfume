package AppeanaFx.p

import tornadofx.PropertyDelegate

class PropertyDelegate {
    lateinit var propertyDelegate: PropertyDelegate<*>
    init {
        propertyDelegate.fxProperty
    }
}