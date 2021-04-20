package AppeanaFx.r

import tornadofx.Rest

class Rest {
    lateinit var rest: Rest
    init {
        rest.run {
            this.authContext
            this.baseURI
            this.engine
            this.proxy
            this.get("")
            this.delete("")
            this.execute(Rest.Request.Method.DELETE,"")
            this.getURI("")
            this.patch("")
            this.post("")
            this.put("")
            this.reset()
            this.setBasicAuth("","")
            this.setDigestAuth("","")
        }
    }
}