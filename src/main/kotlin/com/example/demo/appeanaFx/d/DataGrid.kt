package AppeanaFx.d

import tornadofx.DataGrid

class DataGrid {
    lateinit var dataGrid: DataGrid<Any>
    init {
        dataGrid.run {
            this.cellCache
//            this.cellCache {  }
            this.cellCacheProperty
            this.cellFactory
            this.cellFactoryProperty
            this.cellFormat
            this.cellFormat {  }
            this.cellFormatProperty
            this.cellFragment
            this.cellFragmentProperty
//            this.cellFragment<>()
            this.cellHeight
            this.cellHeightProperty
            this.cellWidth
            this.cellWidthProperty
            this.focusModel
            this.horizontalCellSpacing
            this.horizontalCellSpacingProperty
            this.items
            this.itemsProperty
            this.maxCellsInRow
            this.maxCellsInRowProperty
            this.maxRows
            this.maxRowsProperty
            this.multiSelect
            this.scope
            this.scopeProperty
            this.selectedItem
            this.selectionModel
            this.singleSelect
            this.verticalCellSpacing
            this.verticalCellSpacingProperty
            this.onUserSelect { }
        }
    }
}