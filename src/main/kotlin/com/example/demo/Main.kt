import javafx.scene.Parent
import tornadofx.*

fun main() {
    launch<MainLand>()
}
class MainLand:App(ViewLand::class)
class ViewLand:View(){
    override val root = label{
        text = "land rover!!"
    }
}