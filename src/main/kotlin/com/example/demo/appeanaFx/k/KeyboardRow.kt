package AppeanaFx.k

import tornadofx.KeyboardRow

class KeyboardRow {
    lateinit var keyboardRow: KeyboardRow
    init {
        keyboardRow.run {
            this.keys
            this.keyboard
            this.key("","",1,1,1){ }
            this.spacer(1,1)
            this.toJSON()
        }
    }
}