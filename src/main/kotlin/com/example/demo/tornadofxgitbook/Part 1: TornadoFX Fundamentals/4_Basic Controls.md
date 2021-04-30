#4. Basic Controls

One of the most exciting features of TornadoFX are the Type-Safe Builders.
Configuring and laying out controls for complex UI's can be verbose and difficult, and the code can quickly become messy to maintain. 
Fortunately, you can use a powerful closure pattern pioneered by Groovy to create structured UI layouts with pure and simple Kotlin code.

While we will learn how to apply **FXML** later in [Chapter 10], you may find builders to be an expressive, robust way to create complex UI's in a fraction of the time.
There are no configuration files or compiler magic tricks, and builders are done with pure Kotlin code. 
The next several chapters will divide the builders into separate categories of controls.
Along the way, you will gradually build more complex UI's by integrating these builders together.

But first, let's cover how builders actually work.

###How Builders Work

Kotlin's standard library comes with a handful of helpful `block` functions to target items of any type `T`. 
There is the `with()` function, which allows you to write code against a control as if you were right inside of its class.
```kotlin
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import tornadofx.*

class MyView : View() {

    override val root = VBox()

    init {
        with(root) {
            this += Button("Press Me")
        }
    }
}
```
In the above example, the `with()` function accepts the `root` as an argument. 
The following closure argument manipulates `root` directly by referring to it as this, which is safely interpreted as a `VBox`.
A `Button` was added to the `VBox` by calling its `plusAssign()` extended operator.

Alternatively, every type in Kotlin has an `apply()` function.
This is almost the same functionality as `with()` but it is presented as an extended **higher-order** function.
```kotlin
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import tornadofx.*

class MyView : View() {

    override val root = VBox()

    init {
        root.apply {
            this += Button("Press Me")
        }
    }
}
```
Both `with()` and `apply()` accomplish a similar task.
They safely interpret the type they are targeting and allow manipulations to be done to it.
However, `apply()` returns the item it was targeting. 
Therefore, if you call `apply()` on a `Button` to manipulate, say, its font color and action, it is helpful the `Button` returns itself so as to not break the declaration and assignment flow.
```kotlin
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*

class MyView : View() {

    override val root = VBox()

    init {
        with(root) {
            this += Button("Press Me").apply {
                textFill = Color.RED
                action { println("Button pressed!") }
            }
        }
    }
}
```
The basic concepts of how builders work are expressed above, and there are three tasks being done:

1. A `Button` is created

2. The `Button` is modified

3. The `Button` is added to its "parent", which is a `VBox`

When declaring any `Node`, these three steps are so common that TornadoFX streamlines them for you using strategically placed extension functions, such as `button()` as shown below.
```kotlin
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*

class MyView : View() {

    override val root = VBox()

    init {
        with(root) {
            button("Press Me") {
                textFill = Color.RED
                action { println("Button pressed!") }
            }
        }
    }
}
```
While this looks much cleaner, you might be wondering: _How did we just get rid of the this `+=` and `apply()` function call? And why are we using a function called `button()` instead of an actual `Button`?_

We will not go too deep on how this is done, and you can always dig into the source code if you are curious. 
But essentially, the `VBox` (or any targetable component) has an extension function called `button()`. 
It accepts a text argument and an optional closure targeting a Button it will instantiate.

When this function is called, it will create a `Button` with the specified text, apply the closure to it, add it to the `VBox` it was called on, and then return it.

Taking this efficiency further, you can override the `root` in a `View`, but assign it a builder function and avoid needing any init or `with()` blocks.
```kotlin
import javafx.scene.paint.Color
import tornadofx.*

class MyView : View() {

    override val root = vbox {
        button("Press Me") {
            textFill = Color.RED
            action { println("Button pressed!") }
        }
    }
}
```
The builder pattern becomes especially powerful when you start nesting controls into other controls. 
Using these builder extension functions, you can easily populate and nest multiple `HBox` instances into a `VBox`, and create `UI` code that is clearly structured .
```kotlin
import tornadofx.*

class MyView : View() {

    override val root = vbox {
        hbox {
            label("First Name")
            textfield()
        }
        hbox {
            label("Last Name")
            textfield()
        }
        button("LOGIN") {
            useMaxWidth = true
        }
    }
}
```
![](pic/4.1.png)


