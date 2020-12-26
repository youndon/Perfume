package AppeanaFx.s

import tornadofx.SingleAssign
import kotlin.reflect.KProperty

interface SingleAssign {
     var singleAssign: SingleAssign<Int>
    fun main(){
        singleAssign.run {
//            this.getValue() // todo
            this.isInitialized()
//            this.setValue() // todo
        }
    }
}