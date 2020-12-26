package AppeanaFx.k

import tornadofx.KeyFrameBuilder

class KeyFrameBuilder {
    lateinit var keyFrameBuilder: KeyFrameBuilder
    init {
        keyFrameBuilder.run {
            this.duration
            this.keyValues
            this.name
//            this.keyvalue()
//            this.plusAssign()
            this.setOnFinished {  }
        }
    }
}