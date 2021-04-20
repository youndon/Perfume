package AppeanaFx.i

import tornadofx.ItemFragment

abstract class ItemFragment {
    lateinit var itemFragment: ItemFragment<*>
    init {
        itemFragment.run {
            this.item
            this.itemProperty
        }
    }
}