
## introduction:
...



Label is a non-editable text control.
A Label is useful for displaying text that is required to fit within a specific space, and thus may need to use an ellipsis or truncation to size the string to fit.
Labels also are useful in that they can have mnemonics which, if used, will send focus to the Control listed as the target of the labelFor property.

```kotlin
    label("Hollow kotlin") {
        this.labelFor
    }
```
A simple button control. The button control can contain text and/or a graphic.
A button control has three different modes
**Normal**: A normal push button.
**Default**: A default Button is the button that receives a keyboard VK_ENTER press, if no other node in the scene consumes it.
**Cancel**: A Cancel Button is the button that receives a keyboard VK_ESC press, if no other node in the scene consumes it.
```kotlin
button("click it") {
    this.isCancelButton
    this.isDefaultButton
}
```
A ButtonBar is essentially a HBox, with the additional functionality for operating system specific button placement. In other words, any Node may be annotated (via the setButtonData(Node, ButtonBar.ButtonData) method, placed inside a ButtonBar (via the getButtons() list), and will then be positioned relative to all other nodes in the button list based on their annotations, as well as the overarching button order specified for the ButtonBar. Uniform button sizing
```kotlin
class MainView:View() {
    override val root = pane {
        buttonbar {
            this.buttonMinWidth
            this.buttonOrder
            this.buttons

            button("Yes")
            button("No")
            button("Maybe!")
        }
    }
}
```
A ToggleButton is a specialized control which has the ability to be selected. Typically a ToggleButton is rendered similarly to a Button. However, they are two different types of Controls. A Button is a "command" button which invokes a function when clicked. A ToggleButton on the other hand is simply a control with a Boolean indicating whether it has been selected.
```kotlin
class MainView:View() {
    override val root = vbox {
        togglebutton("...")
    }
}
```
class which contains a reference to all Toggles whose selected variables should be managed such that only a single Toggle within the ToggleGroup may be selected at any one time.
Generally ToggleGroups are managed automatically simply by specifying the name of a ToggleGroup on the Toggle, but in some situations it is desirable to explicitly manage which ToggleGroup is used by Toggles.
```kotlin
class MainView:View() {
    override val root = vbox {
        togglegroup {
            this.properties
            this.selectedToggle
            this.toggles
            this.userData
            this.hasProperties()
//            this.selectToggle()
//            this.bind()
            this.selectedToggleProperty()
//            this.selectedValueProperty<>()
        }
    }
}
```

```kotlin
class MainView:View() {
    override val root = vbox {
        togglegroup {
         togglebutton("yes",this)
         togglebutton("no",this)
         togglebutton("maybe",this)
        }
    }
}
```

The Text class defines a node that displays a text. Paragraphs are separated by '\n' and the text is wrapped on paragraph boundaries.
```kotlin
class MainView:View() {
    override val root = pane {
        text("something!!"){
         this.boundsType
         this.font
         this.fontSmoothingType
         this.isStrikethrough
         this.isUnderline
         this.lineSpacing
         this.text
         this.textAlignment
         this.textOrigin   
        }
    }
}
```
TextFlow is special layout designed to lay out rich text. It can be used to layout several Text nodes in a single text flow. The TextFlow uses the text and the font of each Text node inside of it plus it own width and text alignment to determine the location for each child. A single Text node can span over several lines due to wrapping and the visual location of Text node can differ from the logical location due to bidi reordering.
```kotlin
class MainView:View() {
    override val root = pane {
        textflow { 
            this.lineSpacing
            this.textAlignment
        }
    }
}
```
Text input component that allows a user to enter multiple lines of plain text. Unlike in previous releases of JavaFX, support for single line input is not available as part of the TextArea control, however this is the sole-purpose of the TextField control. Additionally, if you want a form of rich-text editing, there is also the HTMLEditor control.
```kotlin
class MainView:View() {
    override val root = pane {
        textarea { 
            this.isWrapText
            this.paragraphs
            this.prefColumnCount
            this.prefRowCount
            this.scrollLeft
            this.scrollTop
        }
    }
}
```
Text input component that allows a user to enter a single line of unformatted text. Unlike in previous releases of JavaFX, support for multi-line input is not available as part of the TextField control,
```kotlin
class MainView:View() {
    override val root = pane {
       textfield { 
           this.alignment
           this.characters
           this.onAction
           this.prefColumnCount
       }
    }
}
```
Text field that masks entered characters.
```kotlin
class MainView:View() {
    override val root = pane {
        passwordfield {

        }
    }
}
```
```kotlin
class MainView:View() {
    override val root = form {
        fieldset {
            this.text = "user"
            this.form
            this.icon
            this.inputGrow
            this.labelPosition
            this.legend
            this.wrapWidth
            this.wrapWidth
            field {
                textfield { promptText="username" }
            }
            field {
                passwordfield { promptText="password" }
            }
        }
    }
}
```
An implementation of the ComboBoxBase abstract class for the most common form of ComboBox, where a popup list is shown to users providing them with a choice that they may select from. 
For more information around the general concepts and API of ComboBox, refer to the ComboBoxBase class documentation.
On top of ComboBoxBase, the ComboBox class introduces additional API.
Most importantly, it adds an items property that works in much the same way as the ListView items property.
In other words, it is the content of the items list that is displayed to users when they click on the ComboBox button.
The ComboBox exposes the valueProperty() from ComboBoxBase, but there are some important points of the value property that need to be understood in relation to ComboBox. 
These include:
The value property is not constrained to items contained within the items list - it can be anything as long as it is a valid value of type T.
If the value property is set to a non-null object, and subsequently the items list is cleared, the value property is not nulled out.
Clearing the selection in the selection model does not null the value property - it remains the same as before.
It is valid for the selection model to have a selection set to a given index even if there is no items in the list (or less items in the list than the given index). 
Once the items list is further populated, such that the list contains enough items to have an item in the given index, both the selection model SelectionModel.selectedItemProperty() and value property will be updated to have this value.
This is inconsistent with other controls that use a selection model, but done intentionally for ComboBox.
```kotlin
class MainView:View() {
    val list = listOf(1,2,3,4,5,6).observable()
    override val root = pane {
        combobox<Int> { 
            this.buttonCell
            this.cellFactory
            this.converter
            this.editor
            this.items
            this.placeholder
            this.selectionModel
            this.visibleRowCount
            this.selectedItem
            this.valueSelections
            this.asyncItems {  }
            this.makeAutocompletable {  }
            this.cellFormat {  }
            
            items = list
        }
    }
}
```
A ListView displays a horizontal or vertical list of items from which the user may select, or with which the user may interact. A ListView is able to have its generic type set to represent the type of data in the backing model. Doing this has the benefit of making various methods in the ListView, as well as the supporting classes (mentioned below), type-safe. In addition, making use of the generic supports substantially simplifies development of applications making use of ListView, as all modern IDEs are able to auto-complete far more successfully with the additional type information.
Populating a ListView
```kotlin
class MainView:View() {
    val list = listOf(1, 2, 3, 4, 5, 6).observable()
    override val root = pane {
        listview<Int> { 
            this.cellFactory
            this.editingIndex
            this.edit()
            this.fixedCellSize
            this.focusModel
            this.isEditable
            this.items
            this.onEditCancel
            this.onEdit()
            this.onEditCommit
            this.onEditStart
            this.onScrollTo
            this.refresh()
            this.scrollTo()
            this.selectedItem
            this.useCheckbox {  }
            this.asyncItems {  }
            this.bindSelected()
            this.cellCache {  }
            this.cellFormat {  }
            this.multiSelect()
            this.onUserDelete {  }
            this.onUserSelect {  }
            this.selectWhere {  }
            
            items = list
        }
    }
}
```

```kotlin
class MainView:View() {
    override val root = pane {
        listmenu {
            this.activeItem
            this.activeItemProperty
            this.graphicFixedSizeProperty
            this.graphicFixedSized
            this.iconPosition
            this.iconPositionProperty
            this.items
            this.item {  }
            this.theme
            this.themeProperty
            this.orientation
            this.orientationProperty           
            
            
            this.items.add(ListMenuItem("One"))
            this.items.add(ListMenuItem("Tow"))
            this.items.add(ListMenuItem("Three"))
            this.items.add(ListMenuItem("Four"))
        }
    }
}
```
A MenuBar control traditionally is placed at the very top of the user interface, and embedded within it are Menus. To add a menu to a menubar, you add it to the menus ObservableList. By default, for each menu added to the menubar, it will be represented as a button with the Menu text value displayed.
```kotlin
class MainView:View() {
    override val root = pane {
        menubar {
            this.menus
            this.isUseSystemMenuBar
            this.menu {  }
            this.useSystemMenuBarProperty()
            
            this.menus.add(Menu("File"))
            this.menus.add(Menu("Edit"))
            this.menus.add(Menu("View"))
            this.menus.add(Menu("Build"))
            this.menus.add(Menu("Help"))
        }
    }
}
```
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
pane.jpg

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
borderpane.jpg

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

Chart type that plots symbols for the data points in a series.
```kotlin
class MainView:View() {
    override val root = vbox {
        scatterchart("scatterchart", NumberAxis(), NumberAxis()) {
            series("One") {
                this.data
                this.chart
                this.name
                this.node
                data(1, 24).run { 
                    
                }
                data(2, 26)
                data(3, 29)
                data(4, 22)
                data(5, 18)
            }
            series("Tow") {
                data(1, 18)
                data(2, 16)
                data(3, 7)
                data(4, 10)
                data(5, 8)
            }
        }
    }
}
```

AreaChart - Plots the area between the line that connects the data points and the 0 line on the Y axis.
```kotlin
class MainView:View() {
    override val root = vbox {
        areachart("scatterchart", NumberAxis(), NumberAxis()) {
            this.createSymbols
        }
    }
}
```

A chart that plots bars indicating data values for a category. The bars can be vertical or horizontal depending on which axis is a category axis.
```kotlin
class MainView:View() {
    override val root = vbox {
        barchart("scatterchart", CategoryAxis(), NumberAxis()) {
            this.barGap
            this.categoryGap
            series("Product X") {
                data("MAR", 10245)
                data("APR", 23963)
                data("MAY", 15038)
            }
        }
    }
}
```

StackedBarChart is a variation of BarChart that plots bars indicating data values for a category. The bars can be vertical or horizontal depending on which axis is a category axis. The bar for each series is stacked on top of the previous series.
```kotlin
class MainView:View() {
    override val root = vbox {
        stackedbarchart("scatterchart", CategoryAxis(), NumberAxis()) {
            this.categoryGap
            series("Product X") {
                data("MAR", 10245)
                data("APR", 23963)
                data("MAY", 15038)
            }
        }
    }
}
```
Chart type that plots bubbles for the data points in a series. The extra value property of Data is used to represent the radius of the bubble it should be a java.lang.Number.
```kotlin
class MainView:View() {
    override val root = vbox {
        bubblechart("scatterchart", NumberAxis(), NumberAxis()) {
            series("Product X") {
                data(1,24,1)
                data(2,46,2)
                data(3,23,1)
                data(4,27,2)
                data(5,18,1)
            }
        }
    }
}
```
Line Chart plots a line connecting the data points in a series. The data points themselves can be represented by symbols optionally. Line charts are usually used to view data trends over time or category.
```kotlin
class MainView:View() {
    override val root = vbox {
        linechart("scatterchart", NumberAxis(), NumberAxis()) {
            this.axisSortingPolicy
            this.createSymbols
            series("Product X") {
                data(1,24)
                data(2,46)
            }
        }
    }
}
```
Displays a PieChart. The chart content is populated by pie slices based on data set on the PieChart.
The clockwise property is set to true by default, which means slices are placed in the clockwise order. The labelsVisible property is used to either display pie slice labels or not.
```kotlin
class MainView:View() {
    override val root = vbox {
        piechart {
            this.data
            this.isClockwise
            this.labelLineLength
            this.labelsVisible
            this.startAngle
            this.data("",25.0).run { 
                this.pieValue
            }
        }
    }
}
```

The Rectangle class defines a rectangle with the specified size and location. By default the rectangle has sharp corners. 
```kotlin
class MainView:View() {
    override val root = vbox {
        rectangle(10,10,100,100) {
            this.width
            this.height
            this.arcHeight
            this.arcWidth
            this.x
            this.y
        }
    }
}
```
The Arc class represents a 2D arc object, defined by a center point, start angle (in degrees), angular extent (length of the arc in degrees), and an arc type (ArcType.OPEN, ArcType.CHORD, or ArcType.ROUND).
```kotlin
class MainView:View() {
    override val root = vbox {
        arc { 
            this.centerX
            this.centerY
            this.length
            this.radiusX
            this.radiusY
            this.startAngle
            this.type
        }
    }
}
```
The Circle class creates a new circle with the specified radius and center location measured in pixels Example usage. The following code creates a circle with radius 50px centered at (100,100)px.
```kotlin
class MainView:View() {
    override val root = vbox {
        circle {
            this.centerX
            this.centerY
            this.radius
        }
    }
}
```
The CubiCurve class defines a cubic Bézier parametric curve segment in (x,y) coordinate space. Drawing a curve that intersects both the specified coordinates (startX, startY) and (endX, enfY), using the specified points (controlX1, controlY1) and (controlX2, controlY2) as Bézier control points.
```kotlin
class MainView: View() {
    override val root = vbox {
        cubiccurve {
            startX = 0.0
            startY = 50.0
            controlX1 = 25.0
            controlY1 = 0.0
            controlX2 = 75.0
            controlY2 = 100.0
            endX = 150.0
            endY = 50.0
        }
    }
}
```
The Ellipse class creates a new ellipse with the specified size and location in pixels
```kotlin
class MainView: View() {
    override val root = vbox {
        ellipse {
            centerX = 50.0
            centerY = 50.0
            radiusX = 100.0
            radiusY = 50.0
        }
    }
}
```
This Line represents a line segment in (x,y) coordinate space.
```kotlin
class MainView: View() {
    override val root = vbox {
        line {
            startX = 50.0
            startY = 50.0
            endX = 150.0
            endY = 100.0
        }
    }
}
```
Creates a polyline, defined by the array of the segment points. The Polyline class is similar to the Polygon class, except that it is not automatically closed.
```kotlin
class MainView: View() {
    override val root = vbox {
     polyline(0.0, 0.0, 80.0, 40.0, 40.0, 80.0){
         this.points
     }
    }
}
```
The Quadcurve class defines a quadratic Bézier parametric curve segment in (x,y) coordinate space. Drawing a curve that intersects both the specified coordinates (startX, startY) and (endX, enfY), using the specified point (controlX, controlY) as Bézier control point.
```kotlin
class MainView: View() {
    override val root = vbox {
        quadcurve {
            startX = 0.0
            startY = 150.0
            endX = 150.0
            endY = 150.0
            controlX = 75.0
            controlY = 0.0
        }
    }
}
```
The SVGPath class represents a simple shape that is constructed by parsing SVG path data from a String.
```kotlin
class MainView: View() {
    override val root = vbox {
        svgpath("M70,50 L90,50 L120,90 L150,50 L170,50 L210,90 L180,120 L170,110 L170,200 L70,200 L70,110 L60,120 L30,90 L70,50") {
            this.content
            this.fillRule
        }
    }
}
```
The Path class represents a simple shape and provides facilities required for basic construction and management of a geometric path.
```kotlin
class MainView: View() {
    override val root = vbox {
        path(){
            this.elements
            this.fillRule
            this.arcTo {  }
            this.closepath()
            this.hlineTo()
            this.lineTo()
            this.moveTo()
            this.vlineTo()
            this.quadqurveTo {  }
        }
    }
}
```
JavaFX has an Accordion control that lets you group a set of `TilePanes` together to form an accordion of controls.
The JavaFX Accordion only lets you open a single accordion fold at a time, and it has some other shortcomings.
To solve this, TornadoFX comes with the `SqueezeBox` component that behaves and looks very similar to the Accordion, while providing some enhancements.
```kotlin
class MainView: View() {
    override val root = vbox {
        squeezebox {
            this.fillHeight
            this.multiselect
        }
    }
}
```