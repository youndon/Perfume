import Icons.Companion.removeGlyph
import Icons.Companion.saveGlyph
import com.example.demo.view.Database
import com.example.demo.view.Login
import com.example.demo.view.myusername
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.DatePicker
import javafx.scene.control.TableView
import kotlinx.datetime.toKotlinLocalDate
import org.controlsfx.glyphfont.FontAwesome
import org.controlsfx.glyphfont.Glyph
import org.controlsfx.glyphfont.GlyphFont
import org.controlsfx.glyphfont.GlyphFontRegistry
import tornadofx.*
import java.sql.Connection
import java.sql.Date
import java.sql.DriverManager
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    launch<CRUD>()
}
class CRUD : App(CrudView::class)
var users = SortedFilteredList(UserDataBase().readUsers().observable())
class CrudView:UIComponent() {
    var userTable: TableView<User> by singleAssign()
    var datePicker: DatePicker by singleAssign()
    val model = UserModel(User())
    val controller: Control by inject()
    override val root = borderpane {
        right {
            form {
                fieldset(myusername) {
                    field("firstname*") { textfield(model.bindfirstname) }
                    field("lastname*") { textfield(model.bindlastname) }
                    field("date*") { datepicker { datePicker = this } }
                    field("category"){textfield(model.bindcategory) }
                    field("note"){textarea (model.bindnote) }
                }
                button("update",saveGlyph) {
                    enableWhen { model.dirty }
                    action {
                        model.commit()
                        UserDataBase().update(
                            model.bindid.value,
                            model.bindfirstname.value,
                            model.bindlastname.value,
                            model.binddate.value,
                            model.bindcategory.value,
                            model.bindnote.value
                        )
                    }
                }
                button("reset").action {
                    model.rollback()
                }
                button("addUser") {
                    action {
                        runAsync {
                            controller.addUser(model.bindfirstname.value,
                                model.bindlastname.value,
                                model.binddate.value,
                                model.bindcategory.value,
                                model.bindnote.value)
                        }
                    }
                }
                button("delete",removeGlyph).action {
                    users.remove(userTable.selectedItem)
                    UserDataBase().delete(model.bindid.value)
                }
                button("logOut").action{
                    replaceWith(Login::class)
                }
            }

        }
        left {
            tableview(users) {
                userTable = this
                column("Id",User::id)
                column("First Name", User::firstnameProperty)
                column("Last Name", User::lastnameProperty)
                column("Date", User::dateProperty)
                column("Category", User::categoryProperty)
                column("Note", User::noteProperty)
                smartResize()
                model.rebindOnChange(this) {
                    item = it ?: User()
                }
            }
        }
    }
}
  class User(var id:Int?=null, firstname:String?=null, lastname:String?=null,date:String?=null,category:String?=null,note:String?=null){
      val firstnameProperty = SimpleStringProperty(firstname)
      var firstname: String by firstnameProperty
      val lastnameProperty = SimpleStringProperty(lastname)
      var lastname: String by lastnameProperty
      val dateProperty = SimpleStringProperty(date)
      var date: String by dateProperty
      val categoryProperty = SimpleStringProperty(category)
      var category: String by categoryProperty
      val noteProperty = SimpleStringProperty(note)
      var note: String by noteProperty


 }

class UserModel(user:User?):ItemViewModel<User>(user){
    val bindid = bind(User::id)
    val bindfirstname = bind(User::firstnameProperty)
    val bindlastname = bind(User::lastnameProperty)
    val binddate = bind(User::dateProperty)
    val bindcategory = bind(User::categoryProperty)
    val bindnote = bind(User::noteProperty)
}
class Control:Controller() {
    fun addUser(firstname: String?, lastname: String?,date:String?,category:String?,note:String?) {
        val user = User(firstname = firstname,lastname = lastname,date= date,category = category,note = note)
        val doa = UserDataBase()
        doa.insert(user)
        users.add(user)
    }
}

private class UserDataBase{
    val connection: Connection
    init {
        Class.forName("org.sqlite.JDBC")
        connection = DriverManager.getConnection("jdbc:sqlite:Perfume.db")
    }
    fun insert(user: User) {
        val ps = connection.prepareStatement("INSERT INTO $myusername(firstname,lastname,date,category,note) VALUES (?, ?, ?, ?, ?)")
        ps.setString(1,user.firstname)
        ps.setString(2,user.lastname)
        ps.setString(3,user.date)
        ps.setString(4,user.category)
        ps.setString(5,user.note)
        ps.executeUpdate()
        ps.close()
        connection.close()
    }
    fun readUsers(): ArrayList<User> {
        val resultSet = connection.createStatement().executeQuery("SELECT * FROM $myusername")
        val userList = ArrayList<User>()
        while (resultSet.next()){
            val id = resultSet.getInt("id")
            val firstname = resultSet.getString("firstname")
            val lastname = resultSet.getString("lastname")
            val date = resultSet.getString("date")
            val category = resultSet.getString("category")
            val note = resultSet.getString("note")
            userList.plusAssign(User(id ,firstname,lastname,date,category,note))
        }
        resultSet.close()
        connection.close()
        return userList
    }

     fun update(index:Int, modifyfirstname:String?=null,
                modifylastname:String?=null,
                modifydate: String?=null,
                modifycategory:String?=null,
                modifynote:String?=null) {
         val ps = connection.prepareStatement("UPDATE $myusername SET firstname = ? , lastname = ? ,date  = ? , category = ? , note = ? WHERE id = $index ")
         ps.setString(1, modifyfirstname)
         ps.setString(2, modifylastname)
         ps.setString(3, modifydate)
         ps.setString(4, modifycategory)
         ps.setString(5, modifynote)
         ps.executeUpdate()
         ps.close()
         connection.close()
     }
    fun delete(index: Int) {
        val ps = connection.prepareStatement("DELETE FROM $myusername WHERE id = $index")
        ps.executeUpdate()
        ps.close()
        connection.close()
    }
}

class Icons{
    companion object{
         private val fontAwesome: GlyphFont = GlyphFontRegistry.font("FontAwesome")
         val saveGlyph: Glyph = fontAwesome.create(FontAwesome.Glyph.SAVE)
         val removeGlyph: Glyph = fontAwesome.create(FontAwesome.Glyph.REMOVE)
    }
}