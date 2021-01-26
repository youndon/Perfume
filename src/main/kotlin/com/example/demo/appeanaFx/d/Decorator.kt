package AppeanaFx.d

import javafx.scene.Node
import tornadofx.Decorator
import tornadofx.View

interface Decorator {
     var decorator:Decorator
     var node: Node
    fun main(){
        decorator.run {
            this.decorate(node)
            this.undecorate(node)
        }
    }
}