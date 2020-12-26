package AppeanaFx.c

import tornadofx.CommandWithParameter

class CommandWithParameter {
    lateinit var commandWithParameter: CommandWithParameter
    init {
        commandWithParameter.run {
            this.command
            this.parameter
        }
    }
}