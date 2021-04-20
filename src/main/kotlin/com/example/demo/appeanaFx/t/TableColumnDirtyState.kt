package AppeanaFx.t

import javafx.scene.control.TableColumn
import tornadofx.TableColumnDirtyState

class TableColumnDirtyState {
    lateinit var tableColumnDirtyState: TableColumnDirtyState<String>
    init {
        tableColumnDirtyState.run {
            this.dirty
            this.dirtyColumns
            this.editModel
            this.invalidationListeners
            this.isDirty
            this.item
            this.commit()
            this.getDirtyColumnProperty(TableColumn<Any,Any>(""))
            this.isDirtyColumn(TableColumn<Any,Any>(""))
            this.rollback()
        }
    }
}