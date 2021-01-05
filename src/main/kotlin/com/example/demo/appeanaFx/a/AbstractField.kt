package com.example.demo.appeanaFx.a

import tornadofx.AbstractField

private abstract class AbstractField {
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