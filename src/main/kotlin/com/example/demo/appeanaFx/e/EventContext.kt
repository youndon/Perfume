package AppeanaFx.e

import tornadofx.EventContext

class EventContext {
    lateinit var eventContext: EventContext
    init {
        eventContext.unsubscribe()
    }
}