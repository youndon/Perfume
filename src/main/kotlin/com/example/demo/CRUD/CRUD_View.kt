package com.example.demo.CRUD

import com.example.demo.CRUD.Glyphs.removeGlyph
import com.example.demo.CRUD.Glyphs.saveGlyph
import com.example.demo.CRUD.Glyphs.signOutGlyph
import com.example.demo.Login.SignIn_View
import com.example.demo.Login.myusername
import com.github.thomasnield.rxkotlinfx.itemSelections
import javafx.beans.property.Property
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.*
import javafx.scene.paint.Color
import kotlinx.datetime.toKotlinLocalDate
import tornadofx.*
import java.time.LocalDate

class CRUD_View: UIComponent() {
    var userTable: TableView<CRUD_User> by singleAssign()
    var datePicker: DatePicker by singleAssign()
    val model = CRUD_Model(CRUD_User())
    val controller: CRUD_Control by inject()
    var firstnameField: TextField by singleAssign()
    var lastnameField: TextField by singleAssign()
    val categorylist = arrayListOf("I.T","Programmer","Data since","web Dev","mobile Dev","desktop Dev").observable()
    var categorylistview:ComboBox<String> by singleAssign()
    var dayslistview:ComboBox<Int> by singleAssign()
    var monthslistview:ComboBox<Int> by singleAssign()
    var yearslistview:ComboBox<Int> by singleAssign()
    val dayslist = (1..31).toList().observable()
    val monthslist = (1..12).toList().observable()
    val yearslist = (1970..LocalDate.now().year).toList().observable()
    override val root = borderpane {
        right {
            form {
                fieldset(myusername) {
                    field("firstname*") {
                        textfield(model.bindfirstname) {
                            firstnameField = this
                            model.bindfirstname.onChange {
                                if (model.bindfirstname.isDirty) style { textFill = Color.RED } else style {
                                    textFill = Color.BLACK
                                }
                            }
                        }
                    }
                    field("lastname*") {
                        textfield(model.bindlastname) {
                            lastnameField = this
                            model.bindlastname.onChange {
                                if (model.bindlastname.isDirty) style { textFill = Color.RED } else style {
                                    textFill = Color.BLACK
                                }
                            }
                        }
                    }
                    field("date") {
                        hbox {
                            combobox(model.bindday){
                                items = dayslist
                            }
                            label("/")
                            combobox<Int>{
                                items = monthslist}
                            label("/")
                            combobox<Int>{
                                items = yearslist}
                            model.bindlocaldate.onChange {
                                if (model.bindlocaldate.isDirty) style { textFill = Color.RED } else style {
                                    textFill = Color.BLACK
                                }
                            }
                        }
                    }
                    field("category") {
                        categorylistview =combobox(model.bindcategory) {
                            items = categorylist
                            model.bindcategory.onChange {
                                if (model.bindcategory.isDirty) style { textFill = Color.RED } else style {
                                    textFill = Color.BLACK
                                }
                            }
                        }
                    }
                    field("note") {
                        textarea(model.bindnote) {
                            model.bindfirstname.onChange {
                                if (model.bindnote.isDirty) style { textFill = Color.RED } else style {
                                    textFill = Color.BLACK
                                }
                            }
                        }
                    }
                }
                button("update", saveGlyph) {
                    enableWhen { model.dirty }
                    action {
                        runAsync {
                            model.commit()
                            firstnameField.style { textFill = Color.BLACK }
                        }.ui {
                            CRUD_DataBase().update(
                                model.bindid.value,
                                model.bindfirstname.value,
                                model.bindlastname.value,
                                model.bindlocaldate.value,
                                model.bindcategory.value,
                                model.bindnote.value
                            )
                        }
                    }
                }
                button("reset").action {
                    model.rollback()
                }
                button("addUser") {
                    action {
                        runAsync {
                            model.bindcategory.value = "${categorylistview.selectedItem}"
                        }.ui {
                            controller.addUser(
                                model.bindfirstname.value,
                                model.bindlastname.value,
                                model.bindlocaldate.value,
                                model.bindcategory.value,
                                model.bindnote.value
                            )
                        }
                    }
                }
                button("delete", removeGlyph).action {
                    users.remove(userTable.selectedItem)
                    CRUD_DataBase().delete(model.bindid.value)
                }
                button("SignOut",signOutGlyph).action {
                    replaceWith(SignIn_View::class)
                }
            }
        }
        left {
            tableview(users) {
                userTable = this
                column("Id", CRUD_User::id)
                column("First Name", CRUD_User::firstnameProperty)
                column("Last Name", CRUD_User::lastnameProperty)
                column("Date", CRUD_User::localdateProperty)
                column("Category", CRUD_User::categoryProperty)
                column("Note", CRUD_User::noteProperty)
                smartResize()
                model.rebindOnChange(this) {
                    item = it ?: CRUD_User()
                }
            }
        }
    }

    companion object {
        var users = SortedFilteredList(CRUD_DataBase().readUsers().observable())
    }
}
