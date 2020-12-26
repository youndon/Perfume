package AppeanaFx.t

import tornadofx.TaskStatus

class TaskStatus {
    lateinit var taskStatus: TaskStatus
    init {
        taskStatus.run {
            this.completed
            this.message
            this.progress
            this.running
            this.title
        }
    }
}