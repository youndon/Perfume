package AppeanaFx.v

import tornadofx.ValidationMessage

class ValidationMessage {
    lateinit var validationMessage: ValidationMessage
    init {
        validationMessage.run {
            this.message
            this.severity
        }
    }
}