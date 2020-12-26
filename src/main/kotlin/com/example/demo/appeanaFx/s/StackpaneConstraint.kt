package AppeanaFx.s

import tornadofx.StackpaneConstraint

class StackpaneConstraint {
    lateinit var stackpaneConstraint: StackpaneConstraint
    init {
        stackpaneConstraint.run {
            this.alignment
//            this.applyToNode()
        }
    }
}