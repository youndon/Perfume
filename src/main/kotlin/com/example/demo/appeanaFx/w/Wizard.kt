package AppeanaFx.w

import tornadofx.Wizard
@Deprecated("don't have attachment!")
abstract class Wizard {
    lateinit var wizard: Wizard
    init {
        this.wizard
    }
}