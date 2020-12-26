package AppeanaFx.v

import tornadofx.ViewTransition

abstract class ViewTransition {
    lateinit var viewTransition: ViewTransition
    init {
        viewTransition.run {
            this.setup
            this.setup(setup)
            this.setup { }
//            this.create() // todo
//            this.onComplete() // todo
//            this.stack() // todo
        }
    }
}