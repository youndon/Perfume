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
        drawer {
            this.buttonArea.run {
                this.items
                this.orientation
            }
            this.contentArea
            this.contextMenu.run {
                this.isImpl_showRelativeToWindow
                this.items
                this.item()
                this.onAction
                this.setOnAction {  }
                this.show()
            }
            this.dockingSide.run {
                this.isHorizontal
                this.isVertical
            }
            this.fixedContentSize
            this.floatingDrawers
            this.items
            this.item{}
            this.maxContentSize
            this.multiselect
        }
    }
}
