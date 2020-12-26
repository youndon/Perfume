package AppeanaFx.d

import tornadofx.DeregisteringWeakReference

class DeregisteringWeakReference {
    lateinit var deregisteringWeakReference: DeregisteringWeakReference<*>
    init {
        deregisteringWeakReference.run {
            this.deinit
            this.ifActive {  }
        }
    }
}