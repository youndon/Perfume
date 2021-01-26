package AppeanaFx.c

import tornadofx.CssSubRule

private class CssSubRule {
    lateinit var cssSubRule: CssSubRule
    init {
        cssSubRule.run {
            this.relation
            this.rule
        }
    }
}