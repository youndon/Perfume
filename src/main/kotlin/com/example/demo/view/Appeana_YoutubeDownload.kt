package com.example.demo.view

import com.github.kiulian.downloader.model.quality.AudioQuality
import com.github.kiulian.downloader.model.quality.VideoQuality
import javafx.beans.Observable
import javafx.collections.ObservableList
import javafx.scene.control.*
import tornadofx.*
import java.io.File
import kotlin.system.exitProcess

typealias KYD = com.example.demo.box.YoutubeDownloader
fun main() {
    launch<YoutubeDownloadApp>()
}
class YoutubeDownloadApp:App(Appeana_YoutubeDownload::class)

class Appeana_YoutubeDownload:UIComponent("KYD") {
    private var url = TextField()
    private var path = TextField()
    private var videoWithAudio = CheckBox()
    private var audioQuality = CheckBox()
    private var audioListQuality = ComboBox<AudioQuality>()
    private var videoQuality = CheckBox()
    private var videoListQuality = ComboBox<VideoQuality>()
    private var AllSubtitles = CheckBox()
    private var cc = CheckBox()
    private var details = CheckBox()
    private var ccList = ComboBox<String>()

    override val root = form {
        setPrefSize(600.0, 200.0)
        vbox {
            spacing = 10.0
            url = textfield {}
            path = textfield {
                text = "${System.getProperty("user.home")}/Downloads/"
            }
            vbox {
                spacing = 7.0
                videoWithAudio = checkbox("videoWithAudio")
                borderpane {
                    left{
                        videoQuality = checkbox("videoQuality"){
                            setOnAction {
                                try {
                                    videoListQuality.items = KYD().videoListQuality(url.text).observable()
                                } catch (ex: Exception) {
                                    alert(Alert.AlertType.WARNING, ex.localizedMessage)
                                }
                            }
                        }
                    }
                    right{
                        videoListQuality = combobox {
                            this.visibleWhen {
                                videoQuality.selectedProperty()
                            }
                            this.visibleRowCount = 3
                        }
                    }
                }
                borderpane {
                    left {
                        audioQuality = checkbox("audioQuality") {
                            setOnAction {
                                try {
                                    audioListQuality.items = KYD().audioListQuality(url.text).observable()
                                } catch (ex: Exception) {
                                    alert(Alert.AlertType.WARNING, ex.localizedMessage)
                                }
                            }
                        }
                    }
                    right {
                        audioListQuality = combobox{
                            this.visibleWhen {
                                audioQuality.selectedProperty()
                            }
                            this.visibleRowCount = 3
                        }
                    }
                }
                borderpane {
                    left{
                        AllSubtitles = checkbox("AllSubtitles")
                    }
                    center {
                        cc = checkbox("subtitle"){
                            this.setOnAction {
                                try {
                                    ccList.items = KYD().ccList(url.text).observable()
                                }catch (ex:Exception){
                                    alert(Alert.AlertType.WARNING,ex.localizedMessage)
                                }
                            }
                        }
                    }
                    right{
                        ccList = combobox {
                            this.visibleWhen {
                                cc.selectedProperty()
                            }
                            this.visibleRowCount = 3
                        }
                    }
                }
                details = checkbox("details")
            }
        }
        buttonbar {
            button("Download") {
                action {
                    try {
                        File(KYD().filepath(url.text, path.text)).mkdir()
                        if (videoWithAudio.isSelected) {
                            KYD().videoWithAudio(url.text, path.text)?.get()
                            KYD().thumbnails(url.text, path.text)
                        }
                        if (AllSubtitles.isSelected) {
                            KYD().allSubtitles(url.text, path.text)
                        }
                        if (details.isSelected) {
                            val ff = File("${KYD().filepath(url.text, path.text)}/Details.txt")
                            KYD().details(url.text).forEach { it ->
                                ff.appendText("$it\n")
                            }
                            ff.createNewFile()
                        }
                        if (cc.isSelected){
                            try{
                                KYD().cc(url.text,path.text,ccList.selectionModel.selectedIndex)
                           }catch (ex:Exception){
                                alert(Alert.AlertType.WARNING,"the cc items not selected!!")
                            }
                        }
                        if (audioQuality.isSelected){
                            try{
                                KYD().audioQuality(url.text,path.text,audioListQuality.selectionModel.selectedItem)
                            }catch (ex:Exception){
                                alert(Alert.AlertType.WARNING,"the audio quality not selected!!")
                            }
                        }
                        if (videoQuality.isSelected){
                            try{
                                KYD().videoQuality(url.text,path.text,videoListQuality.selectionModel.selectedItem)
                            }catch (ex:Exception){
                                alert(Alert.AlertType.WARNING,"the video quality not selected!!")
                            }
                        }
                    } catch (ex: Exception) {
                        alert(Alert.AlertType.ERROR, ex.localizedMessage)
                    }
                }
            }
            button("cancel!").action {
                exitProcess(0)
            }
        }
    }
}

