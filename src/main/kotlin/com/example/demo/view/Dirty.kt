package com.example.demo.view

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.control.DatePicker
import javafx.scene.control.TableView
import javafx.scene.paint.Color
import tornadofx.App
import tornadofx.*
import java.time.LocalDate

fun main() {
    launch<Dirty>()
}
class Dirty:App(DirtyView::class)

class DirtyView:View() {
    private var peopleTable: TableView<People> by singleAssign()
    private val model = PeopleModel(People())
    private val listpeople =
        FXCollections.observableArrayList(
            People("firstname", "lastname", LocalDate.now()), People(
                "firstname1", "lastname1",
                LocalDate.now()
            )
        )
    private var datePicker: DatePicker by singleAssign()
    override val root = borderpane {
        left {
            tableview(listpeople) {
                peopleTable = this
                column("FIRST NAME", People::firstnameProperty)
                column("LAST NAME", People::lastnameProperty)
                column("DATE", People::date)
                smartResize()
                model.rebindOnChange(this) {
                    item = it ?: People()
                }
            }
        }
        right {
            form {
                fieldset("Edit People.") {
                    field("First Name*") {
                        textfield(model.bindfirstname) {
                            model.bindfirstname.onChange {
                                if (model.bindfirstname.isDirty) style { textFill = Color.RED } else style {
                                    textFill = Color.BLACK
                                }
                            }
                        }
                    }
                    field("Last Name*") {
                        textfield(model.bindlastname) { }
                    }
                    datepicker(model.binddate) {
                        datePicker = this
                    }
                }
            }
        }
    }
}
 class People(firstname:String?=null, lastname:String?=null,var date:LocalDate?=null){
      val firstnameProperty = SimpleStringProperty(firstname)
     var firstname: String by firstnameProperty
     val lastnameProperty = SimpleStringProperty(lastname)
     var lastname by lastnameProperty
 }
class PeopleModel(people:People):ItemViewModel<People>(people){
    val bindfirstname = bind(People::firstnameProperty)
    val bindlastname = bind(People::lastnameProperty)
    val binddate = bind(People::date)
}