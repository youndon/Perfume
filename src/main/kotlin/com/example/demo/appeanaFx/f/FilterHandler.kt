package AppeanaFx.f

import tornadofx.FilterHandler

interface FilterHandler {
     var filterHandler: FilterHandler
    fun main(){
        filterHandler.run {
            this.handleFilterChange("")
            this.hideSuggestion()
            this.showSuggestion()
            this.validateSelection()
        }
    }
}