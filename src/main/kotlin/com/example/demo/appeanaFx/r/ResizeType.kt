package AppeanaFx.r

import tornadofx.ResizeType

class ResizeType {
    lateinit var resizeType: ResizeType
    init {
        resizeType.run {
            this.delta
            this.isResizable
        }
    }
}