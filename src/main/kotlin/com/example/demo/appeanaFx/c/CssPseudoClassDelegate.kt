package AppeanaFx.c

import tornadofx.CssPseudoClassDelegate

class CssPseudoClassDelegate {
    lateinit var cssPseudoClassDelegate: CssPseudoClassDelegate
    init {
        cssPseudoClassDelegate.run {
            this.name
            this.snakeCase
        }
    }
}