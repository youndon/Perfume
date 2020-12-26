package AppeanaFx.c

import tornadofx.CssSubRule

class CssSubRule {
    lateinit var cssSubRule: CssSubRule
    init {
        cssSubRule.run {
            this.relation
            this.rule
        }
    }
}