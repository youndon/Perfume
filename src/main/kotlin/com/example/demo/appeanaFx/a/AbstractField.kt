package AppeanaFx.a

import tornadofx.AbstractField

abstract class AbstractField {
    lateinit var abstractField:AbstractField
    init {
        //
        abstractField.run {
            this.fieldset
            this.forceLabelIndent
            this.inputContainer
            this.inputs
            this.label
            this.labelContainer
            this.text
            this.textProperty()
        }
    }
}