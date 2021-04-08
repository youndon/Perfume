package com.example.demo.view

import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.geometry.Orientation
import javafx.scene.paint.Color
import org.nield.dirtyfx.beans.DirtyObjectProperty
import org.nield.dirtyfx.beans.DirtyStringProperty
import org.nield.dirtyfx.extensions.addTo
import org.nield.dirtyfx.tracking.CompositeDirtyProperty
import tornadofx.*
import java.time.LocalDate

fun main() {
    launch<MainLand>()
}
class MainLand:App(MyView::class)

class MainView : UIComponent() {
    override val root = vbox {

    }
}

class MyView: View() {

    val customers = FXCollections.observableArrayList(
        Person("Samantha","Stuart",LocalDate.of(1981,12,4)),
        Person("Tom","Marks",LocalDate.of(2001,1,23)),
        Person("Stuart","Gills",LocalDate.of(1989,5,23)),
        Person("Nicole","Williams",LocalDate.of(1998,8,11))
    )

    val selectedCustomer = SimpleObjectProperty<Person>()

    override val root = borderpane {

        left = toolbar {
            orientation = Orientation.VERTICAL

            button("RESET") {
                setOnAction {
                    selectedCustomer.get()?.reset()
                }
            }

            button("SAVE") {
                setOnAction {
                    selectedCustomer.get()?.save()
                }
            }
        }

        center = tableview(customers) {
            selectedCustomer.bind(selectionModel.selectedItemProperty())
            column("FIRST NAME", Person::firstNameProperty) {
                makeEditable()
                cellDecorator {
                    rowItem.firstNameProperty.isDirtyProperty().addListener { o, oldValue, newValue ->
                        textFill = if (newValue) Color.RED else Color.BLACK
                    }
                }
            }

            column("LAST NAME", Person::lastNameProperty) {
                makeEditable()
                cellDecorator {
                    rowItem.lastNameProperty.isDirtyProperty().addListener { o, oldValue, newValue ->
                        textFill = if (newValue) Color.RED else Color.BLACK
                    }
                }
            }

            column("BIRTHDAY", Person::birthdayProperty) {
                makeEditable()
                cellDecorator {
                    rowItem.birthdayProperty.isDirtyProperty().addListener { o, oldValue, newValue ->
                        textFill = if (newValue) Color.RED else Color.BLACK
                    }
                }
            }

            column("IS DIRTY", Person::isDirtyProperty)

            isEditable = true
        }
    }
}

class Person(firstName: String, lastName: String, birthday: LocalDate) {

    val isDirtyProperty = CompositeDirtyProperty()
    val isDirty by isDirtyProperty

    val firstNameProperty = DirtyStringProperty(firstName).addTo(isDirtyProperty)
    var firstName by firstNameProperty

    val lastNameProperty = DirtyStringProperty(lastName).addTo(isDirtyProperty)
    var lastName by lastNameProperty

    val birthdayProperty = DirtyObjectProperty(birthday).addTo(isDirtyProperty)
    var birthday by birthdayProperty


    fun reset() = isDirtyProperty.reset()
    fun save() = isDirtyProperty.rebaseline()
}