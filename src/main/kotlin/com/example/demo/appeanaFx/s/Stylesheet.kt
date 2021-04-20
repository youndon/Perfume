package AppeanaFx.s

import tornadofx.Stylesheet

class Stylesheet {
    lateinit var stylesheet: Stylesheet
    init {
        stylesheet.run {
            this.base64URL
            this.externalForm
            this.imports
            this.selections
        }
    }
}