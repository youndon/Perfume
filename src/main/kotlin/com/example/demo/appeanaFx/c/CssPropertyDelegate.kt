package AppeanaFx.c

import tornadofx.CssPropertyDelegate

class CssPropertyDelegate {
    lateinit var cssPropertyDelegate: CssPropertyDelegate<Any>
    init {
        cssPropertyDelegate.run {
            this.multiValue
            this.name
            this.renderer
        }
    }

}