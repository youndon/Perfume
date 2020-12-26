package AppeanaFx.j

import tornadofx.JsonConfig

object JsonConfig {
    lateinit var jsonConfig: JsonConfig
    init {
        jsonConfig.run {
            this.DefaultDateTimeMillis
        }
    }
}