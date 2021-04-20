package AppeanaFx.s

import javafx.beans.property.SimpleStringProperty
import tornadofx.SingleAssign
import tornadofx.find
import kotlin.reflect.KProperty

interface SingleAssign {
     var singleAssign: SingleAssign<Int>

    fun some(){
        singleAssign.run {
//            this.isInitialized
//            this.getValue("") // todo
//            this.setValue() // todo
        }
    }
}