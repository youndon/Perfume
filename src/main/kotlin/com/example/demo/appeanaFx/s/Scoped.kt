package AppeanaFx.s

import tornadofx.CssRule
import tornadofx.CssSubRule
import tornadofx.Scoped

interface Scoped {
     var scoped: Scoped
    fun main(){
        scoped.run {
            this.and(CssRule("",""))
            this.append(CssSubRule(CssRule("",""),CssSubRule.Relation.ADJACENT))
            this.child(CssRule("",""))
            this.contains(CssRule("",""))
            this.next(CssRule("",""))
            this.sibling(CssRule("",""))
            this.toRuleSet()
        }
    }
}