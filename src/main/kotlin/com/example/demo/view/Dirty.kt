package com.example.demo.javaFx

import javafx.animation.Interpolator
import javafx.css.PseudoClass
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.geometry.Orientation
import javafx.geometry.Point2D
import javafx.scene.*
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.TreeItem
import javafx.scene.image.Image
import javafx.scene.input.Mnemonic
import javafx.stage.Modality
import javafx.stage.StageStyle
import javafx.util.Duration
import tornadofx.*
import tornadofx.osgi.ViewProvider
import tornadofx.osgi.addViewsWhen
import tornadofx.osgi.impl.*
import javax.swing.text.html.StyleSheet

private class UI(override val root: Parent) :UIComponent() { init {
    with(root){
        // a.
        accessibleHelp
        accessibleHelpProperty()
        accessibleRole
        accessibleRoleProperty()
        accessibleRoleDescription
        accessibleRoleDescriptionProperty()
        accessibleText
        accessibleTextProperty()
        add(this)
        addTo(pane())
//            addDecorator() // todo
        addChildIfPossible(this)
        addStageIcon(Image("Amazing.jpg"))
        addClass("")
        addPseudoClass("")
        addViewsWhen {viewProvider: ViewProvider -> true}
        applyCss()
        app.run {
            this.configBasePath
            this.createPrimaryScene(this@UI)
//                this.fire()
//                this.inject()
//                this.k()
//                this.onBeforeShow()
            this.primaryView
            this.resources
            this.scope
            this.shouldShowPrimaryStage()
//                this.trayicon()
            this.workspace
        }
        autosize()
        arc()
        accordion()
        anchorpane()
        addStageIcon(Image(""))
        alert(Alert.AlertType.INFORMATION,"")

        // b.
        baselineOffset
        blendMode
        blendModeProperty()
        boundsInLocal.run {
            this.depth
            this.height
            this.width
            this.isEmpty
            this.maxX
            this.maxY
            this.maxZ
            this.minX
            this.minY
            this.minZ
//                this.contains()
//                this.intersects()
        }
        boundsInLocalProperty()
        boundsInParent.run {
        }
        boundsInParentProperty()
        bindClass("".observable())
        buildEventDispatchChain(null)
        builderTarget
        builderFragment("",scope) { parent }
        builderWindow("",Modality.APPLICATION_MODAL,StageStyle.UTILITY,scope,null) { parent }
        borderpane()
        borderpaneConstraints {  }
        button()
        buttonbar()
//            barchart() // todo
        bindChildren(observableList("")) { this }
        bindComponents(observableList("")){ this@UI }
        beforeShutdown {  }
//            bindStringProperty() // todo
        booleanBinding(this,stylesheets) {true}
//            booleanListBinding() // todo
        box("...")

        // c.
        c("#ffff") // color.
        childrenUnmodifiable
        cache("") { parent }
        cacheProperty()
        cacheHint
        cacheHintProperty()
        clip
        clipProperty()
        clipboard.run {
            this.clear()
            this.contentTypes
            this.files
//                this.getContent()
//                this.hasContent()
            this.hasFiles()
            this.hasHtml()
            this.hasImage()
            this.hasRtf()
            this.hasString()
            this.hasUrl()
            this.html
            this.image
//                this.put()
//                this.putFiles()
//                this.putString()
            this.rtf
            this.setContent {  }
            this.string
            this.url
        }
        contentBias
        cursor
        cursorProperty()
        computeAreaInScreen()
        contains(0.0,0.0)
        circle()
        cubiccurve()
        complete
        completeWhen { needsLayoutProperty()}
        combobox<Int>{ }
        command(){}
        close()
        closeable
        closeableWhen { needsLayoutProperty()}
        config.run {
//                this.boolean()
            this.configurable
//                this.double()
//                this.int()
//                this.jsonArray()
//                this.jsonModel()
//                this.jsonObject()
            this.save()
//                this.set()
        }
        configPath
        contextmenu()
        confirm("","", ButtonType.APPLY, ButtonType.CANCEL,null, "") {}
        confirmation("","", ButtonType.NEXT)
        creatable
        creatableWhen { needsLayoutProperty()}
        currentStage
        checkbox()
        currentWindow
        choicebox<Int>(){}
        colorpicker()
        canvas()
        chooseDirectory()
        chooseFile("", arrayOf())
        cssMetaData
        cssclass()
        csselement()
        cssid()
//            cssproperty() // todo
        csspseudoclass()

        // d.
        depthTest
        depthTestProperty()
        decorators
        deletable
        deletableWhen { needsLayoutProperty()}
        disableProperty()
//            di() // todo
        dialog("",Modality.NONE,StageStyle.UTILITY,scope,null, Orientation.VERTICAL) {}
        disableClose()
        disableCreate()
        disableDelete()
        disableRefresh()
        disableSave()
        disableWhen{ needsLayoutProperty()}
        datagrid(childrenUnmodifiable) {}
        datepicker()
        drawer{}
        doubleBinding("",needsLayoutProperty()){1.0}
        dumpStylesheets()
        dynamicContent(needsLayoutProperty()) {}

        // e.
        effect
        effectiveNodeOrientation
        eventDispatcher
        effectProperty()
        effectiveNodeOrientationProperty()
        eventDispatcherProperty()
        executeAccessibleAction(AccessibleAction.BLOCK_DECREMENT,"")
        ellipse()
        enableWhen { needsLayoutProperty()}

        // f.
//            fire() // todo
        fireEvent(Event(null))
        focusTraversableProperty()
        focusedProperty()
        findAll<Fragment>()
        find<Fragment>()
        fxmlLoader.run {
            this.builderFactory
            this.charset
            this.classLoader
            this.location
            this.namespace
            this.resources
            this.controllerFactory
//                this.getController()
//                this.setController()
//                this.setControllerFactory {  }()
//                this.setBuilderFactory { }
//                this.load()
//                this.getRoot()
//                this.setRoot()
        }
        fxml<Node>()
        fxid<Node>()
//            fxBundle // todo
//            fxBundleContext // todo
        forwardWorkspaceActions(this@UI)
//            floatBinding() // todo
        fragment<Fragment>()
        fiveDigits.run {
            this.decimalFormatSymbols
            this.groupingSize
            this.isDecimalSeparatorAlwaysShown
            this.isParseBigDecimal
            this.multiplier
            this.negativePrefix
            this.negativeSuffix
            this.positivePrefix
            this.positiveSuffix
            this.toLocalizedPattern()
            this.toPattern()
//                this.applyLocalizedPattern()
//                this.applyPattern()
        }
        fieldset()
        field()
        flowpane()
        form()
        fade(Duration.ONE,1, Interpolator.DISCRETE)
        follow(Duration.ONE,path())

        // h.
        heading
        headingProperty
        hostServices.run {
            this.codeBase
            this.documentBase
//                this.resolveURI()
//                this.showDocument()
        }
        hgrow
        hasProperties()
        hoverProperty()
        hasClass("")
        hasPseudoClass("")
        hide()
        hbox()
        hboxConstraints {  }
        htmleditor()
        hyperlink()
        hiddenWhen { needsLayoutProperty()}

        // i.
        isNeedsLayout
        inputMethodRequests
        inputMethodRequestsProperty()
        isCache
        isDisable
        isDisabled
        isFocusTraversable
        isFocused
        isHover
        isManaged
        isMouseTransparent
        isPickOnBounds
        isPressed
        isResizable
        isVisible
        isComplete
        isDocked
        isDockedProperty
        id
        idProperty()
        intersects(1.0,1.0,0.0,0.0)
        icon
        iconProperty
        init()
//            inject()
        imageview()
        isInsideRow()
//            include() // todo parebt type
        infinity
        importStylesheet("")
        information("")
        insets()
//            integerBinding() // todo

        // k.
        k(this::class.java)
        keyboard { }

        // l.
        layout()
        localToScreen(0.0,0.0)
        localToScene(0.0,0.0)
        localToParent(0.0,0.0)
        layoutBounds
        layoutBoundsProperty()
        layoutX
        layoutXProperty()
        layoutY
        layoutYProperty()
        localToParentTransform
        localToParentTransformProperty()
        localToSceneTransform
        localToSceneTransformProperty()
        lookup("")
        lookupAll("")
        line()
        loadConfig()
        log.run {
//                this.addHandler()
//                this.removeHandler()
//                this.config()
//                this.entering()
//                this.exiting()
            this.filter
//                this.fine()
//                this.finer()
//                this.finest()
            this.handlers
//                this.info()
//                this.isLoggable()
            this.level
//                this.log()
//                this.logp()
//                this.logrb()
            this.name
            this.parent
            this.resourceBundle
            this.resourceBundleName
//                this.severe()
//                this.throwing()
            this.useParentHandlers
//                this.warning()
        }
        loadFXML<Node>()
        loadFont("",1)
        loadJsonArray("")
        loadJsonModel<JsonModel>("")
        loadJsonObject("")
        label()
        listview<String>{}
        listmenu()
//            linechart(){} // todo
        lazyContextmenu()
        launch<App>()
//            longBinding() // todo
        longpress(){}

        // m.
        managedProperty()
        maxHeight(0.0)
        maxWidth(0.0)
        minHeight(0.0)
        minWidth(0.0)
        mouseTransparentProperty()
        mnemonicTarget()
        move(Duration.ONE, Point2D.ZERO)
        modalStage
        messages.run {
//                this[]
            this.baseBundleName
//                this.containsKey()
//                this.format()
            this.keySet()
//                this.get()
//                this.getStringArray()
//                this.getString()
//                this.getObject()
            this.keys
            this.keySet()
            this.locale
        }
        menubutton()
        menubar()
        mixin { }
        multi("")
        managedWhen { needsLayoutProperty()}

        // n.
        nodeOrientation
        nodeOrientationProperty()
        needsLayoutProperty()
        notifyAccessibleAttributeChanged(AccessibleAttribute.BOUNDS)
//            nonNullObjectBinding() // todo

        // o.
        opacity
        opacityProperty()
        onDoubleClick {  }
        onBeforeShow()
        onCreate()
        onDelete()
        owningTab
        onGoto(this@UI)
        onNavigateBack()
        onNavigateForward()
        onRefresh()
        onSave()
        onTabSelected()
        openInternalBuilderWindow(".."){parent}
        openInternalWindow(this@UI)
        openModal()
        openWindow()
        observable<String>("")
        observableList("")
//            objectBinding() // todo
        opcr<Node>(parent,this){}
        onHover {  }

        // p.
        parent.run {
            this.arc()
//                this.addStylesheet()
            this.childrenUnmodifiable
            this.circle()
            this.cubiccurve()
            this.ellipse {  }
//                this.findAll()
            this.gridpaneColumnConstraints
            this.gridpaneColumnConstraints {  }
            this.isNeedsLayout
            this.layout()
            this.line {  }
//                this.lookup()
            this.needsLayoutProperty()
            this.path()
            this.polygon()
            this.polyline()
            this.quadcurve {  }
            this.rectangle {  }
            this.requestLayout()
            this.stylesheets
            this.stylesheet {  }
            this.svgpath()
        }
        parentToLocal(0.0,0.0)
        parentProperty()
        properties
        pseudoClassStates
        pickOnBoundsProperty()
        pressedProperty()
        pseudoClassStateChanged(PseudoClass.getPseudoClass(""),true)
        prefHeight(0.0)
        prefWidth(0.0)
        path()
        polygon()
        polyline()
        primaryStage.apply{
            fullScreenExitHint // return the hint when full screen is active.
            isFullScreen
            isAlwaysOnTop // for make the window always visible on top.
            isResizable
            fullScreenExitKeyCombination // TODO: 14.01.2021
            title // title of the main window.
            icons
            isIconified
            isMaximized // for toke all the screen size when is open
            modality
            style
            maxHeight
            maxWidth
            minHeight
            minWidth
        }
        param<Fragment>()
        params
        paramsProperty
        preferences(""){}
        piechart()
        pagination()
        pane()
        passwordfield()
        progressbar()
        progressindicator()
        property{accessibleHelpProperty()}
//            proxyprop() // todo
//            proxypropDouble() // todo
        parallelTransition(true){}
        pause(Duration.ONE,true){}
        populateTree<String>(TreeItem(""),{ TreeItem() },{null})

        // r.
        rotate
        rotationAxis
        requestLayout()
        rotationAxisProperty()
        relocate(0.0,0.0)
        removeEventFilter<Event>(EventType.ROOT) {}
        removeEventHandler<Event>(EventType.ROOT) {}
        resize(0.0,0.0)
        requestFocus()
        rotateProperty()
        resizeRelocate(0.0,0.0,0.0,0.0)
//            resizeCall() // todo
//            removeDecorator() // todo
        rectangle()
        replaceWith(this@UI)
        replaceChildren()
        runLater{}
        runAsync{}
        runAsyncWithOverlay{}
        runAsyncWithProgress{}
        removeStylesheet<Stylesheet>()
        removeFromParent()
        removeClass()
        removePseudoClass("")
        removeWhen{ needsLayoutProperty()}
        radiobutton()
        reloadStylesheetsOnFocus()

        // s.
        style
        styleProperty()
        stylesheets
        scale(Duration.ONE, Point2D(1.0,1.0))
        scaleX
        scaleXProperty()
        scaleY
        scaleYProperty()
        scaleZ
        scaleZProperty()
//            scatterchart() // todo
        scene.run {
            root
            rootProperty()
            accelerators
            antiAliasing
            addEventFilter(EventType(""), EventHandler {  })
            addEventHandler(EventType(""), EventHandler {  })
            addMnemonic(Mnemonic(null,null))
//                addStylesheet()
            camera
            cameraProperty()
            fill
            fillProperty()
            height
            heightProperty()
            width
            widthProperty()
            mnemonics
            nodeOrientation
            nodeOrientationProperty()
            properties
            snapshot(null)
            startDragAndDrop()
            startFullDrag()
            stylesheets
            userAgentStylesheet
            userAgentStylesheetProperty()
            userData
            window
            windowProperty()
            x
            xProperty()
            y
            yProperty()
            onContextMenuRequested
            onContextMenuRequestedProperty()
            onDragDetected
            onDragDetectedProperty()
            onDragDone
            onDragDoneProperty()
            onDragDropped
            onDragDroppedProperty()
            onDragEntered
            onDragEnteredProperty()
            onDragExited
            onDragExitedProperty()
            onDragOver
            onDragOverProperty()
            onInputMethodTextChanged
            onInputMethodTextChangedProperty()
            onKeyPressed
            onKeyPressedProperty()
            onKeyReleased
            onKeyReleasedProperty()
            onKeyTyped
            onKeyTypedProperty()
            onMouseClicked
            onMouseClickedProperty()
            onMouseDragged
            onMouseDraggedProperty()
            onMouseDragEntered
            onMouseDragEnteredProperty()
            onMouseDragExited
            onMouseDragExitedProperty()
            onMouseDragOver
            onMouseDragOverProperty()
            onMouseDragReleased
            onMouseDragReleasedProperty()
            onMouseMoved
            onMouseMovedProperty()
            onMouseEntered
            onMouseEnteredProperty()
            onMouseExited
            onMouseExitedProperty()
            onMousePressed
            onMousePressedProperty()
            onMouseReleased
            onMouseReleasedProperty()
            onRotate
            onRotateProperty()
            onRotationFinished
            onRotationFinishedProperty()
            onRotationStarted
            onRotationStartedProperty()
            onTouchPressed
            onTouchPressedProperty()
            onScroll
            onScrollProperty()
            onScrollFinished
            onScrollFinishedProperty()
            onScrollStarted
            onScrollStartedProperty()
            onSwipeDown
            onSwipeDownProperty()
            onSwipeLeft
            onSwipeLeftProperty()
            onSwipeRight
            onSwipeRightProperty()
            onSwipeUp
            onSwipeUpProperty()
            onTouchMoved
            onTouchMovedProperty()
            onTouchReleased
            onTouchReleasedProperty()
            onTouchStationary
            onTouchStationaryProperty()
            onZoom
            onZoomProperty()
            onZoomFinished
            onZoomFinishedProperty()
            onZoomStarted
            onZoomStartedProperty()
            onDock()
            onDockListeners
            onUndock()
            onUndockListeners
            setOnContextMenuRequested {  }
            setOnDragDetected {  }
            setOnDragDone {  }
            setOnDragDropped {  }
            setOnDragEntered {  }
            setOnDragExited {  }
            setOnDragOver {  }
            setOnInputMethodTextChanged {  }
            setOnKeyPressed {  }
            setOnKeyReleased {  }
            setOnKeyTyped {  }
            setOnMouseClicked {  }
            setOnMouseDragged {  }
            setOnMouseDragEntered {  }
            setOnMouseDragExited {  }
            setOnMouseDragOver {  }
            setOnMouseDragReleased {  }
            setOnMouseMoved {  }
            setOnMouseEntered {  }
            setOnMouseExited {  }
            setOnMousePressed {  }
            setOnMouseReleased {  }
            setOnRotate {  }
            setOnRotationFinished {  }
            setOnRotationStarted {  }
            setOnScroll {  }
            setOnScrollFinished {  }
            setOnScrollStarted {  }
            setOnSwipeDown {  }
            setOnSwipeRight {  }
            setOnSwipeLeft {  }
            setOnSwipeUp {  }
            setOnTouchMoved {  }
            setOnTouchPressed {  }
            setOnTouchReleased {  }
            setOnTouchStationary {  }
            setOnZoom {  }
            setOnZoomFinished {  }
            setOnZoomStarted {  }

        }
        sceneProperty()
        sceneToLocal(1.0,1.0)
        setEventDispatcher{event, eventDispatchChain -> event }
        styleClass
        styleableParent
        startDragAndDrop()
        startFullDrag()
        svgpath { }
        stackpane { }
        show()
//            select<Node>() // todo
//            selectAll<Node>() // todo
//            stringBinding() // todo
        shortcut(""){}
        shortpress(true) {}
        scope.run {
            deregister()
            hasActiveWorkspace
            invoke(this@UI::class)
            workspace(workspace)
        }
        savable
        savableWhen { needsLayoutProperty()}
        subscribedEvents
        subscribe<FXEvent> { }
        stackpane { }
        stackpaneConstraints { }
//            setInScope<ScopedInstance>(workspace)
        setWindowMaxSize(1,1)
        setWindowMinSize(1,1)
//            stackedbarchart() // todo Axis<X>?
        scrollpane { }
        separator { }
        slider { }
//            spinner { } // todo
        squeezebox { }
        splitpane()
        slideshow { }
        svgpath { }
        sequentialTransition { }

        // t.
        transforms
        transform(Duration.ONE, Point2D(0.0,0.0),1, Point2D(0.0,0.0),2)
        translateX
        translateXProperty()
        translateY
        translateYProperty()
        translateZ
        translateZProperty()
        typeSelector
        toBack()
        toFront()
        toProperty()
        togglegroup {}
        tooltip { }
        title
        titleProperty
        titledpane { }
        text { }
        textflow { }
        textfield { }
        textarea { }
        tableview<String> { }
        tabpane { }
        tag
        tagProperty
        toolbar()
        treeview<String> { }
        treetableview<String> { }
        task { }
        timeline { }
        toggleClass("",true)
        togglegroup { }
        togglebutton { }
        togglePseudoClass("",true)
        terminateAsyncExecutors(1L)

        // u.
        usesMirroring()
        unsubscribe<FXEvent> {  }
        uiComponent<Fragment>()

        // v.
        visibleProperty()
        vgrow
        vbox { }
        viewModelBundle
//            validator() // todo
        vboxConstraints { }
        visibleWhen { needsLayoutProperty()}

        // w.
        whenVisible { }
        wrapIn(parent)
        workspace
        whenCreated { }
        whenDeleted { }
        whenRefreshed { }
        whenSaved { }
        wrapper { parent}
        webview { }
        warning("")
        weak(""){}
        whenDocked { }
        whenDockedOnce { }
        whenUndocked { }
        whenUndockedOnce { }

        // q.
        queryAccessibleAttribute(AccessibleAttribute.BOUNDS)
        quadcurve { }

    }
}
}