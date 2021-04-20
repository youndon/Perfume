package AppeanaFx.d

import tornadofx.DrawerItem

class DrawerItem {
    lateinit var drawerItem: DrawerItem
    init {
        drawerItem.run {
            this.drawer
            this.expanded
            this.expandedProperty
        }
    }
}