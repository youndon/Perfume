import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import javafx.scene.control.cell.TreeItemPropertyValueFactory
import tornadofx.*


fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView:View() {
    override val root = vbox {

            val treeTableView = TreeTableView<Car>()
            val treeTableColumn1 = TreeTableColumn<Car, String>("Brand")
            val treeTableColumn2 = TreeTableColumn<Car, String>("Model")
            treeTableColumn1.cellValueFactory = TreeItemPropertyValueFactory("brand")
            treeTableColumn2.cellValueFactory = TreeItemPropertyValueFactory("model")
            treeTableView.columns.add(treeTableColumn1)
            treeTableView.columns.add(treeTableColumn2)

        val mercedes1 = TreeItem(Car("Mercedes", "SL500"))
        val mercedes2 = TreeItem(Car("Mercedes", "SL500 AMG"))
        val mercedes3 = TreeItem(Car("Mercedes", "CLA 200"))
        val mercedes = TreeItem(Car("Mercedes", "..."))
        mercedes.children.add(mercedes1)
        mercedes.children.add(mercedes2)
        val audi1 = TreeItem(Car("Audi", "A1"))
        val audi2 = TreeItem(Car("Audi", "A5"))
        val audi3 = TreeItem(Car("Audi", "A7"))
        val audi = TreeItem(Car("Audi", "..."))
        audi.children.add(audi1)
        audi.children.add(audi2)
        audi.children.add(audi3)
        val cars = TreeItem(Car("Cars", "..."))
        cars.children.add(audi)
        cars.children.add(mercedes)
        treeTableView.setRoot(cars)
    }
}


class Car(var brand: String?, model: String?) {
    var model: String? = model
        private set

    fun setModel(model: String) {
        this.model = model
    }
}
