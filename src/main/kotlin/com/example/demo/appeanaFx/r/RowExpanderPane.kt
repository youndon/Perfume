package AppeanaFx.r

import tornadofx.RowExpanderPane

class RowExpanderPane {
    lateinit var rowExpanderPane: RowExpanderPane
    init {
        rowExpanderPane.run {
            this.expanded
            this.expanderColumn
            this.tableRow
            this.expandedProperty()
            this.toggleExpanded()
        }
    }
}