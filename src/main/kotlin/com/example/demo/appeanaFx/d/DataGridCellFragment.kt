package AppeanaFx.d

import tornadofx.DataGridCellFragment

abstract class DataGridCellFragment<T> {
    lateinit var dataGridCellFragment: DataGridCellFragment<*>
    init {
        dataGridCellFragment.run {
            this.cell
            this.cellProperty
            this.editing
            this.editingProperty
            this.cancelEdit()
//            this.commitEdit()
            this.onEdit {  }
            this.startEdit()
        }
    }
}