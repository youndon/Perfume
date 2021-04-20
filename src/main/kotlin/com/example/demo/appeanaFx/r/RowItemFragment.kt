package AppeanaFx.r

import tornadofx.RowItemFragment

abstract class RowItemFragment {
    lateinit var rowItemFragment: RowItemFragment<*,*>
    init {
        rowItemFragment.run {
            this.rowItem
            this.rowItemProperty
        }
    }
}