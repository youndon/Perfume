package AppeanaFx.i

import tornadofx.ItemViewModel

class ItemViewModel {
    lateinit var itemViewModel: ItemViewModel<*>
    init {
        itemViewModel.run {
            this.empty
            this.isEmpty
            this.isNotEmpty
            this.item
            this.itemProperty
//            this.asyncItem {  }
//            this.bind()
//            this.select { }
        }
    }
}