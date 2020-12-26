package AppeanaFx.k

import tornadofx.KeyboardLayout

class KeyboardLayout {
    lateinit var keyboardLayout: KeyboardLayout
    init {
        keyboardLayout.run {
            this.rows
            this.row { }
            this.unitSize
            this.unitSizeProperty
//            this.load()
            this.toJSON()
            this.toKeyboardLayoutEditorFormat()
        }
    }
}