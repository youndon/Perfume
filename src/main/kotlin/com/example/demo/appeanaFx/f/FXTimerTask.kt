package AppeanaFx.f

import tornadofx.FXTimerTask

class FXTimerTask {
    lateinit var fXTimerTask: FXTimerTask
    init {
        fXTimerTask.run{
            this.completed
            this.completedProperty
            this.op
            this.running
            this.runningProperty
            this.timer
        }
    }
}