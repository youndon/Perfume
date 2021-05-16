import com.github.thomasnield.rxkotlinfx.tabSelections
import io.reactivex.rxkotlin.toObservable
import javafx.geometry.Orientation
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.ScatterChart
import javafx.scene.layout.AnchorPane
import javafx.scene.paint.Color
import javafx.scene.shape.ArcType
import javafx.scene.shape.FillRule
import javafx.scene.shape.PathElement
import javafx.scene.text.Font
import tornadofx.*
import java.nio.file.Paths
import kotlin.random.Random

fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView: View() {
    override val root = stackpane {
        path(){
            moveTo(0.0, 0.0)
            hlineTo(70.0)
            quadqurveTo {
                x = 120.0
                y = 60.0
                controlX = 100.0
                controlY = 0.0
            }
            lineTo(175.0, 55.0)
            arcTo {
                x = 50.0
                y = 50.0
                radiusX = 50.0
                radiusY = 50.0
            }
        }
    }
}
