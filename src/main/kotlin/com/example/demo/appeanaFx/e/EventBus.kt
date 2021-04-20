package AppeanaFx.e

import tornadofx.*
import tornadofx.EventBus

class EventBus {
    lateinit var eventBus: EventBus
    init {
        eventBus.run {
            this.fire(FXEvent())
//            this.subscribe()
//            this.unsubscribe()
        }
    }
}