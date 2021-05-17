import javafx.beans.property.LongProperty
import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.TreeItemPropertyValueFactory
import tornadofx.*
import java.io.File


fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView:View() {
    val list = listOf(
        User(1, "dspdojfsf"),
        User(2, "sdpfhsdpof")
    ).observable()
    override val root = vbox {

        treetableview<File> {
            this.root
            this.columnResizePolicy
            this.columns
            this.comparator
            this.editingCell
            this.isEditable
            this.expandedItemCount
            this.fixedCellSize
            this.focusModel
            this.isShowRoot
            this.isTableMenuButtonVisible
            this.onScrollTo
            this.onScrollToColumn
            this.placeholder
            this.onSort
            this.rowFactory
            this.selectionModel
            this.sortMode
            this.sortOrder
            this.sortPolicy
            this.treeColumn
            this.visibleLeafColumns
            this.column()
            this.edit()
            this.getRow()
            this.sort()
            this.getTreeItem(0)
            this.getTreeItem()
            this.getTreeItemLevel()
            this.refresh()
            this.resizeColumn()
            this.scrollTo()
            this.scrollToColumnIndex()
            this.scrollToColumn()
            selectedCell
            selectedColumn
            selectedItem
            selectedValue
            selectFirst()
            addColumnInternal()
            bindSelected()
            nestedColumn()
            onUserSelect()
            populate()
            resizeColumnsToFitContent()
            multiSelect()
        }

    }
}

class User(var id:Int,val fullName:String)

class Files {
    private var name: StringProperty? = null
    fun setName(value: String?) {
        nameProperty().set(value)
    }

    fun getName(): String {
        return nameProperty().get()
    }

    fun nameProperty(): StringProperty {
        if (name == null) name = SimpleStringProperty(this, "name")
        return name as StringProperty
    }

    private var lastModified: LongProperty? = null
    fun setLastModified(value: Long) {
        lastModifiedProperty().set(value)
    }

    fun getLastModified(): Long {
        return lastModifiedProperty().get()
    }

    private fun lastModifiedProperty(): LongProperty {
        if (lastModified == null) lastModified = SimpleLongProperty(this, "lastModified")
        return lastModified as LongProperty
    }
}