The TableView control is designed to visualize an unlimited number of rows of data, broken out into columns. A TableView is therefore very similar to the ListView control, with the addition of support for columns. For an example on how to create a TableView, refer to the 'Creating a TableView' control section below.
```kotlin
class MainView:View() {
    val list = listOf(
        User(1, "dspdojfsf"),
        User(2, "sdpfhsdpof")
    ).observable()
    override val root = vbox {
        tableview(list) {
            this.columnResizePolicy
            this.columns
            this.comparator
            this.editingCell
            this.fixedCellSize
            this.focusModel
            this.isEditable
            this.isTableMenuButtonVisible
            this.items
            this.onScrollTo
            this.onScrollToColumn
            this.onSort
            this.placeholder
            this.rowFactory
            this.selectionModel
            this.selectedCell
            this.selectedColumn
            this.selectedValue
            this.selectedItem
            this.sortOrder
            this.sortPolicy
            this.visibleLeafColumns
            this.editModel
            this.columnIndexSelections
            this.itemSelections
            this.rowIndexSelections
            this.getVisibleLeafColumn(0)
            this.sort()
            this.setOnScrollTo {  }
            this.edit()
            this.column()
            this.readonlyColumn()
            this.getVisibleLeafIndex()
            this.refresh()
            this.resizeColumn()
            this.scrollTo()
            this.setOnScrollToColumn {  }
            this.scrollToColumnIndex()
            this.scrollToColumn()
            this.setOnSort {  }
            this.setRowFactory {  }
            this.setSortPolicy {  }
            this.addColumnInternal()
            this.bindSelected()
            this.enableCellEditing()
            this.enableDirtyTracking()
            this.makeIndexColumn()
            this.nestedColumn()
            this.onEditCommit {  }
            this.rowExpander{}
            this.selectOnDrag()
            this.asyncItems {  }
            this.moveToBottomWhere {  }
            this.moveToTopWhere {  }
            this.multiSelect()
            this.selectFirst()
            this.selectWhere {  }
            this.onUserSelect {  }
            this.onSelectionChange {  }
            this.regainFocusAfterEdit()
        }
    }
}
class User(id:Int,fullName:String)
```

The TreeTableView control is designed to visualize an unlimited number of rows of data, broken out into columns. The TreeTableView control is conceptually very similar to the TreeView and TableView controls, and as you read on you'll come to see the APIs are largely the same. However, to give a high-level overview, you'll note that the TreeTableView uses the same TreeItem API as TreeView, and that you therefore are required to simply set the root node in the TreeTableView. Similarly, the TreeTableView control makes use of the same TableColumn-based approach that the TableView control uses, except instead of using the TableView-specific TableColumn class, you should instead use the TreeTableView-specific TreeTableColumn class instead. For an example on how to create a TreeTableView instance, refer to the 'Creating a TreeTableView' control section below.
```kotlin

``` 