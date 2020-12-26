package AppeanaFx.t

import tornadofx.TableColumnCellCache

class TableColumnCellCache {
    lateinit var tableColumnCellCache: TableColumnCellCache<String>
    init {
        tableColumnCellCache.getOrCreateNode("")
    }
}