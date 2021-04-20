package AppeanaFx.k

import tornadofx.KeyboardLayout
import javax.json.JsonValue

class KeyboardLayout {
    lateinit var keyboardLayout: KeyboardLayout
    init {
        keyboardLayout.run {
            this.rows
            this.row { }
            this.unitSize
            this.unitSizeProperty
            this.load(JsonValue.EMPTY_JSON_OBJECT)
            this.toJSON()
            this.toKeyboardLayoutEditorFormat()
        }
    }
}