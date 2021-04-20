package AppeanaFx.f

import tornadofx.FilterInputTextHandler

class FilterInputTextHandler {
    lateinit var filterInputTextHandler: FilterInputTextHandler
    init {
        filterInputTextHandler.run {
            this.editor
            this.filterHandler
        }
    }
}