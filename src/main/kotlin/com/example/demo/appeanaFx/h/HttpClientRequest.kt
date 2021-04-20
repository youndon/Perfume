package AppeanaFx.h

import tornadofx.HttpClientRequest

class HttpClientRequest {
    lateinit var httpClientRequest: HttpClientRequest
    init {
        httpClientRequest.run {
            this.engine
//            this.client
//            this.request
            this.method
        }
    }
}