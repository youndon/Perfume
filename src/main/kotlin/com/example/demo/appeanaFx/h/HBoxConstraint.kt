package AppeanaFx.h

import javafx.scene.Node
import tornadofx.HBoxConstraint

class HBoxConstraint {
    lateinit var hBoxConstraint: HBoxConstraint
    lateinit var node: Node
    init {
        hBoxConstraint.run {
            this.hGrow
            this.applyToNode(node) // todo
        }
    }
}