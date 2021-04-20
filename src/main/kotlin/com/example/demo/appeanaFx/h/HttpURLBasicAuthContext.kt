package AppeanaFx.h

import tornadofx.HttpURLBasicAuthContext

class HttpURLBasicAuthContext {
    lateinit var httpURLBasicAuthContext: HttpURLBasicAuthContext
    init {
        httpURLBasicAuthContext.run {
            this.password
            this.username
        }
    }
}