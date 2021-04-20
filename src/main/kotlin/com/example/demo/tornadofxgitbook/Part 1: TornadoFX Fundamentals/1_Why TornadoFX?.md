#1. Why TornadoFX?

![](pic/0.0.png)

##Introduction

User interfaces are becoming increasingly critical to the success of consumer and business applications.
With the rise of consumer mobile apps and web applications, business users are increasingly holding enterprise applications to a higher standard of quality.
They want rich, feature-packed user interfaces that provide immediate insight and navigate complex screens intuitively. 
More importantly, they want the application to adapt quickly to business changes on a frequent basis. 
For the developer, this means the application must not only be maintainable but also evolvable.
**TornadoFX** seeks to assist all these objectives and greatly streamline the development of **JavaFX** UI's.
While much of the enterprise IT world is pushing HTML5 and cloud-based applications, many businesses are still using desktop UI frameworks like **JavaFX**. 
While it does not distribute to large audiences as easily as web applications, **JavaFX** works well for "in-house" business applications. 
Its _high-performance_ with large datasets (and the fact it is native Java) make it a practical choice for applications used behind the corporate firewall.
**JavaFX**, like many UI frameworks, can quickly become verbose and difficult to maintain. 
Fortunately, the rapidly growing **Kotlin** platform has allowed an opportunity to rethink how **JavaFX** applications are built.
Why **TornadoFX**?

In February 2016, JetBrains released **Kotlin**, a new **JVM** language that emphasizes pragmatism over convention. 

**Kotlin** works at a higher level of abstraction and provides practical language features not available in Java.
One of the more important features of Kotlin is its **100%** interoperability with existing Java libraries and codebases, including **JavaFX**. 
Even more important is in **2017**, Google backed Kotlin as an official language for **Android**. 
This gives Kotlin a bright future that has already extended beyond mobile apps.
While JavaFX can be used with Kotlin in the same manner as Java, some believed Kotlin had language features that could streamline and simplify JavaFX development. 
Well before Kotlin's beta, Eugen Kiss prototyped JavaFX "builders" with **KotlinFX**.
In January **2016**, Edvin Syse rebooted the initiative and released **TornadoFX**.

**TornadoFX** seeks to greatly minimize the amount of code needed to build JavaFX applications. 
It not only includes type-safe builders to quickly lay out controls and user interfaces, but also features dependency injection, delegated properties,
control extension functions, and other practical features enabled by **Kotlin**.

**TornadoFX** is a fine showcase of how Kotlin can simplify codebases, and it tackles the verbosity of UI code with elegance and simplicity.
It can work in conjunction with other popular JavaFX libraries such as ControlsFX and JFXtras. 
It works especially well with reactive frameworks such as **ReactFX** as well as **RxJava** and friends **(including RxJavaFX, RxKotlin, and RxKotlinFX)**.

###Reader Requirements

This book expects readers to have some knowledge of **Kotlin** and have spent some time getting acquainted with it.
There will be some coverage of Kotlin language features but only to a certain extent. 
If you have not done so already, read the JetBrains Kotlin Reference and spend a good few hours studying it.
It helps to be familiar with JavaFX but it is not a requirement.
Many Kotlin developers reported using **TornadoFX** successfully without any **JavaFX** knowledge.
What is particularly important to know about JavaFX is its concepts of `ObservableValue` and Bindings, which this guide will cover to a good degree.

###A Motivational Example

If you have worked with **JavaFX** before, you might have created a `TableView` at some point. 
Say you have a given domain type Person.
**TornadoFX** allows you to much more concisely create the JavaBeans-like convention used for the **JavaFX** binding.

```kotlin
class Person(id: Int, name: String, birthday: LocalDate) {
val idProperty = SimpleIntegerProperty(id)
var id by idProperty

val nameProperty = SimpleStringProperty(name)
var name by nameProperty

    val birthdayProperty = SimpleObjectProperty(birthday)
    var birthday by birthdayProperty

    val age: Int get() = Period.between(birthday, LocalDate.now()).years
}
```

You can then build an entire `"View"` containing a `TableView` with a small code footprint.
```kotlin
class MyView : View() {

    private val persons = listOf(
            Person(1, "Samantha Stuart", LocalDate.of(1981,12,4)),
            Person(2, "Tom Marks", LocalDate.of(2001,1,23)),
            Person(3, "Stuart Gills", LocalDate.of(1989,5,23)),
            Person(4, "Nicole Williams", LocalDate.of(1998,8,11))
    ).observable()

    override val root = tableview(persons) {
        column("ID", Person::idProperty)
        column("Name", Person::nameProperty)
        column("Birthday", Person::birthdayProperty)
        readonlyColumn("Age", Person::age)
    }
}
```

RENDERED OUTPUT:


Half of that code was just initializing sample data! If you hone in on just the part declaring the `TableView` with four `columns` (shown below), you will see it took a simple functional construct to build a `TableView`. 
It will automatically support edits to the fields as well.
```kotlin
tableview(persons) {
    column("ID", Person::idProperty)
    column("Name", Person::nameProperty)
    column("Birthday", Person::birthdayProperty)
    readonlyColumn("Age", Person::age)
}
```

As shown below, we can use the `cellFormat()` extension function on a `TableColumn`, and create conditional formatting for `"Age"` values that are less than `18`.

```kotlin
tableview<Person> {
    items = persons
    column("ID", Person::idProperty)
    column("Name", Person::nameProperty)
    column("Birthday", Person::birthdayProperty)
    readonlyColumn("Age", Person::age).cellFormat {
        text = it.toString()
        style {
            if (it < 18) {
                backgroundColor += c("#8b0000")
                textFill = Color.WHITE
            }
        }
    }
}
```

RENDERED OUTPUT:


These declarations are pure Kotlin code, and **TornadoFX** is packed with expressive power for dozens of cases like this.
This allows you to focus on creating solutions rather than engineering UI code. 
Your **JavaFX** applications will not only be turned around more quickly, but also be maintainable and evolvable.
