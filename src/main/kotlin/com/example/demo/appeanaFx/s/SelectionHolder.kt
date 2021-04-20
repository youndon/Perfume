package AppeanaFx.s

import tornadofx.SelectionHolder

interface SelectionHolder {
     var selectionHolder: SelectionHolder
    fun main(){
        selectionHolder.run {
            this.addSelection(s("") {})
            this.removeSelection(s(""){})
            this.s(""){}
            this.select(""){}
        }
    }
}