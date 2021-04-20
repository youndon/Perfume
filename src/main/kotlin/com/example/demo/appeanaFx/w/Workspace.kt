package AppeanaFx.w

import tornadofx.View
import tornadofx.Workspace

class Workspace {
    lateinit var workspace: Workspace
    init {
        workspace.run {
            this.backButton
            this.bottomDrawer
            this.contentContainer
            this.contentContainerProperty
            this.createButton
            this.deleteButton
            this.dockedComponent
            this.dockedComponentProperty
            this.forwardButton
            this.header
            this.headingContainer
            this.leftDrawer
            this.maxViewStackDepth
            this.maxViewStackDepthProperty
            this.navigationMode
            this.navigationModeProperty
            this.refreshButton
            this.rightDrawer
            this.saveButton
            this.showHeadingLabel
            this.showHeadingLabelProperty
            this.stackContainer
            this.tabContainer
            this.viewStack
            this.disableNavigation()
//            this.dock() // todo
            this.dockInNewScope<View>()
            this.withNewScope(this){}
            this.inDynamicComponentMode { }
            this.navigateBack()
            this.navigateForward()
        }
    }
}