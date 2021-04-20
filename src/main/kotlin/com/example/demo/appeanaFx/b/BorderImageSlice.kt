package AppeanaFx.b

import tornadofx.BorderImageSlice

class BorderImageSlice {
    lateinit var borderImageSlice: BorderImageSlice
    init {
        borderImageSlice.run {
            this.filled
            this.widths
        }
    }
}