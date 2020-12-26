package AppeanaFx.c

import tornadofx.CssRuleSet

class CssRuleSet {
    lateinit var cssRuleSet: CssRuleSet
    init {
        cssRuleSet.run {
            this.rootRule
            this.subRule
//            this.append()
        }
    }
}