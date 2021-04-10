package com.example.demo.view

import com.example.demo.CRUD.CRUD_DataBase
import com.example.demo.CRUD.CRUD_Model
import com.example.demo.CRUD.CRUD_User
import com.sun.glass.ui.Application
import javafx.application.Platform
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.control.DatePicker
import javafx.scene.control.TableView
import javafx.scene.paint.Color
import tornadofx.App
import tornadofx.*
import java.sql.DriverManager
import java.time.LocalDate
val model = CRUD_Model(CRUD_User())

fun main() {
//    launch<Dirty>()

        println(
            LocalDate.now().year
        )
}
class Dirty:App(DirtyView::class)

class DirtyView:View() {
    private var peopleTable: TableView<CRUD_User> by singleAssign()
    private val model = PeopleModel(CRUD_User())
    private val listpeople = SortedFilteredList(CRUD_DataBase().readUsers().observable())
    private var datePicker: DatePicker by singleAssign()
    override val root = borderpane {
        left {
            tableview(listpeople) {
                peopleTable = this
                column("FIRST NAME", CRUD_User::firstnameProperty)
                column("LAST NAME", CRUD_User::lastnameProperty)
                column("DATE", CRUD_User::localdate)
                smartResize()
                model.rebindOnChange(this) {
                    item = it
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
                    datepicker() {
                        datePicker = this
                    }
                }
            }
        }
    }
}
 class People(firstname:String?=null, lastname:String?=null,var date:LocalDate?=null) {
     val firstnameProperty = SimpleStringProperty(firstname)
     var firstname: String by firstnameProperty
     val lastnameProperty = SimpleStringProperty(lastname)
     var lastname by lastnameProperty
 }
class PeopleModel(people:CRUD_User):ItemViewModel<CRUD_User>(people){
    val bindfirstname = bind(CRUD_User::firstnameProperty)
    val bindlastname = bind(CRUD_User::lastnameProperty)
    val binddate = bind(CRUD_User::localdateProperty)
}

