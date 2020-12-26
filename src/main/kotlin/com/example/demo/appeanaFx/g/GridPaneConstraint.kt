package AppeanaFx.g

import tornadofx.GridPaneConstraint

class GridPaneConstraint {
    lateinit var gridPaneConstraint: GridPaneConstraint
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
//            this.applyToNode() // todo
            this.columnRowIndex(1,1)
        }
    }
}