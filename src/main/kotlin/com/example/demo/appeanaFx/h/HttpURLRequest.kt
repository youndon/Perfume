package AppeanaFx.h

import tornadofx.HttpURLRequest

class HttpURLRequest {
    lateinit var httpURLRequest: HttpURLRequest
    init {
        httpURLRequest.run {
            this.connection
            this.engine
            this.headers
        }
    }
}