package AppeanaFx.k

import tornadofx.KeyboardRow

class KeyboardRow {
    lateinit var keyboardRow: KeyboardRow
    init {
        keyboardRow.run {
            this.keys
            this.keyboard
            this.key { }
            this.spacer()
            this.toJSON()
        }
    }
}