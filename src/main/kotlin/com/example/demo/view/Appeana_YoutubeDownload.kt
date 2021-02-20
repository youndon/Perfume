package com.example.demo.view

import javafx.scene.control.*
import tornadofx.*
import tornadofx.osgi.addViewsWhen
import java.io.File
import kotlin.system.exitProcess

typealias YDQ = com.example.demo.box.YoutubeDownloader
fun main() {
    launch<YoutubeDownloadApp>()
}
class YoutubeDownloadApp:App(Appeana_YoutubeDownload::class)

class Appeana_YoutubeDownload:UIComponent() {
    private var url = TextField()
    private var path = TextField()
    private var videoWithAudio = CheckBox()
    private var audioOnly = CheckBox()
    private var videoOnly = CheckBox()
    private var subtitles = CheckBox()
    private var details = CheckBox()

    override val root = form {
        setPrefSize(600.0, 200.0)
        vbox {
            spacing = 10.0
            url = textfield() {
            }
            path = textfield {
                text = "${System.getProperty("user.home")}/Downloads/"
            }
            hbox {
                videoWithAudio = checkbox("videoWithAudio")
                videoOnly = checkbox("videoOnly")
                audioOnly = checkbox("audioOnly")
                subtitles = checkbox("subtitles")
                details = checkbox("details")
            }
        }
        buttonbar {
            button("Download") {
                action {
                    try {
                        File(YDQ().filepath(url.text, path.text)).mkdir()
                        if (videoWithAudio.isSelected) {
                            YDQ().videoWithAudio(url.text, path.text)?.get()
                            YDQ().thumbnails(url.text, path.text)
                        }
                        if (videoOnly.isSelected) {
                            YDQ().videoOnly(url.text, path.text)?.get()
                        }
                        if (audioOnly.isSelected) {
                            YDQ().audioOnly(url.text, path.text)?.get()
                        }
                        if (subtitles.isSelected) {
                            YDQ().allSubtitles(url.text, path.text)
                        }
                        if (details.isSelected) {
                            val ff = File("${YDQ().filepath(url.text, path.text)}/Details.txt")
                            YDQ().details(url.text).forEach { it ->
                                ff.appendText("$it\n")
                            }
                            ff.createNewFile()
                        }
                    } catch (ex: Exception) {
                        alert(Alert.AlertType.ERROR, ex.localizedMessage)
                    }
                }
            }
            button("close!").action {
                exitProcess(0)
            }
        }
        checkbox {

        }

    }
}

