package AppeanaFx.f

import tornadofx.Fieldset

class FieldSet {
    lateinit var fieldset: Fieldset
    init {
        fieldset.run {
            this.form
            this.icon
            this.iconProperty
            this.inputGrow
            this.inputGrowProperty
            this.labelPosition
            this.labelPositionProperty
            this.legend
            this.legendProperty
            this.text
            this.textProperty
        }
    }
}