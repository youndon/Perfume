package AppeanaFx.t

import tornadofx.TableViewEditModel

class TableViewEditModel {
    lateinit var tableViewEditModel: TableViewEditModel<String>
    init {
        tableViewEditModel.run {
            this.items
            this.selectedItemDirty
            this.selectedItemDirtyState
            this.tableView
            this.enableDirtyTracking(true)
            this.getDirtyState("")
            this.isDirty("")
            this.commitSelected()
            this.commit()
            this.rollback()
            this.rollbackSelected()
        }
    }
}