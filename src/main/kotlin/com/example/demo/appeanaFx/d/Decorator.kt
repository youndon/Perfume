package AppeanaFx.d

import tornadofx.Decorator

interface Decorator {
     var decorator:Decorator
    fun main(){
        decorator.run {
//            this.decorate()
//            this.undecorate()
        }
    }
}