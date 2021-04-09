package com.example.demo.CRUD

import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue
import java.sql.Date

class CRUD_User(var id:Int?=null, firstname:String?=null, lastname:String?=null, category:String?=null, note:String?=null){
    val firstnameProperty = SimpleStringProperty(firstname)
    var firstname: String by firstnameProperty
    val lastnameProperty = SimpleStringProperty(lastname)
    var lastname: String by lastnameProperty
    val categoryProperty = SimpleStringProperty(category)
    var category: String by categoryProperty
    val noteProperty = SimpleStringProperty(note)
    var note: String by noteProperty
}
