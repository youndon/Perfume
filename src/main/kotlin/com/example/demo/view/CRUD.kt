package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import tornadofx.*

fun main()= launch<CRUD>()
class CRUD: App(CRUDView::class)

class CRUDView:UIComponent("CRUD") {
    private var textField: TextField by singleAssign()
    private var userTable: TableView<CRUDControl.User> by singleAssign()
    private val list = arrayListOf<CRUDControl.User>().observable()
    override val root = borderpane {
        setPrefSize(500.0, 500.0)
        right {
            tableview(list) {
                userTable = this
                column("Name", CRUDControl.User::name)
            }
        }
        left {
            form {
                fieldset("EditUser") {
                    field {
                        textflow {text("Name");text("*"){ fill= Color.RED} }
                        textfield {
                            textField = this
                        }
                    }
                }
                buttonbar {
                    button("add") {
                        action {
                            addUser()
                        }
                    }.enableWhen {
                        textField.textProperty().isNotBlank()
                    }
                    button("reset") {
                        action {
                            reset()
                        }
                    }.enableWhen {
                        textField.textProperty().isNotBlank()
                    }
                    button("delete") {
                        action {
                            delete()
                        }
                    }
                    button("save") {

                    }
                    button("edit") {

                    }
                }
            }
        }

    }

    private fun addUser() {
        list.add(CRUDControl.User(textField.text))
        reset()
    }

    private fun delete() {
        list.remove(userTable.selectedItem)
    }

    private fun reset() {
        textField.clear()
    }
}

    sealed class CRUDControl {
        class User(name: String? = null) {
            private val nameProperty = SimpleStringProperty(this, "name", name)
            var name: String by nameProperty
        }
    }
