package AppeanaFx.s

import tornadofx.SmartTableCell

class SmartTableCell {
    lateinit var smartTableCell: SmartTableCell<*,*>
    init {
        smartTableCell.run {
            this.owningColumn
            this.scope
        }
    }
}