import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import tornadofx.*

fun main() = launch<MainApp>()
class MainApp:App(MainView::class)
class MainView:View() {
    override val root = vbox {
        piechart {
            this.data
            this.isClockwise
            this.labelLineLength
            this.labelsVisible
            this.startAngle
            this.data("",25.0).run {
                this.pieValue
            }
        }
    }
}