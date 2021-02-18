package com.example.demo.view

import com.github.kiulian.downloader.OnYoutubeDownloadListener
import com.github.kiulian.downloader.YoutubeDownloader
import com.github.kiulian.downloader.model.Extension
import com.github.kiulian.downloader.model.quality.AudioQuality
import javafx.scene.control.*
import javafx.scene.text.Text
import tornadofx.*
import java.io.File
import java.net.URL
import java.util.*
import java.util.concurrent.Future
import javax.imageio.ImageIO

fun main() {
    launch<YoutubeDownloadApp>()
}
class YoutubeDownloadApp:App(Appeana_YoutubeDownload::class)
class Appeana_YoutubeDownload:UIComponent() {
    private var url = TextField()
    private var path = TextField()
    private var video = RadioButton()
    private var audio = RadioButton()
    private var subtitles = RadioButton()
    private var details = RadioButton()
    private var download = Button()
    private var progressBar = ProgressBar()
    private var txt = Text()
    // //https://www.youtube.com/watch?v=3F2NeH_-f34
    override val root = form {
        setPrefSize(600.0,200.0)
        vbox {
            url = textfield() {
            }
            path = textfield {
                text = "${System.getProperty("user.home")}/Downloads/"
            }
            hbox {
                video = radiobutton("video")
                audio = radiobutton("audio")
                subtitles = radiobutton("subtitles")
                details = radiobutton("details") { }
                }
            }
            buttonbar {
                download = button("Download") {
                    action {
                        try {
                        File(filepath()).mkdir()
                        if (video.isSelected) {
                            videoid()?.get()
                            thumbnails()
                        }
                        if (audio.isSelected) {
                            audioid()?.get()
                        }
                        if (subtitles.isSelected) {
                            subtitles()
                        }
                        if (details.isSelected) {
                            val ff = File("${filepath()}/Details.txt")
                            details().forEach { it ->
                                ff.appendText("$it\n")
                            }
                            ff.createNewFile()
                        }
                    } catch (ex:Exception){
                        alert(Alert.AlertType.ERROR,ex.localizedMessage)
                        }
                    }
                }
                button("close!").action {
                    videoid()?.cancel(true)
                    audioid()?.cancel(true)
                }
                progressBar = progressbar {

                }
                txt = text {

                }
            }
    }
    private fun id(): String {
        return url.text.substringAfterLast('=')
    }
    private fun downloader(): YoutubeDownloader {
        // init downloader:
        val downloader = YoutubeDownloader()
        downloader.run {
            // downloader configurations:
            setParserRequestProperty(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36",
            )
            setParserRetryOnFailure(1)
        }
        return downloader
    }
    private fun videoid(): Future<File>? {
        val videoid = downloader().getVideo(id())
        return videoid.downloadAsync(videoid.videoWithAudioFormats()[0],
            File(filepath()),
            object : OnYoutubeDownloadListener {
                override fun onDownloading(p0: Int) {
                }
                override fun onFinished(p0: File?) {
                    txt.text = "the downloading complete."
                }
                override fun onError(p0: Throwable?) {
                    alert(Alert.AlertType.ERROR, p0?.message.toString())
                }
            })
    }
    private fun audioid(): Future<File>? {
        val videoid = downloader().getVideo(id())
        return videoid.downloadAsync(videoid.findAudioWithQuality(AudioQuality.medium)[0],
            File(filepath()),
            object : OnYoutubeDownloadListener {
                override fun onDownloading(p0: Int) {
                }
                override fun onFinished(p0: File?) {
                    txt.text = "the downloading complete."
                }
                override fun onError(p0: Throwable?) {
                    alert(Alert.AlertType.ERROR, p0?.message.toString())
                }
            })
    }
    private fun subtitles(){
        val file = "${filepath()}/Subtitles"
        return downloader().getVideoSubtitles(id()).forEach { subInfo ->
            subInfo.subtitles
                .formatTo(Extension.WEBVTT)
                .download().also {
                    File(file).mkdir()
                    File(file +
                                "/${subInfo.language}.vtt"
                    ).run {
                        this.createNewFile()
                        this.appendText(it)
                    }
                }
        }
    }
    private fun filepath(): String {
        return "${path.text}/${filename()}"
    }
    private fun filename(): String {
        return downloader().getVideo(id()).details().title().substringBefore('|')
    }
    private fun thumbnails(): Boolean {
        val img = ImageIO.read(URL("${downloader().getVideo(id()).details().thumbnails()[0]}.jpg"))
        val file = File("${filepath()}/${filename()}.jpg")
       return ImageIO.write(img, "jpg", file)
    }
    private fun details(): ArrayList<String> {
        val list = arrayListOf<String>()
        downloader().getVideo(id()).details().run {
           list.add("title: " + title())
           list.add("viewCount: " + viewCount())
           list.add("author: " + author())
            (this.keywords().forEach {
                list.add("keywords: $it")
            })
            list.add("lengthSeconds: " + lengthSeconds())
            list.add("id: " + videoId())
            list.add("averageRating: " + averageRating())
            list.add("description: " + description())
            list.add("isLive: $isLive")
            list.add("isLiveContent: $isLiveContent")
            (this.thumbnails().forEach {
                list.add("thumbnails: $it")
            })
        }
        return list
    }

}