Also **note** we will learn about TornadoFX's proprietary Form later, which will make simple input UI's like this even simpler to build.

If you need to save references to controls such as the TextFields, you can save them to variables or properties since the functions return the produced controls.
Until we learn more robust modeling techniques, it is recommended you use the `singleAssign()` delegates to ensure the properties are only assigned once.
```kotlin
import javafx.scene.control.TextField
import tornadofx.*

class MyView : View() {

    var firstNameField: TextField by singleAssign()
    var lastNameField: TextField by singleAssign()

    override val root = vbox {
        hbox {
            label("First Name")
            firstNameField = textfield()
        }
        hbox {
            label("Last Name")
            lastNameField = textfield()
        }
        button("LOGIN") {
            useMaxWidth = true
            action {
                println("Logging in as ${firstNameField.text} ${lastNameField.text}")
            }
        }
    }
}
```
**Note** that non-builder extension functions and properties have been added to different controls as well. 
The `useMaxWidth` is an extended property for `Node`, and it sets the `Node` to occupy the maximum width allowed. 
We will see more of these helpful extensions throughout the next few chapters. 
We will also see each corresponding builder for each JavaFX control. 
With the concepts understood above, you can read about these next chapters start to finish or as a reference.

###Builders for Basic Controls

The rest of this chapter will cover builders for common JavaFX controls like `Button`, `Label`, and `TextField`.
The next chapter will cover builders for data-driven controls like `ListView`, `TableView`, and `TreeTableView`.

##Button

For any Pane, you can call its `button()` extension function to add a `Button` to it. 
You can optionally pass a text argument and a `Button.() ->` Unit lambda to modify its properties.

This will add a Button with red text and print `Button pressed!` every time it is clicked
```kotlin

button("Press Me") {
    textFill = Color.RED
    action {
        println("Button pressed!")
    }
}
```
![](pic/4.2.png)


##Label

You can call the `label()` extension function to add a `Label` to a given `Pane`.
Optionally you can provide a text (of type `String` or `Property<String>`), a graphic (of `typeNode` or `ObjectProperty<Node>`) and a `Label.() ->` Unit lambda to modify its properties (Figure 4.3).
```kotlin
label("Lorem ipsum") {
    textFill = Color.BLUE
}
```
Figure 4.3


##TextField

For any target, you can add a `TextField` by calling its `textfield()` extension function (Figure 4.4).
```kotlin
textfield()
```
![](pic/4.4.png)

You can optionally provide initial text as well as a closure to manipulate the `TextField`. 
For example, we can add a listener to its `textProperty()` and print its value every time it changes.

```kotlin

textfield("Input something") {
    textProperty().addListener { obs, old, new ->
        println("You typed: $new")
    }
}
```
![](pic/4.6.png)

##PasswordField

If you need a `TextField` to take sensitive information, you might want to consider a `PasswordField` instead.
It will show anonymous characters to protect from prying eyes.
You can also provide an initial password as an argument and a block to manipulate it (Figure 4.7).
```kotlin
passwordfield("password123") {
    requestFocus()
}
```
![](pic/4.7.png)

##CheckBox

You can create a `CheckBox` to quickly create a `true/false` state control and optionally manipulate it with a block.
```kotlin
checkbox("Admin Mode") {
    action { println(isSelected) }
}
```
![](pic/4.9)


**Notice** that the action block is wrapped inside the checkbox so you can access its `isSelected` property.
If you do not need access to the properties of the `CheckBox`, you can just express it like this.
```kotlin
checkbox("Admin Mode").action {
    println("Checkbox clicked")
}
```
You can also provide a `Property<Boolean>` that will bind to its selection state.
```kotlin
val booleanProperty = SimpleBooleanProperty()

checkbox("Admin Mode", booleanProperty) {
    action {
        println(isSelected)
    }
}
```
##ComboBox

A `ComboBox` is a drop-down control that allows a fixed set of values to be selected from.
```kotlin
val texasCities = FXCollections.observableArrayList("Austin",
    "Dallas","Midland", "San Antonio","Fort Worth")

combobox<String> {
    items = texasCities
}
```
![](pic/4.10.png)

