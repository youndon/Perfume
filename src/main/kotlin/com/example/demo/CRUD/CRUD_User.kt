package com.example.demo.CRUD

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

class CRUD_User(var id:Int?=null, firstname:String?=null,
                lastname:String?=null, localdate:String?=null,
                category:String?=null, note:String?=null,
                day:Int=10,month:Int=10,year:Int=2010)
{
    val firstnameProperty = SimpleStringProperty(firstname)
    var firstname: String by firstnameProperty
    val lastnameProperty = SimpleStringProperty(lastname)
    var lastname: String by lastnameProperty
    val categoryProperty = SimpleStringProperty(category)
    var category: String by categoryProperty
    val noteProperty = SimpleStringProperty(note)
    var note: String by noteProperty
    val localdateProperty = SimpleStringProperty(localdate)
    var localdate:String by localdateProperty
    val dayProperty = SimpleIntegerProperty(day)
    var day by dayProperty
    val monthProperty = SimpleIntegerProperty(month)
    var month by monthProperty
    val yearProperty = SimpleIntegerProperty(year)
    var year by yearProperty

}
