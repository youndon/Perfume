package AppeanaFx.s

import tornadofx.Scope
import tornadofx.set

class Scope {
    lateinit var scope: Scope
    init {
        scope.run {
            this.hasActiveWorkspace
            this.workspace
//            this.set() todo
            this.workspace(workspace)
            this.deregister()
            this.invoke()
        }
    }
}