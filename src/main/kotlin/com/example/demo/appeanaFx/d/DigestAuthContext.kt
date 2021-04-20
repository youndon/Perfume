package AppeanaFx.d

import tornadofx.DigestAuthContext

class DigestAuthContext {
    lateinit var digestAuthContext: DigestAuthContext
    init {
        digestAuthContext.run {
            this.algorithm
            this.digest
            this.nonce
            this.nonceCounter
            this.opaque
            this.password
            this.qop
            this.realm
            this.username
        }
    }
}