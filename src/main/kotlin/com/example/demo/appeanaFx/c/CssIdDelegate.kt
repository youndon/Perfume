package AppeanaFx.c

import tornadofx.CssIdDelegate

class CssIdDelegate {
    lateinit var cssIdDelegate: CssIdDelegate
    init {
        cssIdDelegate.run {
            this.name
            this.snakeCase
        }
    }
}