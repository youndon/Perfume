
import javafx.scene.paint.Color
import javafx.scene.shape.Box
import tornadofx.*

fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {
    override val root = borderpane {
        center{
            buttonbar{
                buttons
            }
        }
    }
}