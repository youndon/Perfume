package AppeanaFx.s

import tornadofx.ScopedInstance
@Deprecated("don't have attachment!")
interface ScopedInstance {
     var scopedInstance: ScopedInstance
    fun main(){
        scopedInstance
    }
}