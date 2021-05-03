
## introduction:
...

MenuButton is a button which, when clicked or pressed, will show a ContextMenu. A MenuButton shares a very similar API to the Menu control, insofar that you set the items that should be shown in the items ObservableList, and there is a text property to specify the label shown within the MenuButton.
```kotlin
class MainView:View() {
    override val root = pane {
        menubutton {
            this.isShowing
            this.items
            this.popupSide
            this.item("")
            this.hide()
            this.show()
            this.showingProperty()

            this.item("one")
            this.item("tow")
            this.item("three")
        }
    }
}
```
A ToolBar is a control which displays items horizontally or vertically. The most common items to place within a ToolBar are Buttons, ToggleButtons and Separators, but you are not restricted to just these, and can insert any Node into them.
```kotlin
class MainView:View() {
    override val root = pane {
     toolbar(){
         this.items
         this.orientation
         this.orientationProperty()
         this.button {  }
         this.separator {  }
         this.spacer {  }
     }
    }
}
```
A popup control containing an ObservableList of menu items. The items ObservableList allows for any MenuItem type to be inserted, including its subclasses Menu, MenuItem, RadioMenuItem, CheckMenuItem and CustomMenuItem. If an arbitrary Node needs to be inserted into a menu, a CustomMenuItem can be used. One exception to this general rule is that SeparatorMenuItem could be used for inserting a separator.
```kotlin
class MainView:View() {
    override val root = pane {
        contextmenu {
            this.isImpl_showRelativeToWindow
            this.items
            this.item("")
            this.onAction
            this.show(ownerWindow)
            this.checkmenuitem("")
            this.customitem {  }
            this.menu {  }
            this.radiomenuitem("")
            this.separator()
        }
    }
}
```

A control that allows for users to edit text, and apply styling to this text. The underlying data model is HTML, although this is not shown visually to the end-user.
```kotlin
class MainView:View() {
    override val root = pane {
     htmleditor { 
         this.htmlText
         this.print(PrinterJob.createPrinterJob())
     }
    }
}
```

Base class for layout panes which need to expose the children list as public so that users of the subclass can freely add/remove children.
```kotlin
class MainView:View(){
    override val root = pane{
    }
}
```

```kotlin
class MainView:View() {
    override val root = borderpane {
        setPrefSize(300.0,200.0)
        top {
            label("top")
        }
        left {
            label("left")
        }
        right {
            label("right")
        }
        bottom {
            label("bottom")
        }
        center {
            label("center")
        }
    }
}
```


## anchorpane:
AnchorPane allows the edges of child nodes to be anchored to an offset from the anchor pane's edges. If the anchor pane has a border and/or padding set, the offsets will be measured from the inside edge of those insets.
```kotlin
class MainView:View() {
    override val root = pane {
        val ap = anchorpane()

        // List should stretch as anchorPane is resized
        val list = listview(listOf("one","tow","three","four","five").observable())
        AnchorPane.setTopAnchor(list, 10.0)
        AnchorPane.setLeftAnchor(list, 10.0)
        AnchorPane.setRightAnchor(list, 65.0)

        // Button will float on right edge
        val button = button("add")
        AnchorPane.setTopAnchor(button, 10.0)
        AnchorPane.setRightAnchor(button, 10.0)
        ap.children.addAll(list, button)
    }
}
```
anchorpane.jpg

FlowPane lays out its children in a flow that wraps at the flowpane's boundary.
A horizontal flowpane (the default) will layout nodes in rows, wrapping at the flowpane's width. A vertical flowpane lays out nodes in columns, wrapping at the flowpane's height. If the flowpane has a border and/or padding set, the content will be flowed within those insets.

```kotlin
  flowpane { 
            this.alignment
            this.columnHalignment
            this.hgap
            this.vgap
            this.orientation
            this.prefWrapLength
            this.rowValignment
        }
```

GridPane lays out its children within a flexible grid of rows and columns. If a border and/or padding is set, then its content will be layed out within those insets.
```kotlin
class MainView:View() {
    override val root = gridpane {
        row {}
        isGridLinesVisible=true
        alignment
        columnConstraints
        hgap
        vgap
        rowConstraints
        addColumn(0)
        addRow(0)
        constraintsForColumn(0)
        constraintsForRow(0)
    }
}
```

