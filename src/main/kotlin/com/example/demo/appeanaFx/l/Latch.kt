package AppeanaFx.l

import tornadofx.Latch

class Latch {
    lateinit var latch: Latch
    init {
        latch.run {
            this.locked
            this.lockedProperty()
            this.release()
        }
    }
}