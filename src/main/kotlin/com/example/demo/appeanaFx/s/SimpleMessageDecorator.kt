package AppeanaFx.s

import tornadofx.SimpleMessageDecorator

class  SimpleMessageDecorator {
    lateinit var simpleMessageDecorator: SimpleMessageDecorator
    init {
        simpleMessageDecorator.run {
            this.attachedToNode
            this.color
            this.focusListener
            this.message
            this.tag
            this.tooltip
        }
    }
}