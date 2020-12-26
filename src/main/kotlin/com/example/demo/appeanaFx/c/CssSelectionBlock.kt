package AppeanaFx.c

import tornadofx.CssSelectionBlock

class CssSelectionBlock {
    lateinit var cssSelectionBlock: CssSelectionBlock
    init {
        cssSelectionBlock.run {
            this.log
            this.selections
//            this.and()
//            this.child()
//            this.contains()
//            this.mix()
//            this.next()
//            this.sibling()
        }
    }
}