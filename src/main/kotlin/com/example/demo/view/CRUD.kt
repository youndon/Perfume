import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.TableView
import tornadofx.*

fun main() {
    launch<CRUD>()
}
class CRUD : App(CrudView::class)

class CrudView:UIComponent(){
     var userTable: TableView<User> by singleAssign()
     val list = arrayListOf<User>().observable()
    val model = UserModel(User())
    override val root = borderpane {
        right {
            form{
                fieldset("user edit") {
                    field("name*") {
                        textfield(model.name)
                    }
                }
                button("commit").action {
                    model.commit()
                }
                button("reset").action{
                    model.rollback()
                }
                button("save").action {
                }
            }

        }
        left{
            tableview(list) {
                userTable = this
                column("name",User::nameProperty)
                model.rebindOnChange(this){
                    item = it ?: User()
                }
            }
        }
    }
}
class User(name:String?=null){
    val nameProperty = SimpleStringProperty(this,"name",name)
    var name:String by nameProperty
}
class UserModel(user:User?):ItemViewModel<User>(user){
    val name = bind(User::nameProperty)
}
