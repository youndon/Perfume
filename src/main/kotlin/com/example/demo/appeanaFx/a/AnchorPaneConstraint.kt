package AppeanaFx.a

import javafx.scene.Node
import tornadofx.AnchorPaneConstraint

class AnchorPaneConstraint {
    lateinit var anchorPaneConstraint:AnchorPaneConstraint
    init {
        AnchorPaneConstraint()
        anchorPaneConstraint.run {
            this.bottomAnchor
            this.topAnchor
            this.leftAnchor
            this.rightAnchor
//            this.applyToNode() todo
        }

    }

}