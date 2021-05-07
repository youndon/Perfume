import tornadofx.App
import tornadofx.View
import tornadofx.launch
import tornadofx.vbox


fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {
    override val root = vbox {

    }
}