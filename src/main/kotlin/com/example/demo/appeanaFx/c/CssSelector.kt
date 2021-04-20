package AppeanaFx.c

import tornadofx.CssSelector
import tornadofx.CssSubRule

class CssSelector {
    lateinit var cssSelector: CssSelector
    init {
        cssSelector.run {
            this.rule
            this.simpleRender()
            this.strings(listOf(),CssSubRule.Relation.DESCENDANT)
        }
    }
}