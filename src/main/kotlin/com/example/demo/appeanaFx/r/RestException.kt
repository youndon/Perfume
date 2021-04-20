package AppeanaFx.r

import tornadofx.RestException

class RestException {
    lateinit var restException: RestException
    init {
        restException.run {
            this.request
            this.response
        }
    }
}