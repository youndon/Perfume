package AppeanaFx.u

import tornadofx.UIComponent
import tornadofx.View
import javax.xml.soap.Node

abstract class UIComponent {
    lateinit var uIComponent: UIComponent
    init {
        uIComponent.run {
            this.accelerators
            this.closeable
            this.complete
            this.creatable
            this.currentStage
            this.currentWindow
            this.deletable
            this.heading
            this.headingProperty
            this.icon
            this.iconProperty
            this.isComplete
            this.isDocked
            this.isDockedProperty
            this.modalStage
            this.onDockListeners
            this.onUndockListeners
            this.owningTab
            this.refreshable
            this.root
            this.savable
            this.title
            this.titleProperty
            this.builderFragment {root}
            this.fxmlLoader
//            this.fxml<>() // todo Node type?
            this.onCreate()
            this.onDelete()
            this.onRefresh()
            this.onSave()
            this.close()
            this.disableClose()
            this.disableDelete()
            this.disableCreate()
            this.disableSave()
            this.disableRefresh()
            this.closeableWhen {closeable}
            this.creatableWhen {closeable}
            this.deletableWhen {closeable}
            this.refreshableWhen {closeable}
            this.savableWhen {closeable}
            this.builderWindow {root}
            this.completeWhen {closeable}
            this.whenCreated { }
            this.whenDeleted { }
            this.whenRefreshed { }
            this.whenSaved { }
            this.wrapper {root}
            this.dialog { }
            this.forwardWorkspaceActions(this)
            this.fxid<Any>()
            this.goto<View>()
//            this.loadFXML<>() // todo Node type?
            this.onDock()
            this.onUndock()
            this.onBeforeShow()
//            this.openInternalBuilderWindow() // todo
//            this.openInternalWindow() // todo
            this.openModal()
            this.openWindow()
            this.onGoto(this)
            this.onNavigateBack()
            this.onNavigateForward()
            this.onTabSelected()
            this.replaceWith<View>()
            this.shortcut(""){}

        }
    }
}