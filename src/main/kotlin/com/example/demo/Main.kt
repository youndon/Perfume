import javafx.scene.paint.Color
import tornadofx.*

fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {
    override val root = group {
        (0..5).forEach {
            rectangle {
                y = it * 40.0
                width = 200.0
                height = 20.0
                fill = Color.RED
            }
        }
    }
}