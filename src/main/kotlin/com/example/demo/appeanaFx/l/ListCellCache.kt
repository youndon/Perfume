package AppeanaFx.l

import tornadofx.ListCellCache
import tornadofx.View

class ListCellCache {
    lateinit var listCellCache: ListCellCache<Any>
    init {
        listCellCache.getOrCreateNode("")
    }
}