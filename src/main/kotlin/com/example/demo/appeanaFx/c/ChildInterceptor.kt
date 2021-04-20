package AppeanaFx.c

import javafx.event.EventDispatchChain
import javafx.event.EventTarget
import javafx.scene.Node
import tornadofx.ChildInterceptor

class ChildInterceptor {
    lateinit var childInterceptor: ChildInterceptor
    lateinit var node : Node
    init {
        childInterceptor.invoke(
            { event:EventDispatchChain -> event },
            node,1)
    }
}