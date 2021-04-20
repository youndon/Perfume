package AppeanaFx.c

import tornadofx.CssBox
import tornadofx.Dimension

class CssBox {
    lateinit var cssBox:CssBox<Dimension<Dimension.LinearUnits>>
    // Note: I used Dimension here just as example.
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