You do not need to specify the generic type if you declare the values as an argument.
```kotlin
val texasCities = FXCollections.observableArrayList("Austin",
        "Dallas","Midland","San Antonio","Fort Worth")

combobox(values = texasCities)
```
You can also specify a `Property<T>` to be bound to the selected value.
```kotlin
val texasCities = FXCollections.observableArrayList("Austin",
        "Dallas","Midland","San Antonio","Fort Worth")

val selectedCity = SimpleStringProperty()

combobox(selectedCity, texasCities)
```
##ToggleButton

A `ToggleButton` is a button that expresses a `true/false` state depending on its selection state.
```kotlin

togglebutton("OFF") {
    action {
        text = if (isSelected) "ON" else "OFF"
    }
}
```
A more idiomatic way to control the button text would be to use a `StringBinding` bound to the `textProperty`:
```kotlin
togglebutton {
    val stateText = selectedProperty().stringBinding {
        if (it == true) "ON" else "OFF"
    }
    textProperty().bind(stateText)
}
```
![](pic/4.11.png)


You can optionally pass a `ToggleGroup` to the `togglebutton()` function.
This will ensure all `ToggleButtons` in that `ToggleGroup` can only have one in a selected state at a .
```kotlin
import javafx.scene.control.ToggleGroup
import tornadofx.*

class MyView : View() {

    private val toggleGroup = ToggleGroup()

    override val root = hbox {
        togglebutton("YES", toggleGroup)
        togglebutton("NO", toggleGroup)
        togglebutton("MAYBE", toggleGroup)
    }
}
```
![](pic/4.12.png)


##RadioButton

A `RadioButton` has the same functionality as a `ToggleButton` but with a different visual style. 
When it is selected, it "fills" in a circular control.
```kotlin
radiobutton("Power User Mode") {
    action {
        println("Power User Mode: $isSelected")
    }
}
```
![](pic/4.13.png)

Also like the `ToggleButton`, you can set a `RadioButton` to be included in a `ToggleGroup` so that only one item in that group can be selected at a time.
```kotlin
import javafx.scene.control.ToggleGroup
import tornadofx.*

class MyView : View() {

    private val toggleGroup = ToggleGroup()

    override val root = vbox {
        radiobutton("Employee", toggleGroup)
        radiobutton("Contractor", toggleGroup)
        radiobutton("Intern", toggleGroup)
    }
}
```
![](pic/4.14.png)

##DatePicker

The `DatePicker` allows you to choose a date from a popout calendar control. 
You can optionally provide a block to manipulate it.
```kotlin
datepicker {
    value = LocalDate.now()
}
```
![](pic/4.15.png)

You can also provide a `Property<LocalDate>` as an argument to bind to its `value`.
```kotlin
val dateProperty = SimpleObjectProperty<LocalDate>()

datepicker(dateProperty) {
    value = LocalDate.now()
}
```
##TextArea

The `TextArea` allows you input multiline freeform text. 
You can optionally provide the initial text value as well as a block to manipulate it on declaration.
```kotlin
textarea("Type memo here") {
    selectAll()
}
```
![](pic/4.16.png)

##ProgressBar

A `ProgressBar` visualizes progress towards completion of a process. 
You can optionally provide an initial `Double value` less than or equal to `1.0` indicating percentage of completion.
```kotlin
progressbar(0.5)
```
![](pic/4.17.png)

Here is a more dynamic example simulating progress over a short period of time.
```kotlin
progressbar {
    thread {
        for (i in 1..100) {
            Platform.runLater { progress = i.toDouble() / 100.0 }
            Thread.sleep(100)
        }
    }
}
```
You can also pass a `Property<Double>` that will bind the progress to its value as well as a block to manipulate the `ProgressBar`.
```kotlin
progressbar(completion) {
    progressProperty().addListener {
        obsVal, old, new ->  print("VALUE: $new")
    }
}
```
##ProgressIndicator

A ProgressIndicator is functionally identical to a `ProgressBar` but uses a filling circle instead of a bar.
```kotlin
progressindicator {
    thread {
        for (i in 1..100) {
            Platform.runLater { progress = i.toDouble() / 100.0 }
            Thread.sleep(100)
        }
    }
}
```
![](pic/4.18.png)

Just like the `ProgressBar` you can provide a `Property<Double>` and/or a block as optional arguments.
```kotlin
val completion = SimpleObjectProperty(0.0)
progressindicator(completion)
```
##ImageView

