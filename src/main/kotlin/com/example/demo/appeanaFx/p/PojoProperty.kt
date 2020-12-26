package AppeanaFx.p

import tornadofx.PojoProperty

class PojoProperty {
    lateinit var pojoProperty: PojoProperty<*>
    init {
        pojoProperty.refresh()
    }
}