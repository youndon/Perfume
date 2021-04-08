import Icons.Companion.removeGlyph
import Icons.Companion.saveGlyph
import com.github.thomasnield.rxkotlinfx.onChangedObservable
import com.github.thomasnield.rxkotlinfx.rowIndexSelections
import com.github.thomasnield.rxkotlinfx.updates
import org.nield.dirtyfx.beans.DirtyObjectProperty
import org.nield.dirtyfx.beans.DirtyStringProperty
import org.nield.dirtyfx.extensions.addTo
import org.nield.dirtyfx.tracking.CompositeDirtyProperty
import javafx.beans.property.*
import javafx.event.Event
import javafx.event.EventType
import javafx.scene.control.DatePicker
import javafx.scene.control.TableView
import javafx.scene.paint.Color
import org.controlsfx.glyphfont.FontAwesome
import org.controlsfx.glyphfont.Glyph
import org.controlsfx.glyphfont.GlyphFont
import org.controlsfx.glyphfont.GlyphFontRegistry
import tornadofx.*
import java.sql.Connection
import java.sql.DriverManager
import java.time.LocalDate
import javax.swing.event.ChangeEvent


fun main() {
    launch<CRUD>()
}
class CRUD : App(CrudView::class)
var users = (DataBase().readUsers().observable())
class CrudView:UIComponent() {
    var userTable: TableView<User> by singleAssign()
    var datePicker: DatePicker by singleAssign()
    val model = UserModel(User())
    val controller: Control by inject()
    override val root = borderpane {
        right {
            form {
                fieldset("user edit") {
                    field("firstname*") { textfield(model.bindfirstname) }
                    field("lastname*") { textfield(model.bindlastname) }
                    field("date*") { datepicker { datePicker = this } }
                    field("email*") { textfield(model.bindemail) }
                }
                button("update",saveGlyph) {
                    enableWhen { model.dirty }
                    action {
                        model.commit()
                        DataBase().update(model.bindid.value, model.bindfirstname.value, model.bindlastname.value)
                    }
                }
                button("reset").action {
                    model.rollback()
                }
                button("addUser") {
                    action {
                        runAsync {
                            controller.addUser(model.bindfirstname.value, model.bindlastname.value)
                        }
                    }
                }
                button("delete",removeGlyph).action {
                    users.remove(userTable.selectedItem)
                    DataBase().delete(model.bindid.value)
                }
            }
        }
        left {
            tableview(users) {
                userTable = this
                column("Id",User::id)
                column("First Name", User::firstnameProperty)
                column("Last Name", User::lastnameProperty)
                column("Date", User::date)
                column("Email", User::email)
                smartResize()
                model.rebindOnChange(this) {
                    item = it // ?: User()
                }
            }
        }
    }
}
  class User(var id:Int?=null, firstname:String?=null, lastname:String?=null,var date: LocalDate?=null,var email:String?=null){
      val firstnameProperty = SimpleStringProperty(firstname)
      var firstname by firstnameProperty
      val lastnameProperty = SimpleStringProperty(lastname)
      var lastname by lastnameProperty


 }

class UserModel(user:User?):ItemViewModel<User>(user){
    val bindid = bind(User::id)
    val bindfirstname = bind(User::firstnameProperty)
    val bindlastname = bind(User::lastnameProperty)
    val binddate = bind(User::date)
    val bindemail = bind(User::email)
}
class Control:Controller() {
    fun addUser(firstname: String?, lastname: String?) {
        val user = User(firstname = firstname,lastname = lastname)
        val doa = DataBase()
        doa.insert(user)
        users.add(user)
    }
}

private class DataBase{
    val connection: Connection
    init {
        Class.forName("org.sqlite.JDBC")
        connection = DriverManager.getConnection("jdbc:sqlite:Perfume.db")
    }
    fun insert(user: User) {
        val ps = connection.prepareStatement("INSERT INTO UserTable(firstname,lastname) VALUES (?, ?)")
        ps.setString(1,user.firstname)
        ps.setString(2,user.lastname)
        ps.executeUpdate()
        ps.close()
        connection.close()
    }
    fun readUsers(): ArrayList<User> {
        val resultSet = connection.createStatement().executeQuery("SELECT * FROM UserTable")
        val userList = ArrayList<User>()
        while (resultSet.next()){
            val firstname = resultSet.getString("firstname")
            val lastname = resultSet.getString("lastname")
            val id = resultSet.getInt("id")
            userList.plusAssign(User(id = id ,firstname = firstname,lastname = lastname))
        }
        resultSet.close()
        connection.close()
        return userList
    }

     fun update(index:Int,modifyfirstname:String,modifylastname:String) {
         val ps = connection.prepareStatement("UPDATE UserTable SET firstName = ? , lastname = ? WHERE id = $index ")
         ps.setString(1, modifyfirstname)
         ps.setString(2, modifylastname)
         ps.executeUpdate()
         ps.close()
         connection.close()
     }
    fun delete(index: Int) {
        val ps = connection.prepareStatement("DELETE FROM UserTable WHERE id = $index")
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