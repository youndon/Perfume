package AppeanaFx.m

import tornadofx.MultiValue

class MultiValue {
    lateinit var multiValue: MultiValue<String>
    init {
        multiValue.run {
            this.elements
            this.add("")
            this.addAll()
            this.plusAssign("")
        }
    }
}