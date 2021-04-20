package AppeanaFx.g

import javafx.scene.Node
import tornadofx.GridPaneConstraint
import tornadofx.UIComponent

class GridPaneConstraint {
    lateinit var gridPaneConstraint: GridPaneConstraint
    lateinit var node: Node
    init {
        gridPaneConstraint.run {
            this.columnIndex
            this.columnSpan
            this.fillHeight
            this.fillHeightWidth
            this.fillWidth
            this.hAlignment
            this.hGrow
            this.rowIndex
            this.rowSpan
            this.vAlignment
            this.vGrow
            this.fillHeightWidth(true)
            this.applyToNode(node) // todo
            this.columnRowIndex(1,1)
        }
    }
}