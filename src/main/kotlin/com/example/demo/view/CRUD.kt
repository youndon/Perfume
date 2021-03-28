package com.example.demo.view

import AppeanaFx.t.TableViewEditModel
import javafx.scene.control.DatePicker
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import kotlinx.datetime.LocalDate
import tornadofx.*
import javax.swing.table.TableModel

fun main()= launch<CRUD>()
class CRUD: App(CRUDView::class)

class CRUDView:UIComponent("CRUD") {
    private var nameField: TextField by singleAssign()
    private var userTable: TableView<User> by singleAssign()
    private val list = arrayListOf<User>().observable()
    private val model = UserModel(User())
    override val root = borderpane {
        setPrefSize(500.0, 500.0)
        right {
            form{
                tableview(list) {
                    userTable = this
                    readonlyColumn("Name", User::name)
                }
            }
        }
        left {
            form {
                fieldset("EditUser") {
                    field {
                        textflow { text("Name");text("*") { fill = Color.RED } }
                        textfield {
                            nameField = this
                        }
                    }
//                    field{
//                        textflow {text("Date");text("*"){ fill= Color.RED} }
//                        datepicker{
//                            datePicker=this
//                        }
//                    }
//                    field {
//                        textflow {text("Email");text("*"){ fill= Color.RED} }
//                        textfield {
//                            emailField=this
//                        }
//                    }
//                }
                }


                buttonbar {
                    button("add") {
                        action {
                            addUser()
                        }
                    }.enableWhen {
                        nameField.textProperty().isNotBlank()
                    }
                    button("reset") {
                        action {
                            reset()
                        }
                    }.enableWhen {
                        nameField.textProperty().isNotBlank()
                    }
                    button("delete") {
                        action {
                            delete()
                        }
                    }
                    button("save") {
                        action {
                        }
                    }
                    button("edit") {

                    }
                }
            }
        }

    }

    private fun addUser() {
        list.add(User(nameField.text))
        reset()
    }

    private fun delete() {
        list.remove(userTable.selectedItem)
    }

    private fun reset() {
        nameField.clear()
    }
    private fun save() {
    }
}

 data class User(val name: String? = null)

 class UserModel(user: User):ItemViewModel<User>(user) {
            val name = bind(User::name)
        }
