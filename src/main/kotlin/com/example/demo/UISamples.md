
## introduction:
...

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