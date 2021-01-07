package com.example.demo.javaFx

import javafx.animation.Interpolator
import javafx.css.PseudoClass
import javafx.event.Event
import javafx.event.EventType
import javafx.geometry.Orientation
import javafx.geometry.Point2D
import javafx.scene.*
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.TreeItem
import javafx.scene.image.Image
import javafx.stage.Modality
import javafx.stage.StageStyle
import javafx.util.Duration
import tornadofx.*
import tornadofx.osgi.ViewProvider
import tornadofx.osgi.addViewsWhen
import tornadofx.osgi.impl.*

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
//            addEventFilter() // todo
//            addEventHandler() // todo
//            addStylesheet() // todo
            add(this)
            addTo(pane())
//            addDecorator() // todo
            addChildIfPossible(this)
            addStageIcon(Image("Amazing.jpg"))
            addClass("")
            addPseudoClass("")
            addViewsWhen {viewProvider: ViewProvider -> true}
            applyCss()
            app
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
            boundsInLocal
            boundsInLocalProperty()
            boundsInParent
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
            c("#ffff")
            childrenUnmodifiable
            cache("") { parent }
            cacheProperty()
            cacheHint
            cacheHintProperty()
            clip
            clipProperty()
            clipboard
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
            config
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
            fxmlLoader
            fxml<Node>()
            fxid<Node>()
//            fxBundle // todo
//            fxBundleContext // todo
            forwardWorkspaceActions(this@UI)
//            floatBinding() // todo
            fragment<Fragment>()
            fiveDigits
            fieldset()
            field()
            flowpane()
            form()
            fade(Duration.ONE,1, Interpolator.DISCRETE)
            follow(Duration.ONE,path())

            // h.
            heading
            headingProperty
            hostServices
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
            inject<Controller>()
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
            log
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
            messages
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
            parent
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
            primaryStage
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
            requestLayout()
            rotate
            rotationAxis
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
            scene
            sceneProperty()
            sceneToLocal(1.0,1.0)
            setEventDispatcher{event, eventDispatchChain -> event }
            styleClass
            styleableParent
//            snapshot() // todo
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
            scope
            savable
            savableWhen { needsLayoutProperty()}
            subscribedEvents
            subscribe<FXEvent> { }
            stackpane { }
            stackpaneConstraints { }
            setInScope<ScopedInstance>(workspace)
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
            userData
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