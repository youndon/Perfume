package AppeanaFx.o

import tornadofx.ObservableStyleClass

private class ObservableStyleClass {
    lateinit var observableStyleClass: ObservableStyleClass
    init {
        observableStyleClass.run {
            this.listener
            this.value
            this.dispose()
        }
    }
}