package AppeanaFx.c

import tornadofx.CssRule

class CssRule {
    lateinit var cssRule: CssRule
    init {
        cssRule.run {
            this.name
            this.prefix
        }
    }
}