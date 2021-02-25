package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.scene.Parent
import javafx.scene.web.WebView
import tornadofx.*

fun main() {
    launch<BrowserApp>()
}
class BrowserApp: App(BrowserView::class)

class BrowserModel(address:String):ViewModel(){
    var url = bind { SimpleStringProperty(address) }
}
class BrowserView :View(){
    private var webView = webview()
    var browserModel = BrowserModel("http://www.duckduckgo.com")
    override val root = gridpane {
        row {
            hbox {
                button("back").action {
                    webView.engine.executeScript("history.back()")
                }
                button("forward").action {
                    webView.engine.executeScript("history.forward())")
                }
                textfield {
                    textProperty().bindBidirectional(browserModel.url)
                    action {
                        webView.engine.load(browserModel.url.value)
                    }
                }
                button("search").action {
                    webView.engine.load(browserModel.url.value)
                }
            }
        }
        row {
            children.add(webView)
           webView.engine.load(browserModel.url.value)
            useMaxHeight=true
            useMaxWidth=true

        }
    }
}