package AppeanaFx.t

import tornadofx.TableCellFragment

abstract class TableCellFragment {
    lateinit var tableCellFragment: TableCellFragment<Int,Int>
    init {
        tableCellFragment.run{
            this.cell
            this.cellProperty
            this.editing
            this.editingProperty
            this.cancelEdit()
            this.commitEdit(1)
            this.onEdit {}
            this.startEdit()
        }
    }
}