package AppeanaFx.d

import tornadofx.DataGridSkin

class DataGridSkin {
    lateinit var dataGridSkin: DataGridSkin<*>
    init {
        dataGridSkin.run {
            this.computeMaxCellsInRow()
            this.computeRowWidth()
            this.createCell()
            this.itemCount
            this.getRow(1)
            this.handleControlPropertyChanged("")
        }
    }
}