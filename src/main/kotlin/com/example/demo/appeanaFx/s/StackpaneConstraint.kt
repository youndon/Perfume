package AppeanaFx.s

import javafx.scene.Node
import tornadofx.StackpaneConstraint

class StackpaneConstraint {
    lateinit var stackpaneConstraint: StackpaneConstraint
    lateinit var node:Node
    init {
        stackpaneConstraint.run {
            this.alignment
            this.applyToNode(node)
        }
    }
}