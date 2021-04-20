package AppeanaFx.l

import tornadofx.LazyTreeItem

class LazyTreeItem {
    lateinit var lazyTreeItem: LazyTreeItem<*>
    init {
        lazyTreeItem.run {
            this.childFactory
            this.childFactoryResult
            this.childFactoryInvoked
            this.itemProcessor
            this.leafCheck
            this.hasChildren()
        }
    }
}