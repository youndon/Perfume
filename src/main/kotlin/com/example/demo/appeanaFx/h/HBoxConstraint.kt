package AppeanaFx.h

import tornadofx.HBoxConstraint

class HBoxConstraint {
    lateinit var hBoxConstraint: HBoxConstraint
    init {
        hBoxConstraint.run {
            this.hGrow
//            this.applyToNode() // todo
        }
    }
}