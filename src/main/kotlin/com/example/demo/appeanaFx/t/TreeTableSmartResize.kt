package AppeanaFx.t

import javafx.scene.control.TreeTableView
import tornadofx.TreeTableSmartResize

class TreeTableSmartResize {
    lateinit var treeTableSmartResize: TreeTableSmartResize
    init {
        treeTableSmartResize.requestResize(TreeTableView<Any>())
    }
}