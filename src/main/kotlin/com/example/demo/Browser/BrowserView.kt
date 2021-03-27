package com.example.demo.Browser

import tornadofx.*

class BrowserView : View(){
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