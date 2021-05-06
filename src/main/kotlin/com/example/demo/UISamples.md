
## introduction:
...

    
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

A ToolBar is a control which displays items horizontally or vertically. The most common items to place within a ToolBar are Buttons, ToggleButtons and Separators, but you are not restricted to just these, and can insert any Node into them.
If there are too many items to fit in the ToolBar an overflow button will appear. The overflow button allows you to select items that are not currently visible in the toolbar.

```kotlin
 toolbar(){
            this.items
            this.orientation
        }
```
A popup control containing an ObservableList of menu items. The items ObservableList allows for any MenuItem type to be inserted, including its subclasses Menu, MenuItem, RadioMenuItem, CheckMenuItem and CustomMenuItem. If an arbitrary Node needs to be inserted into a menu, a CustomMenuItem can be used. One exception to this general rule is that SeparatorMenuItem could be used for inserting a separator.

```kotlin
    contextmenu {
                    this.isImpl_showRelativeToWindow
                    this.items
                    this.item()
                    this.onAction
                    this.setOnAction {  }
                    this.show()
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