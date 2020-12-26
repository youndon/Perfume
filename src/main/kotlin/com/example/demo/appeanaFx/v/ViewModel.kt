package AppeanaFx.v

import jdk.nashorn.internal.objects.annotations.Property
import tornadofx.ViewModel

class ViewModel {
    lateinit var viewModel: ViewModel
    init {
        viewModel.run {
            this.autocommitProperties
            this.dirty
            this.dirtyListListener
            this.dirtyListener
            this.dirtyProperties
            this.externalChangeListeners
            this.ignoreDirtyStateProperties
            this.isDirty
            this.isNotDirty
            this.isValid
            this.propertyCache
            this.propertyMap
            this.valid
            this.validationContext
            this.valid()
            this.setDecorationProvider {validationMessage -> null }
//            this.property<>{} // todo
//            this.addValidator() // todo
//            this.assignValue() // todo
//            this.backingValue<>() // todo
//            this.bind<> {  } // todo
            this.markDirty(paramsProperty)
            this.clearDecorators()
            this.commit()
            this.onCommit()
            this.rollback()
            this.validate()
        }
    }
}