
## introduction:
...

```kotlin
class MainView:View() {
    val list = (0..20).toList().observable()
    override val root = vbox {
       
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