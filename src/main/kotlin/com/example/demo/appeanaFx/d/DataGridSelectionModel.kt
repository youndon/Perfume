package AppeanaFx.d

import tornadofx.DataGridSelectionModel

class DataGridSelectionModel {
    lateinit var dataGridSelectionModel: DataGridSelectionModel<*>
    init {
        dataGridSelectionModel.run {
            this.dataGrid
            this.clearSelectionAndReapply()
            this.getCellAt(1)
        }
    }
}