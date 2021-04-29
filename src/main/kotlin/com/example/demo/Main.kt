import tornadofx.*

fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {
    override val root = vbox {
        squeezebox {
            this.fillHeight
            this.multiselect
        }
    }
}