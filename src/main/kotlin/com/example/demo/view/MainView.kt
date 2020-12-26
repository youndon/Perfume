package com.example.demo.view

import javafx.application.Platform
import javafx.beans.property.SimpleObjectProperty
import javafx.event.EventTarget
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*
import kotlin.concurrent.thread

class MainView :View("Main") {

    override val root = vbox {
        primaryStage.height = 300.0
        primaryStage.width = 500.0
        spacing = 20.0
        textflow {
            text("Land ") {
                font = Font.font("Manjari Thin", 60.0)
            }
            text("Rover") {
                font = Font.font("Manjari Thin", 60.0)
                fill = Color.ORANGE
            }
        }
        button("viavia...") {
            shortpress {
                println("shortPress!!")
            }
            longpress {
                println("longPress!!")
            }
            tooltip("popup..."){
                    font = Font.font("Ubuntu Thin")
                }

        }
        progressbar {
            }
        progressindicator {
            progress = 1.0

        }

    }

    }










//            val ss = Font.getFontNames()
//            listview<Any> {
//                ss.forEach { it ->
//                    val ff = label(it.toString()) {
//                        font = Font.font(it.toString(),25.0)
//                    }
//                    items.addAll(ff)
//                }
//            }

//        style {}
//        stylesheet {}
//        lookup<View> {}
//        spacer { }
//        gridpane {}
//        tooltip {}
//        gridpane {}
//        ellipse {}
//        cubiccurve {}
//        quadcurve {}
//        vboxConstraints {}
//        treeview<Controller> {}
//        titledpane {}
//        drawer {}
//        tabpane {}
//        separator {}
//        region {}
//        spinner<Int>{}
//        choicebox<Int> {}
//        flowpane {}
//        htmleditor {}
