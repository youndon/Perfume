Label.
-----
Label is a non-editable text control.
A Label is useful for displaying text that is required to fit within a specific space, and thus may need to use an ellipsis or truncation to size the string to fit.
Labels also are useful in that they can have mnemonics which, if used, will send focus to the Control listed as the target of the labelFor property.

Extensions | Property | Description
 -----     | ----     | ------
`labelFor`  |  `labelForProperty()` | ...

**Example**:
```kotlin
   class MainView: View() {
    override val root = borderpane {
        center {
            label("Kotlin is Fun").style {
                fontSize=40.px
                fontFamily="Manjari"
                textFill= Color.DARKORANGE
            }
        }
    }
}
```
_Note_: I used style in the example, but you'll see more details later about style and css in tornadofx.

**Output**:

![](Pics/label.png)

Button.
-----
A simple button control.
The button control can contain text and/or a graphic.

Extensions |      Property | Description
  -----     |       ----     | ------
`isDefaultButton` | `cancelButtonProperty()` | A default Button is the button that receives a keyboard `VK_ENTER` press, if no other node in the scene consumes it.
`isCancelButton` | `defaultButtonProperty()` | A Cancel Button is the button that receives a keyboard `VK_ESC` press, if no other node in the scene consumes it.

**Example**:
```kotlin
class MainView: View() {
    override val root = borderpane {
        center{
            button("Click_It"){
                style{
                    fontSize=30.px
                    fontFamily="Ubuntu"
                    textFill=Color.DEEPSKYBLUE
                    backgroundColor+=Color.DARKORANGE
                    backgroundRadius+= CssBox(20.px,20.px,20.px,20.px)
                }
                action {
                    this@MainView.close()
                }
            }
        }
    }
}
```
**Output**:

![](Pics/button.png)

ButtonBar.
-------