StackPane lays out its children in a back-to-front stack.
The z-order of the children is defined by the order of the children list with the 0th child being the bottom and last child on top. If a border and/or padding have been set, the children will be layed out within those insets.
```kotlin
class MainView:View() {
    override val root = stackpane {
        alignment
        content
        contentUiComponent<MainView>()
        creatable
        onCreate()
        deletable
        onDelete()
        refreshable
        onRefresh()
        savable
        onSave()
        button() {
            setPrefSize(100.0,60.0)
            style{backgroundColor.plusAssign(Color.DEEPPINK)}
        }
        button() {
            setPrefSize(60.0,30.0)
            style{backgroundColor.plusAssign(Color.DEEPSKYBLUE)}
        }
    }

}
```
TilePane lays out its children in a grid of uniformly sized "tiles".
A horizontal tilepane (the default) will tile nodes in rows, wrapping at the tilepane's width. A vertical tilepane will tile nodes in columns, wrapping at the tilepane's height.
```kotlin
class MainView:View() {
    override val root = tilepane {
        this.hgap
        this.vgap
        this.prefColumns 
        this.prefRows 
        this.alignment
        this.orientation
        this.prefTileHeight
        this.prefTileWidth
        this.tileAlignment
        this.tileHeight
        this.tileWidth
        (0..20).forEach { 
            label(it.toString())
        }
    }
}
```
A TitledPane is a panel with a title that can be opened and closed.
The panel in a TitledPane can be any Node such as UI controls or groups of nodes added to a layout container.
```kotlin
class MainView:View() {
    override val root = titledpane("title") {
        this.content
        this.isAnimated
        this.isCollapsible
        this.isExpanded
        label("one")
        label("tow")
        label("three")
    }
}
```

A Control that provides a scrolled, clipped viewport of its contents. It allows the user to scroll the content around either directly (panning) or by using scroll bars. The ScrollPane allows specification of the scroll bar policy, which determines when scroll bars are displayed: always, never, or only when they are needed. The scroll bar policy can be specified independently for the horizontal and vertical scroll bars.
The ScrollPane allows the application to set the current, minimum, and maximum values for positioning the contents in the horizontal and vertical directions. These values are mapped proportionally onto the layoutBounds of the contained node.
```kotlin
class MainView:View() {
    override val root = scrollpane {
        lable(){
            setPrefSize(500.0, 500.0)
            style { backgroundColor.plusAssign(Color.ORANGERED) }
        }
    }
}
```

A control that has two or more sides, each separated by a divider, which can be dragged by the user to give more space to one of the sides, resulting in the other side shrinking by an equal amount.
Nodes can be positioned horizontally next to each other, or stacked vertically. This can be controlled by setting the orientationProperty().
The dividers in a SplitPane have the following behavior
Dividers cannot overlap another divider
Dividers cannot overlap a node.
Dividers moving to the left/top will stop when the node's min size is reached.
Dividers moving to the right/bottom will stop when the node's max size is reached.
```kotlin
class MainView:View() {
    override val root = splitpane() {
        this.dividerPositions
        this.dividers
        this.items
        this.orientation
        this.setDividerPosition(0,0.0)
        this.setDividerPositions(0.0)

        this.items.add(button("Button One"))
        this.items.add(button("Button Two"))
        this.setDividerPositions(0.3, 0.6, 0.9)
    }
}
```
A control that allows switching between a group of Tabs. Only one tab is visible at a time. Tabs are added to the TabPane by using the getTabs.
Tabs in a TabPane can be positioned at any of the four sides by specifying the Side.
A TabPane has two modes floating or recessed. Applying the styleclass STYLE_CLASS_FLOATING will change the TabPane mode to floating.
```kotlin
class MainView:View() {
    override val root = tabpane {
       this.isRotateGraphic = true
        this.selectionModel
        this.side
        this.tabClosingPolicy
        this.tabMaxHeight
        this.tabMaxWidth
        this.tabMinHeight
        this.tabMinWidth
        this.tabs
        this.tabSelections
        this.tab("tab 1"){
        }
        this.tab("tab 2"){
        }
        this.tab("tab 3"){
        }
    }
}
```

A specialization of the ProgressIndicator which is represented as a horizontal bar.
ProgressBar sets focusTraversable to false.
```kotlin
class MainView:View() {
    override val root = pane {
        progressbar {
            progress = 0.5
        }
    }
}
```
A circular control which is used for indicating progress, either infinite (aka indeterminate) or finite. Often used with the Task API for representing progress of background Tasks.
```kotlin
class MainView:View() {
    override val root = pane {
        progressindicator {
            this.isIndeterminate
            this.progress = 0.5
        }
    }
}
```
RadioButtons create a series of items where only one item can be selected. RadioButtons are a specialized ToggleButton. When a RadioButton is pressed and released a javafx.event.ActionEvent is sent. Your application can perform some action based on this event by implementing an javafx.event.EventHandler to process the javafx.event.ActionEvent.
```kotlin
class MainView:View() {
    override val root = vbox {
            radiobutton ("radioButton")
    }
}
```

