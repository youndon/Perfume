
import javafx.geometry.Pos
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonBar.BUTTON_ORDER_LINUX
import javafx.scene.control.ButtonBar.BUTTON_ORDER_MAC_OS
import javafx.scene.control.Toggle
import javafx.scene.paint.Color
import javafx.scene.shape.Box
import tornadofx.*

fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {
    override val root = hbox{
      anchorpaneConstraints {

      }
        anchorpane(){

        }
        vboxConstraints {
            this.margin
        }
    }
}