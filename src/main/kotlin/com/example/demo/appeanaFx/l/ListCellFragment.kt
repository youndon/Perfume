package AppeanaFx.l

import tornadofx.ListCellFragment

class ListCellFragment {
    lateinit var listCellFragment: ListCellFragment<Int>
    init {
        listCellFragment.run {
            this.cell
            this.cellProperty
            this.editing
            this.editingProperty
            this.cancelEdit()
            this.commitEdit(1)
            this.onEdit { }
            this.startEdit()
        }
    }
}