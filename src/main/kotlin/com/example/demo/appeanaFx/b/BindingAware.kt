package AppeanaFx.b

import tornadofx.BindingAware

@Deprecated("don't have attachment!")
interface BindingAware {
     var bindingAware: BindingAware
    fun main(){
        bindingAware
    }
}