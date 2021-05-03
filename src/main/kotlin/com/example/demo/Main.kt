
import com.github.thomasnield.rxkotlinfx.actionEvents
import com.github.thomasnield.rxkotlinfx.itemSelections
import com.github.thomasnield.rxkotlinfx.valueSelections
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.event.EventTarget
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonBar.BUTTON_ORDER_LINUX
import javafx.scene.control.ButtonBar.BUTTON_ORDER_MAC_OS
import javafx.scene.control.Menu
import javafx.scene.control.Toggle
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import javafx.scene.shape.Box
import javafx.scene.text.Font
import javafx.scene.text.FontSmoothingType
import javafx.scene.text.TextAlignment
import javafx.scene.text.TextBoundsType
import kotlinx.datetime.DateTimeUnit
import tornadofx.*

fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {

    override val root = vbox {
        menubar {
            str.forEach {
                menu() {
//                   when(it){
//                       "View" -> this.isDisable=true
//                       "File" -> file.forEach { item -> item(item) }
//                       "Edit" -> edit.forEach { item -> item(item) }
//                       "Build" -> build.forEach { item -> item(item) }
//                       "Help" -> help.forEach { item -> item(item) }
//                   }
                }
            }
        }
    }
    val str = listOf("File", "Edit", "View", "Build", "Help")
    val file = listOf("New","Open","Setting","Save All","Exit")
    val edit = listOf("Cut","Copy","Paste","Delete","Find")
    val build = listOf("Build P","Build M","Recompile","Rebuild")
    val help = listOf("Help","Check Update","About")
}

