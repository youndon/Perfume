package AppeanaFx.e

import tornadofx.ExpandableTableRowSkin

class ExpandableTableRowSkin {
    lateinit var expandableTableRowSkin: ExpandableTableRowSkin<*>
    init {
        expandableTableRowSkin
                .run {
            this.expanded
            this.expander
            this.tableRow
            this.tableRowPrefHeight
        }
    }
}