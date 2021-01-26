package AppeanaFx.d

import tornadofx.DIContainer

interface DIContainer {
     var dIContainer: DIContainer
    fun main(){
        dIContainer.getInstance(this::class)
    }
}