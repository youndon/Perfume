package AppeanaFx.e

import javafx.scene.Node
import javafx.scene.control.TableRow
import tornadofx.ExpanderColumn
import tornadofx.UIComponent
import tornadofx.View

class ExpanderColumn {
    lateinit var expanderColumn: ExpanderColumn<UIComponent>
    lateinit var view : View
    init {
        expanderColumn.run {
            this.getExpandedNode(view)
            this.getExpandedProperty(view)
            this.getOrCreateExpandedNode(TableRow())
            this.toggleExpanded(1)
        }
    }
}