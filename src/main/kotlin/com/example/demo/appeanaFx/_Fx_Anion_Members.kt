package appeanaFx


import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import tornadofx.*
import tornadofx.osgi.impl.*

private fun some(){

    RESIZE_TYPE_KEY
    TRANSITIONING_PROPERTY
    UI_COMPONENT_PROPERTY
    fiveDigits
    infinity
    viewModelBundle
    launch<App>()
    ChangeListener<Any> { observable, oldValue, newValue -> }
//    TableViewResizeCallback { }
//    TreeTableViewResizeCallback { }
//    addStageIcon()
    alert(Alert.AlertType.NONE,"...")
    beforeShutdown{}
//    bindStringProperty()
//    booleanBinding()
//    booleanListBinding()
    box(null)
    c("#ffff",1.0) // color.
    chooseDirectory {  }
    chooseFile("",arrayOf())
    command {  }
    confirm("header","content", ButtonType.APPLY, ButtonType.CANCEL,null, "title") {}
    confirmation("")
    cssclass()
    csselement()
    cssid()
    cssproperty<Any> { any -> "" }
    csspseudoclass()
//    doubleBinding()
    dumpStylesheets()
    error("")
    find<Component>()
//    floatBinding()
    getDefaultConverter<Any>()
    importStylesheet<Stylesheet>()
    information("")
    insets()
//    integerBinding()
    loadFont("",1)
    loadJsonArray("")
    loadJsonModel<JsonModel>("")
    loadJsonObject("")
//    longBinding()
    mixin { }
    multi("")
//    nonNullObjectBinding()
//    objectBinding()
//    observable()
//    opcr()
    parallelTransition {  }
//    pause()
    point(1,1)
//    populateTree()
//    property()
//    proxyprop()
//    proxypropDouble()
    reloadStylesheetsOnFocus()
    reloadViewsOnFocus()
    removeStylesheet<Stylesheet>()
//    resizeCall()
    runAsync { }
    runLater {}
    sequentialTransition {  }
//    setInScope()
//    setStageIcon()
    singleAssign<Any>()
//    stringBinding()
    task {  }
    terminateAsyncExecutors(1L)
    timeline { }
//    validator()
    warning("")
    weak("")

    /** tornadofx.osgi.impl: */
//    fxBundle
//    fxBundleContext
    getBundleId<Any>()

    /** tornadofx.adapters: */
    TableViewResizeCallback { param ->  null  }
    TreeTableViewResizeCallback { param -> null }
}