You can embed an image using `imageview()`.
```kotlin
imageview("tornado.jpg")
```
![](pic/4.19.png)

Like most other controls, you can use a block to modify its attributes.
```kotlin
imageview("tornado.jpg") {
    scaleX = .50
    scaleY = .50
}
```
![](pic/4.20.png)

##ScrollPane

You can embed a control inside a `ScrollPane` to make it scrollable.
When the available area becomes smaller than the control, scrollbars will appear to navigate the control's area.

For instance, you can wrap an `ImageView` inside a `ScrollPane`.
```kotlin
scrollpane {
    imageview("tornado.jpg")
}
```
![](pic/4.21.png)

Keep in mind that many controls like `TableView` and `TreeTableView` already have scroll bars on them, so wrapping them in a `ScrollPane` is not necessary.

##Hyperlink

You can create a `Hyperlink` control to mimic the behavior of a typical `hyperlink` to a file, a website, or simply perform an action.
```kotlin
hyperlink("Open File").action { println("Opening file...") }
```
![](pic/4.22.png)

##Text

You can add a simple piece of `Text` with formatted properties. 
This control is simpler and rawer than a `Label`, and paragraphs can be separated using `\n` characters.
```kotlin
text("Veni\nVidi\nVici") {
    fill = Color.PURPLE
    font = Font(20.0)
}
```
![](pic/4.23.png)

##TextFlow

If you need to concatenate multiple pieces of text with different formats, the `TextFlow` control can be helpful.
```kotlin
textflow {
    text("Tornado") {
        fill = Color.PURPLE
        font = Font(20.0)
    }
    text("FX") {
        fill = Color.ORANGE
        font = Font(28.0)
    }
}
```
![](pic/4.24.png)

You can add any `Node` to the `textflow`, including images, using the standard builder functions.

##Tooltips
Inside any `Node` you can specify a `Tooltip` via the `tooltip()` function.
```kotlin
button("Commit") {
    tooltip("Writes input to the database")
}
```
![](pic/4.25.png)

Like most other builders, you can provide a closure to customize the `Tooltip` itself.
```kotlin
button("Commit") {
    tooltip("Writes input to the database") {
        font = Font.font("Verdana")
    }
}
```
##Shortcuts and Key Combinations

You can fire actions when certain key combinations are typed.
This is done with the `shortcut` function:
```kotlin
shortcut(KeyCombination.valueOf("Ctrl+Y")) {
    doSomething()
}
```
There is also a string version of the `shortcut` function that does the same but is less verbose:
```kotlin
shortcut("Ctrl+Y") {
    doSomething()
}
```
You can also add shortcuts to `button` actions directly:
```kotlin
button("Save") {
    action { doSave() }
    shortcut("Ctrl+S")
}
```
##Touch Support

JavaFX supports **touch** out of the box, and TornadoFX makes a few improvements especially for `shortpress` and `longpress` durations.
It consists of two functions similar to `action`, which can be configured on any `Node`:
```kotlin
shortpress { println("Activated on short press") }
longpress { println("Activated on long press") }
```
Both functions accept a `consume` parameter which by default is `false`. 
Setting it to true will prevent an event bubbling for the press event.
The `longpress` function additionally supports a threshold parameter which is used to determine when a `longpress` has occurred.
It is `700.millis` by default.

##SUMMARY

In this chapter we learned about TornadoFX builders and how they work simply by using Kotlin extension functions. 
We also covered builders for basic controls like `Button`, `TextField` and `ImageView`.
In the coming chapters we will learn about builders for tables, layouts, menus, charts, and other controls. 
As you will see, combining all these builders together creates a powerful way to express complex UI's with very structured and minimal code.

There are many other builder controls, and the maintainers of TornadoFX have strived to create a builder for every JavaFX control.
If you need something that is not covered here, use Google to see if its included in JavaFX.
Chances are if a control is available in JavaFX, there is a builder with the same name in TornadoFX.

These are not the only control builders in the TornadoFX API, and this guide does its best to keep up.
Always check the TornadoFX **GitHub** to see the latest builders and functionalities available, and file an issue if you see any missing.

###We are not done covering builders yet though. 
In the next section, we will cover more complex controls in the next few sections.
