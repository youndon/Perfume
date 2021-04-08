package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.control.TableView
import javafx.scene.paint.Color
import tornadofx.App
import tornadofx.*

fun main() {
    launch<Dirty>()
}
class Dirty:App(DirtyView::class)

class DirtyView:View(){
    private var peopleTable : TableView<People> by singleAssign()
    private val model = PeopleModel(People())
    private val listpeople = FXCollections.observableArrayList(People("firstname","lastname"),People("firstname1","lastname1"))
    override val root = borderpane {
            left {
                tableview(listpeople) {
                    peopleTable = this
                    column("FIRST NAME", People::firstnameProperty)
                    column("LAST NAME", People::lastnameProperty)
                    smartResize()
                    model.rebindOnChange(this) {
                        item = it  ?: People()
                    }
                }
            }
        right{
            form{
                fieldset("Edit People.") {
                    field("First Name*") {
                        textfield(model.bindfirstname) {
                            model.dirty.addListener { a,b,dirty->
                                if (dirty) style { textFill= Color.RED } else style{textFill=Color.BLACK}
                            }
                        }
                    }
                    field("Last Name*") {
                        textfield(model.bindlastname) {  }
                    }
                }
            }
        }
    }
}
 class People(firstname:String?=null, lastname:String?=null){
      val firstnameProperty = SimpleStringProperty(firstname)
     var firstname: String by firstnameProperty
     val lastnameProperty = SimpleStringProperty(lastname)
     var lastname by lastnameProperty
 }
class PeopleModel(people:People):ItemViewModel<People>(people){
    val bindfirstname = bind(People::firstnameProperty)
    val bindlastname = bind(People::lastnameProperty)
}