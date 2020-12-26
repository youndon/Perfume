package AppeanaFx.c

import tornadofx.CssClassDelegate

class CssClassDelegate {
    lateinit var cssClassDelegate: CssClassDelegate
    init {
        cssClassDelegate.run {
            this.name
            this.snakeCase
        }
    }
}