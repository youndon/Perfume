package com.example.demo.CRUD

import com.example.demo.CRUD.Glyphs.removeGlyph
import com.example.demo.CRUD.Glyphs.saveGlyph
import com.example.demo.CRUD.Glyphs.signOutGlyph
import com.example.demo.Login.SignIn_View
import com.example.demo.Login.myusername
import javafx.scene.control.DatePicker
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import kotlinx.datetime.toKotlinLocalDate
import tornadofx.*

class CRUD_View: UIComponent() {
    var userTable: TableView<CRUD_User> by singleAssign()
    var datePicker: DatePicker by singleAssign()
    val model = CRUD_Model(CRUD_User())
    val controller: CRUD_Control by inject()
    private var firstnameField: TextField by singleAssign()
    private var lastnameField: TextField by singleAssign()
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
                    field("date"){
                        datePicker = datepicker(model.binddate.getValue().value?.toLocalDate().toProperty()){
                            model.binddate.onChange {
                                if (model.binddate.isDirty) style { textFill = Color.RED } else style {
                                    textFill = Color.BLACK
                                }
                            }
                        }
                    }
                    field("category") {
                        textfield(model.bindcategory) {
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
                            CRUD_DataBase().update(
                                model.bindid.value,
                                model.bindfirstname.value,
                                model.bindlastname.value,
                                model.binddate.getValue().get(),
                                model.bindcategory.value,
                                model.bindnote.value
                            )
                        }.ui {
                            firstnameField.style { textFill = Color.BLACK }
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
                                model.binddate.getValue().get(),
                                model.bindcategory.value,
                                model.bindnote.value
                            )
                        }.ui {
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
                column("Date", CRUD_User::dateProperty)
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
