import com.github.thomasnield.rxkotlinfx.actionEvents
import io.reactivex.subjects.BehaviorSubject
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.DatePicker
import javafx.scene.control.TableView
import tornadofx.*
import java.time.LocalDate

fun main() {
    launch<CRUD>()
}
class CRUD : App(CrudView::class)

class CrudView:UIComponent(){
     var userTable: TableView<User> by singleAssign()
    var datePicker : DatePicker by singleAssign()
     val users = arrayListOf<User>().observable()
    val model = UserModel(User())
    override val root = borderpane {
        right {
            form{
                fieldset("user edit") {
                    field("firstname*") {textfield(model.firstname).required()}
                    field("lastname*") {textfield(model.lastname).required()}
                    field("date*") {datepicker { datePicker = this }}
                    field("email*") {textfield(model.email).required()}
                }
                button("commit").action {
                    model.commit()
                }
                button("reset").action{
                    model.rollback()
                }
                button("save") {
                    enableWhen { model.dirty }
                    actionEvents().map { Unit }.subscribe(Control().saveAssignments)
                }
                button("delete").action {
                    users.remove(userTable.selectedItem)
                }
                button("registry").action {
                    users.add(User(model.firstname.value,model.lastname.value,datePicker.value,model.email.value))
                }
            }

        }
        left{
            tableview(users) {
                userTable = this
                column("First Name",User::firstnameProperty)
                column("Last Name",User::lastnameProperty)
                column("Date",User::dateProperty)
                column("Email",User::emailProperty)
                smartResize()
                model.rebindOnChange(this){
                    item = it ?: User()
                }
            }
        }
    }
}
class User(firstname:String?=null, lastname:String?=null, date: LocalDate?=null, email:String?=null){
    val firstnameProperty = SimpleStringProperty(this,"firstname",firstname)
    var firstname:String by firstnameProperty
    val lastnameProperty = SimpleStringProperty(this,"lastname",lastname)
    var lastame:String by lastnameProperty
    val dateProperty = SimpleObjectProperty(this,"date",date)
    var date by dateProperty
    val emailProperty = SimpleStringProperty(this,"email",email)
    var email:String by emailProperty
}
class UserModel(user:User?):ItemViewModel<User>(user){
    val firstname = bind(User::firstnameProperty)
    val lastname = bind(User::lastnameProperty)
    val date = bind(User::dateProperty)
    val email = bind(User::emailProperty)
}
class Control:Controller(){
    val saveAssignments = BehaviorSubject.create<Unit>()
}