package AppeanaFx.i

import javafx.beans.property.SimpleStringProperty
import javafx.beans.value.ObservableValue
import tornadofx.ItemViewModel
import tornadofx.View
import tornadofx.checkbox
import java.awt.Button

class ItemViewModel {
    lateinit var itemViewModel: ItemViewModel<View>
    lateinit var view: View
    init {
        itemViewModel.run {
            this.empty
            this.isEmpty
            this.isNotEmpty
            this.item
            this.itemProperty
            this.asyncItem { view }
//            this.bind() todo
            this.select { view as ObservableValue<*> }
        }
    }
}