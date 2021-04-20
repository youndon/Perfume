package AppeanaFx.l

import javafx.scene.Node
import tornadofx.LayoutDebugger

class LayoutDebugger {
    lateinit var layoutDebugger: LayoutDebugger
    lateinit var node : Node
    init {
        layoutDebugger.run {
            this.clickHandler
            this.debuggingScene
            this.gc
            this.hoverHandler
            this.hoveredNode
            this.nodeTree
            this.overlay
            this.propertyContainer
            this.sceneExitedHandler
            this.selectedNode
            this.stackpane
        }
        layoutDebugger.NodeTreeItem(LayoutDebugger.NodeContainer(node))
    }
}