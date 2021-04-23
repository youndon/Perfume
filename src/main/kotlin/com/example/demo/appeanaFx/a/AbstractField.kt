package appeanaFx.a

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.layout.Region
import tornadofx.AbstractField

private abstract class AbstractField:AbstractField() {
    override val inputContainer: Region
        get() = TODO("Not yet implemented")
    override val inputs: ObservableList<Node>
        get() = TODO("Not yet implemented")
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