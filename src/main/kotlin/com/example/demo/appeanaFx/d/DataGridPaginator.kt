package AppeanaFx.d

import tornadofx.DataGridPaginator

class DataGridPaginator {
    lateinit var dataGridPaginator: DataGridPaginator<*>
    init {
        dataGridPaginator.run {
            this.currentPage
            this.currentPageProperty
            this.items
            this.itemsPerPage
            this.itemsPerPageProperty
            this.pageCount
            this.pageCountProperty
        }
    }
}