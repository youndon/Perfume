import javafx.geometry.Orientation
import javafx.scene.layout.AnchorPane
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*
import java.nio.file.Paths

fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {
    override val root = scrollpane {
        this.viewportBounds.run {
            this.contains(0.0,0.0,0.0,0.0,0.0,0.0)
            this.intersects(0.0,0.0,0.0,0.0,0.0,0.0)
        }
    }
}