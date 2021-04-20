package AppeanaFx.s

import tornadofx.SqueezeBox

class SqueezeBox {
    lateinit var squeezeBox: SqueezeBox
    init {
        squeezeBox.run {
            this.fillHeight
            this.fillHeightProperty
            this.multiselect
            this.multiselectProperty
        }
    }
}