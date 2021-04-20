package AppeanaFx.c

import tornadofx.ConfigProperties

class ConfigProperties {
    lateinit var configProperties:ConfigProperties
    init {
        configProperties.run {
            this.configurable
            this.boolean("")
            this.int("")
            this.double("")
            this.string("")
            this.set(Pair("",1))
            this.save()
            this.jsonArray("")
//            this.jsonModel("") // TODO: 1/26/21
            this.jsonObject("")
        }
    }


}