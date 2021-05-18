import com.example.demo.CRUD.CRUD_User
import javafx.beans.property.*
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.TreeItemPropertyValueFactory
import tornadofx.*
import java.io.File


fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView:View() {
    val model = UserModel(User())
    val list = listOf(
        User(1, "Coby Brain"),
        User(2, "Maikel Jordan")
    ).observable()
    override val root = borderpane {
        right = tableview(list) {
        multiSelect(true)
            readonlyColumn("ID",User::id)
            column("FullName",User::fullName)
            model.rebindOnChange(this) {
                item = it ?: User()
            }
        }
        left = form{
            fieldset("admin") {
                field("ID") {
                    textfield(model.bindid) {  }
                }
                field("FullName") {
                    textfield(model.bindfullname) {  }
                }
            }
        }
    }
}

class User(id:Int=0,fullName:String?=null){
     val simpleIdProperty = SimpleIntegerProperty(id)
    var id by simpleIdProperty
     val simpleFullNameProperty = SimpleStringProperty(fullName)
    var fullName: String by simpleFullNameProperty
}

class UserModel(user:User?):ItemViewModel<User>(user){
    val bindid = bind(User::simpleIdProperty)
    val bindfullname = bind(User::simpleFullNameProperty)
}





class Files {
    private var name: StringProperty? = null
    fun setName(value: String?) {
        nameProperty().set(value)
    }

    fun getName(): String {
        return nameProperty().get()
    }

    fun nameProperty(): StringProperty {
        if (name == null) name = SimpleStringProperty(this, "name")
        return name as StringProperty
    }

    private var lastModified: LongProperty? = null
    fun setLastModified(value: Long) {
        lastModifiedProperty().set(value)
    }

    fun getLastModified(): Long {
        return lastModifiedProperty().get()
    }

    private fun lastModifiedProperty(): LongProperty {
        if (lastModified == null) lastModified = SimpleLongProperty(this, "lastModified")
        return lastModified as LongProperty
    }
}