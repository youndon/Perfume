package AppeanaFx.k

import javafx.animation.KeyValue
import javafx.beans.value.WritableValue
import tornadofx.KeyFrameBuilder

class KeyFrameBuilder {
    lateinit var keyFrameBuilder: KeyFrameBuilder
    init {
        keyFrameBuilder.run {
            this.duration
            this.keyValues
            this.name
//            this.keyvalue()
//            this.plusAssign() // +=
            this.setOnFinished {  }
        }
    }
}