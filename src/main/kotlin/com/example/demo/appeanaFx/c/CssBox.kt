package AppeanaFx.c

import tornadofx.CssBox

class CssBox {
    lateinit var cssBox:CssBox<*>
    init {
        cssBox.run {
            this.bottom
            this.top
            this.left
            this.right
            this.copy()
        }
    }
}