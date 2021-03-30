package AppeanaFx.p

import tornadofx.*
import tornadofx.PropertyDelegate

class PropertyDelegate {
    lateinit var propertyDelegate: PropertyDelegate<Int>
    init {
        propertyDelegate.fxProperty.run {
            this.isBound
            this.isDirty
            this.isNotDirty
            this.markDirty()
            this.mutateOnChange { i: Int? -> 0 }
            this.value = 0
//            this.bind()
            this.unbind()
//            this.bindBidirectional()
//            this.unbindBidirectional()
//            this.addValidator()
//            this.cleanBind()
        }
    }
}