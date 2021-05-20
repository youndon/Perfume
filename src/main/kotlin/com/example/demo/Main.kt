import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table
import javafx.beans.property.*
import javafx.beans.value.ObservableValue
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.TreeItemPropertyValueFactory
import javafx.util.Callback
import tornadofx.*
import java.io.File


fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView:View() {
    override val root = borderpane {

    }
}