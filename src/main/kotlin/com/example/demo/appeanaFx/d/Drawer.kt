package AppeanaFx.d

import tornadofx.Drawer

class Drawer {
    lateinit var drawer: Drawer
    init {
        drawer.run {
            this.buttonArea
            this.contentArea
            this.contextMenu
            this.dockingSide
            this.dockingSideProperty
            this.fixedContentSize
            this.fixedContentSizeProperty
            this.floatingDrawers
            this.floatingDrawersProperty
            this.items
            this.maxContentSize
            this.maxContentSizeProperty
        }
    }
}