```kotlin
class MainView:View() {
    override val root = vbox {
        togglegroup { 
            radiobutton("yes",this)
            radiobutton("no",this)
        }
    }
}
```
A tri-state selection Control typically skinned as a box with a checkmark or tick mark when checked. 
```kotlin
class MainView:View() {
    override val root = vbox {
       checkbox("qdfqsd") {
           this.isAllowIndeterminate
           this.isIndeterminate
           this.isSelected
       }
    }
}
```
The ChoiceBox is used for presenting the user with a relatively small set of predefined choices from which they may choose. The ChoiceBox, when "showing", will display to the user these choices and allow them to pick exactly one choice. When not showing, the current choice is displayed.
```kotlin
class MainView:View() {
    override val root = vbox {
      choicebox<Int> {
          this.converter
          this.isShowing
          this.items
          this.onAction
          this.onHidden
          this.onShowing
          this.onShown
          this.selectionModel
          this.value
          this.hide()
          this.show()
      }
    }
}
```
ColorPicker control allows the user to select a color from either a standard palette of colors with a simple one click selection OR define their own custom color.
```kotlin
class MainView:View() {
    override val root = vbox {
        colorpicker { 
            this.customColors
        }
    }
}
```
The DatePicker control allows the user to enter a date as text or to select a date from a calendar popup. The calendar is based on either the standard ISO-8601 chronology or any of the other chronology classes defined in the java.time.chrono package.
```kotlin
class MainView:View() {
    override val root = vbox {
        datepicker { 
            this.chronology
            this.converter
            this.dayCellFactory
            this.editor
            this.isShowWeekNumbers
            this.setDayCellFactory {  }
        }
    }
}
```
Canvas is an image that can be drawn on using a set of graphics commands provided by a GraphicsContext.
A Canvas node is constructed with a width and height that specifies the size of the image into which the canvas drawing commands are rendered. All drawing operations are clipped to the bounds of that image.
```kotlin
class MainView:View() {
    override val root = vbox {
        canvas { 
            this.graphicsContext2D
            this.height
            this.width
        }
    }
}
```

```kotlin
class MainView:View() {
    val list = (0..20).toList().observable()
    override val root = vbox {
        datagrid(list) { 
            this.cellCache
            this.cellFactory
            this.cellFormat
            this.cellFragment
            this.cellHeight
            this.cellWidth
            this.focusModel
            this.horizontalCellSpacing
            this.items
            this.maxCellsInRow
            this.maxRows
            this.multiSelect
            this.scope
            this.selectedItem
            this.singleSelect
            this.selectionModel
            this.verticalCellSpacing
            this.onUserSelect { }
        }
    }
}
```
```kotlin
class MainView:View() {
    val list = (0..20).toList().observable()
    override val root = vbox {
        drawer { 
            this.buttonArea
            this.contentArea
            this.contextMenu
            this.dockingSide
            this.fixedContentSize
            this.floatingDrawers
            this.items
            this.item{}
            this.maxContentSize
            this.multiselect
        }
    }
}
```
An HTML like label which can be a graphic and/or text which responds to rollovers and clicks. When a hyperlink is clicked/pressed isVisited becomes true. A Hyperlink behaves just like a Button. When a hyperlink is pressed and released a ActionEvent is sent, and your application can perform some action based on this event.
```kotlin
class MainView:View() {
    override val root = form {
        hyperlink("...") {
            this.isVisited
        }
    }
}
```
The ImageView is a Node used for painting images loaded with Image class.
This class allows resizing the displayed image (with or without preserving the original aspect ratio) and specifying a viewport into the source image for restricting the pixels displayed by this ImageView.
```kotlin
class MainView:View() {
    override val root = form {
        imageview("image.jpg"){
            this.fitHeight
            this.fitWidth
            this.image
            this.isPreserveRatio
            this.isSmooth
            this.viewport
            this.x
            this.y
        }
    }
}
```
WebView is a Node that manages a WebEngine and displays its content. The associated WebEngine is created automatically at construction time and cannot be changed afterwards. WebView handles mouse and some keyboard events, and manages scrolling automatically, so there's no need to put it into a ScrollPane.
```kotlin
class MainView:View() {
    override val root = form {
        webview { 
            this.engine.run { 
                
            }
            this.fontScale
            this.fontSmoothingType
            this.height
            this.width
            this.isContextMenuEnabled
            this.maxHeight
            this.maxWidth
            this.minHeight
            this.minWidth
            this.prefHeight
            this.prefWidth
            this.zoom
            this.setMaxSize()
            this.setMinSize()
            this.setPrefSize()
        }
    }
}
```

```kotlin
class MainView:View() {
    override val root = form {
        keyboard { 
            this.rows
            this.row {  }
            this.unitSize
            this.load(JsonValue.EMPTY_JSON_OBJECT)
            this.toJSON()
            this.toKeyboardLayoutEditorFormat()
        }
    }
}
```

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