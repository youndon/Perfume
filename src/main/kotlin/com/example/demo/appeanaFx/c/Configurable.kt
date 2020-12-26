package AppeanaFx.c

import tornadofx.Configurable

class Configurable {
    lateinit var configurable: Configurable
    init {
        configurable.run {
            this.config
//            this.configCharset
            this.configPath
            this.loadConfig()
        }
    }
}