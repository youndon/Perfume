package AppeanaFx.c

import tornadofx.CssSelection

class CssSelection {
    lateinit var cssSelection: CssSelection
    init {
        cssSelection.run {
            this.block
            this.selector
            this.render()
        }
    }
}