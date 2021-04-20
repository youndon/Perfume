package AppeanaFx.r

import tornadofx.ResourceLookup

class ResourceLookup {
    lateinit var resourceLookup: ResourceLookup
    init {
        resourceLookup.run {
            this.component
            this[""]
            this.image("")
            this.imageview("")
            this.json("")
            this.jsonArray("")
            this.stream("")
            this.text("")
            this.url("")
        }
    }
}