package AppeanaFx.k

import tornadofx.KeyboardKey

class KeyboardKey {
    lateinit var keyboardKey: KeyboardKey
    init {
        keyboardKey.run {
            this.code
            this.codeProperty
            this.keyHeight
            this.keyHeightProperty
            this.keyWidth
            this.keyWidthProperty
            this.svg
            this.svgProperty
            this.toJSON()
        }
    }
}