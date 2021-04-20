package AppeanaFx.c

import tornadofx.Command

class Command {
    lateinit var command: Command<Any>
    init {
        command.run {
            this.action
            this.async
            this.enabled
            this.isEnabled
            this.isRunning
            this.running
            this.ui
            this.execute()
        }
    }
}