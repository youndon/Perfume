package AppeanaFx.d

import tornadofx.DataGridRow

class DataGridRow {
    lateinit var dataGridRow: DataGridRow<*>
    init {
        dataGridRow.run {
            this.dataGrid
            this.dataGridSkin
        }
    }
}