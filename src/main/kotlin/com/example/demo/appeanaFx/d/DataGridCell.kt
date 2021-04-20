package AppeanaFx.d

import tornadofx.DataGridCell

class DataGridCell {
lateinit var dataGridCell: DataGridCell<Any>
init {
    dataGridCell.run {
        this.cache
        this.dataGrid
        this.updating
    }

}
}