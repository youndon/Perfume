package AppeanaFx.r

import tornadofx.Resettable

interface Resettable {
     var resettable: Resettable
    fun main(){
        resettable.reset()
    }
}