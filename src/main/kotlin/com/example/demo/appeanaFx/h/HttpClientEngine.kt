package AppeanaFx.h

import tornadofx.HttpClientEngine

class HttpClientEngine {
    lateinit var httpClientEngine: HttpClientEngine
    init {
        httpClientEngine.run {
//            this.client // todo
//            this.context // todo
            this.rest
        }
    }
}