A `ButtonBar` is essentially a `HBox`, with the additional functionality for operating system specific button placement.
In other words, any `Node` may be annotated (via the setButtonData(`Node`, `ButtonBar.ButtonData`) method, placed inside a `ButtonBar` (via the `getButtons()` list),
and will then be positioned relative to all other nodes in the button list based on their annotations, as well as the overarching button order specified for the `ButtonBar`.
Uniform button sizing

Extensions |      Property | Description
  -----     |       ----     | ------
`buttonMinWidth` | `buttonMinWidthProperty()`  | **Returns** the minimum width of all buttons placed in this button bar.
`buttonOrder` | `buttonOrderProperty()` | **Returns** the current button order.
`buttons` |  Yes | **Returns**: A list containing all buttons currently in the button bar, and allowing for further buttons to be added or removed.
`button()` | No  | A Simple Button.

**Example**:

```kotlin
class MainView: View() {
    override val root = pane{
        buttonbar(buttonOrder = BUTTON_ORDER_LINUX){
            buttonMinWidth = 80.0
            button("One")
            button("Tow")
            button("Three")
        }
    }
}
```
**Output:**

![](Pics/buttonbar.png)

ToggleButton.
-----------

A `ToggleButton` is a button that expresses a `true/false` state depending on its selection state.

**Example**:

```kotlin
class MainView: View() {
    override val root = borderpane{
        setPrefSize(200.0,200.0)
        center = togglebutton {
            textProperty().bind(selectedProperty().stringBinding {
                if (it == true) "ON" else "OFF"
            })
        }
    }
}
```
**Output**:

![](Pics/togglebutton2.png) ![](Pics/togglebutton1.png)

ToggleGroup.
----------

class which contains a reference to all Toggles whose selected variables should be managed such that only a single Toggle within the ToggleGroup may be selected at any one time.
Generally ToggleGroups are managed automatically simply by specifying the name of a ToggleGroup on the Toggle, but in some situations it is desirable to explicitly manage which ToggleGroup is used by Toggles.

Extensions    |    Property   |  Description
  -----       |    -------    | ------
`properties`  |      Yes       | **Returns** an observable map of properties on this node for use primarily by application developers.
`selectedToggle` | `selectedToggleProperty()` | **Returns**:Toggle The selected toggle.
`toggles` |      Yes      | The list of toggles within the `ToggleGroup`.
`userData` |     No     | **Returns** a previously set Object property, or `null` if no such property has been set using the `setUserData(Object)` method.
`hasProperties()` |    No    | **Returns**:`true` if node has properties.
`selectToggle()` |    No    | **Params**:value – The Toggle that is to be selected.
`bind()` |    No    |  ...
No    | `selectedValueProperty<>()` | ...

**Example**:

```kotlin
class MainView:View() {
    override val root = hbox {
        alignment = Pos.BOTTOM_CENTER
        togglegroup {
            togglebutton("Yes", this)
            togglebutton("No", this)
            togglebutton("Maybe!", this)
        }
    }
}
```
**Output**:

![](Pics/togglegroup.png)

Text.
-----

The Text class defines a node that displays a text.
Paragraphs are separated by `\n` and the text is wrapped on paragraph boundaries.

Extensions    |    Property   |  Description
  -----       |    -------    | ------
`text` | `textProperty()` | Defines text string that is to be displayed.
`textOrigin` | `textOriginProperty()` | Defines the origin of text coordinate system in local coordinates. _Note_: in case multiple rows are rendered `VPos.BASELINE` and `VPos.TOP` define the origin of the top row while `VPos.BOTTOM` defines the origin of the bottom row.
`textAlignment` | `textAlignmentProperty()` | Defines horizontal text alignment in the bounding box. The width of the bounding box is defined by the widest row. _Note_: In the case of a single line of text, where the width of the node is determined by the width of the text, the alignment setting has no effect.
`font` | `fontProperty()` | Defines the font of text.
`fontSmoothingType`  | `fontSmoothingTypeProperty()` | Specifies a requested font smoothing type : `gray` or `LCD`. The width of the bounding box is defined by the widest row. Note: LCD mode doesn't apply in numerous cases, such as various compositing modes, where effects are applied and very large glyphs.
`boundsType` | `boundsTypeProperty()` | Determines how the bounds of the text node are calculated. Logical bounds is a more appropriate default for text than the visual bounds. See TextBoundsType for more information.
`isStrikethrough` | `strikethroughProperty()` | Defines if each line of text should have a line through it.
`isUnderline` | `underlineProperty()` | Defines if each line of text should have a line below it.
`lineSpacing` | `lineSpacingProperty()` | Defines the vertical space in pixel between lines.
`baselineOffset` | `baselineOffsetProperty()` | The 'alphabetic' (or roman) baseline offset from the Text node's layoutBounds.minY location. The value typically corresponds to the max ascent of the font.
`wrappingWidth` | `wrappingWidthProperty()` | Defines a width constraint for the text in user space coordinates, e.g. pixels, not glyph or character count. If the value is > 0 text will be line wrapped as needed to satisfy this constraint.
`x` | `xProperty()` | Defines the X coordinate of text origin.
`y` | `yProperty()` | Defines the Y coordinate of text origin.
**Example**:

```kotlin
class MainView: View() {
    override val root = hbox {
        text {
            text = "Kotlin + TornadoFx is Fun"
            this.font = Font("Manjari", 30.0)
        }
    }
}
```
**Output**:

![](Pics/text.png)

TextFlow.
-------

TextFlow is special layout designed to lay out rich text. 
It can be used to layout several Text nodes in a single text flow. 
The TextFlow uses the `text` and the `font` of each Text node inside of it plus it own width and text alignment to determine the location for each child.
A single Text node can span over several lines due to wrapping and the visual location of Text node can differ from the logical location due to bidi reordering.

Extensions    |    Property   |  Description
  -----       |    -------    | ------
`lineSpacing` | `lineSpacingProperty()` | Defines the vertical space in pixel between lines.
`textAlignment` | `textAlignmentProperty()` | Defines horizontal text alignment

**Example**:

```kotlin
class MainView:View() {
    override val root = pane {
        textflow {
            text("S").style{fontSize=33.px; fill= Color.LIGHTBLUE}
            text("omething ").style{fontSize=26.px; fill= Color.DARKORANGE}
            text("L").style{fontSize=33.px; fill= Color.LIGHTBLUE}
            text("ike this").style{fontSize=26.px; fill= Color.DARKORANGE}
        }
    }
}
```
**Output**:

![](Pics/textflow.png)

TextArea.
-------

Text input component that allows a user to enter multiple lines of plain text.
Unlike in previous releases of **JavaFX**, support for single line input is not available as part of the TextArea control, 
however this is the sole-purpose of the TextField control.

Extensions    |    Property   |  Description
  -----       |    -------    | ------
`isWrapText` | `wrapTextProperty()` | If a run of text exceeds the width of the TextArea, then this variable indicates whether the text should wrap onto another line.
`paragraphs`| Yes | **Returns** an unmodifiable list of the character sequences that back the text area's content.
`prefColumnCount` | `prefColumnCountProperty()` |The preferred number of text columns. This is used for calculating the TextArea's preferred width.
`prefRowCount` | `prefRowCountProperty()` | The preferred number of text rows. This is used for calculating the TextArea's preferred height.
`scrollLeft` | `scrollLeftProperty()` | The number of pixels by which the content is horizontally scrolled.
`scrollTop` | `scrollTopProperty()` | The number of pixels by which the content is vertically scrolled.

**Example**:

```kotlin
class MainView: View() {
    override val root = hbox {
        textarea(str) {
            isWrapText=true
            font = Font("Manjari",25.0)
        }
    }
}
```
**Output**:

![](Pics/textarea.png)

TextField.
--------

Text input component that allows a user to enter a single line of unformatted text. 
Unlike in previous releases of **JavaFX**, support for multi-line input is not available as part of the TextField control,

Extensions    |    Property   |  Description
  -------     |    -------    |   --------
`alignment` | `alignmentProperty()` | Specifies how the text should be aligned when there is empty space within the TextField.
`characters` | No | **Returns** the character sequence backing the text field's content.
`onAction` | `onActionProperty()` | The action handler associated with this text field, or null if no action handler is assigned. The action handler is normally called when the user types the **ENTER** key.
`prefColumnCount` | `prefColumnCountProperty()` | The preferred number of text columns. This is used for calculating the TextField's preferred width.

**Example**:
```kotlin
class MainView: View() {
    override val root = borderpane {
        center = textfield {
            onAction= EventHandler { println(this.characters) }
        }
    }
}
```
**Output**:

![](Pics/textfield.png)

And when you press Enter key will get in **condole**:

`this is it!!`

PasswordField.
-----------

Text field that masks entered characters.

**Example**:

```kotlin
class MainView:View() {
    override val root = borderpane {
        center = passwordfield {
            onAction= EventHandler { println(this.characters) }
        }
    }
}
```

**Output**:

![](Pics/passwordfield.png)

And when you press Enter key will get in **condole**:

`password!!`

FieldSet.
-------

Extensions    |    Property   |  Description
  -------     |    -------    |   --------
`text` | `textProperty()` | 
`form` | No | ...
`icon` | `iconProperty()` | ...
`inputGrow` | `inputGrowProperty()` | Enumeration used to determine the grow (or shrink) priority of a given node's layout area when its region has more (or less) space available and multiple nodes are competing for that space. _more detailes below_
`labelPosition` | `labelPositionProperty()` | Orientation: `HORIZONTAL` right <-> left orientation, `VERTICAL` top <-> bottom orientation
`legend` | `legendProperty` | ... 

**see also:**

Priority can be :
* `ALWAYS` Layout area will always try to grow (or shrink), sharing the increase (or decrease) in space with other layout areas that have a grow (or shrink) of ALWAYS.
* `SOMETIMES` If there are no other layout areas with grow (or shrink) set to ALWAYS or those layout areas didn't absorb all of the increased (or decreased) space, then will share the increase (or decrease) in space with other layout area's of SOMETIMES.
* `NEVER` Layout area will never grow (or shrink) when there is an increase (or decrease) in space available in the region.

**Example:**

```kotlin
class MainView: View() {
    override val root = form {
        fieldset {
            text = "Sign in"
            this.legend = label("Please fill you the fields below.")
            field {
                textfield { promptText="Enter your name" }
            }
            field {
                passwordfield { promptText="Enter your pass" }
            }
        }
    }
}
```

**Output:**

![](Pics/fieldset.png)

Combobox.
-------

An implementation of the `ComboBoxBase` abstract class for the most common form of `ComboBox`,
where a popup list is shown to users providing them with a choice that they may select from.
For more information around the general concepts and **API** of `ComboBox`, refer to the `ComboBoxBase` class documentation.
On top of `ComboBoxBase`, the `ComboBox` class introduces additional **API**.
Most importantly, it adds an items property that works in much the same way as the ListView items property.
In other words, it is the content of the items list that is displayed to users when they click on the ComboBox button.
The `ComboBox` exposes the `valueProperty()` from `ComboBoxBase`, but there are some important points of the value property that need to be understood in relation to `ComboBox`.
These include:
* The value property is not constrained to items contained within the items list - it can be anything as long as it is a valid value of type `T`.
* If the value property is set to a non-null object, and subsequently the items list is cleared, the value property is not nulled out.
* Clearing the selection in the selection model does not null the value property - it remains the same as before.
* It is valid for the selection model to have a selection set to a given index even if there are no items in the list (or less items in the list than the given index).
Once the items list is further populated, such that the list contains enough items to have an item in the given index,
both the selection model `SelectionModel.selectedItemProperty()` and value property will be updated to have this value.
This is inconsistent with other controls that use a selection model, but done intentionally for `ComboBox`.

Extensions    |    Property   |  Description
  -------     |    -------    |   --------
`buttonCell` | `buttonCellProperty()` | The button cell is used to render what is shown in the ComboBox `'button'` area. If a cell is set here.
`cellFactory` | `cellFactoryProperty()` | Providing a custom cell factory allows for complete customization of the rendering of items in the ComboBox. Refer to the Cell javadoc for more information on cell factories.
`converter` | `converterProperty()` | Converts the user-typed input (when the ComboBox is editable) to an object of type `T`, such that the input may be retrieved via the value property.
`editor` | `editorProperty()` | The `editor` for the ComboBox. The editor is null if the ComboBox is not editable.
`items` | `itemsProperty()` | The list of items to show within the ComboBox popup.
`placeholder` | `placeholderProperty()` | This `Node` is shown to the user when the ComboBox has no content to show. The `placeholder` node is shown in the ComboBox popup area when the items list is null or empty.
`selectionModel` | `selectionModelProperty()` | The selection model for the ComboBox. A ComboBox only supports single selection.
`visibleRowCount` | `visibleRowCountProperty()` | The maximum number of rows to be visible in the ComboBox popup when it is showing. By default this value is `10`.
`selectedItem`| No | **Return** the index of the item that selected.
`valueSelections`| No | ...
`asyncItems { }` | No | ...
`makeAutocompletable()` | No | ...
`cellFormat { }` | No | ...

**Example:**

```kotlin
class MainView: View() {
    val list = listOf("Austin",
        "Dallas","Midland", "San Antonio","Fort Worth").observable()
    override val root = vbox {
        combobox<String> {
            items = list
        }
    }
}
```

**Output:**

![](Pics/combobox.png)