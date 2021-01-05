package AppeanaFx.a

import tornadofx.AuthContext

private interface AuthContext {
    var authContext: AuthContext
    fun main() {
        authContext.run {
//            this.interceptRequest()
//            this.interceptResponse()
        }
    }

}