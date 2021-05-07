
## introduction:
...

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