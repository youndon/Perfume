
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
import javafx.scene.control.Toggle
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import javafx.scene.shape.Box
import javafx.scene.text.Font
import javafx.scene.text.FontSmoothingType
import javafx.scene.text.TextAlignment
import javafx.scene.text.TextBoundsType
import tornadofx.*

fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {
    val list = listOf("Austin",
        "Dallas","Midland", "San Antonio","Fort Worth").observable()
    override val root = vbox {
        combobox<String> {
            items = list
        }
    }
}

