import javafx.geometry.Side
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import tornadofx.*


fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {
    override val root = group {
        drawer(Side.LEFT) {
            this.item(""){
                imageview {  }
            }
        }

    }
}
