package AppeanaFx.c

import tornadofx.CssElementDelegate

class CssElementDelegate {
    lateinit var cssElementDelegate: CssElementDelegate
    init {
        cssElementDelegate.run {
            this.name
            this.snakeCase
        }
    }
}