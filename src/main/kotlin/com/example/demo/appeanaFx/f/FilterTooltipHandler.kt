package AppeanaFx.f

import tornadofx.FilterTooltipHandler

class FilterTooltipHandler {
    lateinit var filterTooltipHandler: FilterTooltipHandler
    init {
        filterTooltipHandler.run {
            this.control
            this.filterHandler
        }
    }
}