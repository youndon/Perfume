import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.DatePicker
import javafx.scene.control.TableView
import tornadofx.*
import java.sql.Connection
import java.sql.DriverManager
import java.time.LocalDate

fun main() {
    launch<CRUD>()
}
class CRUD : App(CrudView::class)
val users = SortedFilteredList(UserConnection().readUsers().observable())
class CrudView:UIComponent() {
    var userTable: TableView<User> by singleAssign()
    var datePicker: DatePicker by singleAssign()
    val model = UserModel(User())
    val controller:Control by inject()
    override val root = borderpane {
        right {
            form {
                fieldset("user edit") {
                    field("firstname*") { textfield(model.firstname).required() }
                    field("lastname*") { textfield(model.lastname) }
                    field("date*") { datepicker { datePicker = this } }
                    field("email*") { textfield(model.email) }
                }
                button("commit").action {
                    model.commit()
                }
                button("reset").action {
                    model.rollback()
                }
                button("save") {
                    enableWhen { model.dirty }
                    action{
                        runAsync {
                            controller.add(model.firstname.value,model.lastname.value)
                            userTable.refresh()
                        }
                    }
                }
                button("delete").action {
                    users.remove(userTable.selectedItem)
                }
            }

        }
        left {
            tableview(users) {
                userTable = this
                column("First Name",User::firstnameProperty)
                column("Last Name",User::lastnameProperty)
                column("Date",User::dateProperty)
                column("Email",User::emailProperty)
                smartResize()
                model.rebindOnChange(this) {
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
class Control:Controller() {
    fun add(firstname: String?, lastname: String?) {
        val user = User(firstname, lastname)
        val doa = UserConnection()
        doa.adduser(user)
        users.add(user)
    }

    fun putcommit(olduser:User,newfirstname:String,newlastname:String){
        val newuser = User(newfirstname,newlastname)
        UserConnection().commitUser(olduser.firstname,newuser)
        with(users){
            remove(olduser)
            add(newuser)
        }
    }
}
class UserConnection{
    fun adduser(user: User) {
        val connection =  DataBase().connection
        val ps = connection.prepareStatement("INSERT INTO UserTable(firstname,lastname) VALUES (?, ?)")
        ps.setString(1,user.firstname)
        ps.setString(2,user.lastame)
        ps.executeUpdate()
        ps.close()
        connection.close()
    }
    fun readUsers(): ArrayList<User> {
        val connection = DataBase().connection
        val resultSet = connection.createStatement().executeQuery("SELECT * FROM UserTable")
        val userList = ArrayList<User>()
        while (resultSet.next()){
            val firstname = resultSet.getString("firstname")
            val lastname = resultSet.getString("lastname")
            userList.plusAssign(User(firstname,lastname))
        }
        resultSet.close()
        connection.close()
        return userList
    }
    fun commitUser(firstname: String,user: User): User {
        val connection = DataBase().connection
        var param = ""
        val lastparam = ", lastname = ?"
        var optionalPramIndex = 2
        if (user.lastame.isNotEmpty()) param = lastparam
        val ps = connection.prepareStatement("UPDATE UserTable SET firstname = ? $param WHERE lastname = ?")
        ps.setString(1, user.firstname)
        if (param.isNotEmpty()){
            ps.setString(optionalPramIndex,user.lastame)
            optionalPramIndex = optionalPramIndex.inc()
        }
        ps.setString(optionalPramIndex,firstname)
        ps.executeUpdate()
        ps.close()
        connection.close()
        return user
    }

}

class DataBase{
    val connection: Connection
    init {
        Class.forName("org.sqlite.JDBC")
        connection = DriverManager.getConnection("jdbc:sqlite:Perfume.db")
    }

}