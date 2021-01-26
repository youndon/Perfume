package AppeanaFx.j

import tornadofx.JsonBuilder

class JsonBuilder {
    lateinit var jsonBuilder: JsonBuilder
    init {
        jsonBuilder.run {
            this.add("","")
            this.build()
        }
    }
}