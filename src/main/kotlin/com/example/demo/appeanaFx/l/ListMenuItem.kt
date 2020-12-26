package AppeanaFx.l

import tornadofx.ListMenuItem

class ListMenuItem {
    lateinit var listMenuItem: ListMenuItem
    init {
        listMenuItem.run {
            this.active
            this.activeProperty
            this.graphic
            this.graphicProperty
            this.text
            this.textProperty
            this.needsLayout()
            this.whenSelected { }
        }
    }
}