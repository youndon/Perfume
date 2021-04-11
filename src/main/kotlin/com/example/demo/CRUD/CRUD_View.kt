package com.example.demo.CRUD

import com.example.demo.CRUD.Glyphs.removeGlyph
import com.example.demo.CRUD.Glyphs.saveGlyph
import com.example.demo.CRUD.Glyphs.signOutGlyph
import com.example.demo.Login.SignIn_View
import com.example.demo.Login.myusername
import com.github.thomasnield.rxkotlinfx.itemSelections
import javafx.beans.property.Property
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.*
import javafx.scene.paint.Color
import kotlinx.datetime.toKotlinLocalDate
import tornadofx.*
import java.time.LocalDate
import kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix

class CRUD_View: UIComponent() {
    var userTable: TableView<CRUD_User> by singleAssign()
    var datePicker: DatePicker by singleAssign()
    val model = CRUD_Model(CRUD_User())
    val controller: CRUD_Control by inject()
    var firstnameField: TextField by singleAssign()
    var lastnameField: TextField by singleAssign()
    val categorylist = arrayListOf("I.T","Programmer","Data since","web Dev","mobile Dev","desktop Dev").observable()
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
                                items = FXCollections.observableArrayList((1..31).toList())
                            }
                            combobox(model.bindmonth){
                                items = FXCollections.observableArrayList((1..12).toList())
                            }
                            combobox(model.bindyear){
                                items = FXCollections.observableArrayList((1970..LocalDate.now().year).toList())
                            }
                        }
                    }
                    field("category") {
                        combobox(model.bindcategory) {
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
                            firstnameField.style { textFill = Color.BLACK }
                            CRUD_DataBase().update(
                                model.bindid.value,
                                model.bindfirstname.value,
                                model.bindlastname.value,
                                model.bindlocaldate.value,
                                model.bindcategory.value,
                                model.bindnote.value
                            )
                        }.ui {
                            model.commit()
                            model.bindlocaldate.value = "${model.bindday.value}/" +
                                    "${model.bindmonth.value}/${model.bindyear.value}"
                        }
                    }
                }
                button("reset").action {
                    model.rollback()
                }
                button("addUser") {
                    action {
                        runAsync {
                            controller.addUser(
                                model.bindfirstname.value,
                                model.bindlastname.value,
                                model.bindlocaldate.value,
                                model.bindcategory.value,
                                model.bindnote.value
                            )
                        }.ui {
                            model.bindlocaldate.value = "${model.bindday.value}/" +
                                    "${model.bindmonth.value}/${model.bindyear.value}"
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
                column("Day", CRUD_User::dayProperty).isVisible=false
                column("Month", CRUD_User::monthProperty).isVisible=false
                column("Year", CRUD_User::yearProperty).isVisible=false
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
