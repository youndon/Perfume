package AppeanaFx.c

import tornadofx.ConfigProperties

class ConfigProperties {
    lateinit var configProperties:ConfigProperties
    init {
        configProperties.run {
            this.configurable
//            this.boolean()
//            this.int()
//            this.double()
//            this.string()
//            this.set()
//            this.save()
//            this.jsonArray()
//            this.jsonModel()
//            this.jsonModels()
//            this.jsonObject()
        }
    }


}