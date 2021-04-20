package AppeanaFx.s

import javafx.scene.control.ListView
import tornadofx.SortedFilteredList

class SortedFilteredList {
    lateinit var sortedFilteredList: SortedFilteredList<Int>
    init {
        sortedFilteredList.run {
            this.filteredItems
            this.items
            this.predicate
            this.predicateProperty
            this.setAllPassThrough
            this.sortedItems
            this.bindTo(ListView())
//            this.filterWhen() // todo
            this.refilter()
        }
    }
}