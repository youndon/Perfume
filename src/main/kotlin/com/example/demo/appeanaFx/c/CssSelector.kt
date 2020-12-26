package AppeanaFx.c

import tornadofx.CssSelector

class CssSelector {
    lateinit var cssSelector: CssSelector
    init {
        cssSelector.run {
            this.rule
            this.simpleRender()
//            this.strings()
        }
    }
}