package AppeanaFx.s

import tornadofx.StageAwareFieldset

class StageAwareFieldset {
    lateinit var stageAwareFieldset: StageAwareFieldset
    init {
        stageAwareFieldset.run {
            this.stage
            this.close()
        }
    }
}