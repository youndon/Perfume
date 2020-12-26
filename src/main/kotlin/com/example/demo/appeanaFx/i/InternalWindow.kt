package AppeanaFx.i

import tornadofx.Controller
import tornadofx.InternalWindow

class InternalWindow {
    lateinit var internalWindow: InternalWindow
    init {
        internalWindow.run {
            this.overlay
            this.fillOverlay()
            this.close()
//            this.open()
        }
    }
}