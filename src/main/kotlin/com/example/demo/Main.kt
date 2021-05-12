import com.github.thomasnield.rxkotlinfx.tabSelections
import javafx.geometry.Orientation
import javafx.scene.layout.AnchorPane
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*
import java.nio.file.Paths

fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {
    override val root = tabpane {

    }
}
