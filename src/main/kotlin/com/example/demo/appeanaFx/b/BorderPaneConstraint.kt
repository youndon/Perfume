package AppeanaFx.b

import javafx.scene.Node
import tornadofx.BorderPaneConstraint

class BorderPaneConstraint {
    lateinit var borderPaneConstraint: BorderPaneConstraint
    lateinit var node: Node
    init {
        borderPaneConstraint.run {
            this.alignment
            this.applyToNode(node)
        }
    }
}