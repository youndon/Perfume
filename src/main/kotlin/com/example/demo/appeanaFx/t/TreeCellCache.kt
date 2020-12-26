package AppeanaFx.t

import tornadofx.TreeCellCache

class TreeCellCache {
    lateinit var treeCellCache: TreeCellCache<Char>
    init {
        treeCellCache.getOrCreateNode('a')
    }
}