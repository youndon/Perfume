package AppeanaFx.v

import tornadofx.ValidationContext

class ValidationContext {
    lateinit var validationContext: ValidationContext
    init {
        validationContext.run {
            this.decorationProvider
            this.isValid
            this.valid
            this.validators
//            this.addValidator() // todo
            this.error()
            this.info()
            this.success()
            this.validate()
            this.warning()
        }
//        validationContext.Validator()
    }
}