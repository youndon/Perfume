package AppeanaFx.t

import tornadofx.TreeCellFragment

abstract class TreeCellFragment {
    lateinit var treeCellFragment: TreeCellFragment<String>
    init {
        treeCellFragment.run {
            this.cell
            this.cellProperty
            this.editing
            this.editingProperty
            this.cancelEdit()
            this.commitEdit("")
            this.onEdit { }
            this.startEdit()
        }
    }
}