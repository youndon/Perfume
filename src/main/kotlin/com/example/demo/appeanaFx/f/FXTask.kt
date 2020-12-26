package AppeanaFx.f

import tornadofx.FXTask

class FXTask {
    lateinit var fXTask: FXTask<*>
    init {
        fXTask.run {
            this.completed
            this.completedProperty
            this.func
            this.status
            this.finally {  }
            this.value("")
        }
    }
}