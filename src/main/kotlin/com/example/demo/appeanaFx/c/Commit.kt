package AppeanaFx.c

import tornadofx.Commit

class Commit {
    lateinit var commit: Commit
    init {
        commit.run {
            this.changed
            this.newValue
            this.oldValue
            this.property
        }
    }
}