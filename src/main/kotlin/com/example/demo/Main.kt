import com.sun.glass.ui.monocle.LinuxArch
import javafx.geometry.Side
import javafx.scene.paint.Color
import tornadofx.*
import java.awt.Desktop
import java.io.File


fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {
    override val root = group {
        hyperlink("Open home file") {
            action{
                Desktop.getDesktop().open(File(System.getProperty("user.home")))
            }
        }
    }
}