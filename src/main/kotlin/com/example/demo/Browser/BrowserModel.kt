package com.example.demo.Browser

import javafx.beans.property.SimpleStringProperty
import tornadofx.ViewModel

class BrowserModel(address:String): ViewModel(){
    var url = bind { SimpleStringProperty(address) }
}