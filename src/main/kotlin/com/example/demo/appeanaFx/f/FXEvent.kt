package AppeanaFx.f

import tornadofx.FXEvent

class FXEvent {
    lateinit var fXEvent: FXEvent
    init {
        fXEvent.run {
            this.runOn
            this.scope
        }
    }
}