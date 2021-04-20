package AppeanaFx.m

import tornadofx.MessageEvent

class MessageEvent {
    lateinit var messageEvent: MessageEvent
    init {
        messageEvent.run {
            this.message
            this.severity
        }
    }
}