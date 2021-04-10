package com.example.demo.CRUD

import tornadofx.ItemViewModel
import tornadofx.date

class CRUD_Model(user:CRUD_User?): ItemViewModel<CRUD_User>(user){
    val bindid = bind(CRUD_User::id)
    val bindfirstname = bind(CRUD_User::firstnameProperty)
    val bindlastname = bind(CRUD_User::lastnameProperty)
    val bindcategory = bind(CRUD_User::categoryProperty)
    val bindnote = bind(CRUD_User::noteProperty)
    var bindlocaldate = bind(CRUD_User::localdateProperty)
}
