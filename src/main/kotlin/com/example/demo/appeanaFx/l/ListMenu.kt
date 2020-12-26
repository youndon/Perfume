package AppeanaFx.l

import tornadofx.ListMenu

class ListMenu {
    lateinit var listMenu: ListMenu
    init {
        listMenu.run {
            this.theme
            this.themeProperty
            this.activeItem
            this.activeItemProperty
            this.graphicFixedSizeProperty
            this.graphicFixedSized
            this.iconPosition
            this.iconPositionProperty
            this.orientation
            this.orientationProperty
            this.items
            this.item { }

        }
    }
}