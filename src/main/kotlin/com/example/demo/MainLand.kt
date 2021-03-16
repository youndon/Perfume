package com.example.demo.view

import com.example.demo.box.Monitor
import com.example.demo.box.YoutubeDownloader
import com.github.kiulian.downloader.OnYoutubeDownloadListener
import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.scene.chart.*
import javafx.util.Duration
import tornadofx.*
import javafx.collections.FXCollections
import javafx.scene.Parent
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.LineChart
import javafx.scene.control.Alert
import javafx.scene.text.Text
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hyperic.sigar.Sigar
import java.io.File
import java.util.concurrent.Future

fun main() = launch<MainLand>()
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    var txt = Text()
    override val root =form {
        setPrefSize(300.0, 300.0)
        txt = text("...") {

        }
        videoWithAudio("https://www.youtube.com/watch?v=TvWcU3aztmo","/home/yon/")
    }
        fun downloader(): com.github.kiulian.downloader.YoutubeDownloader {
            // init downloader:
            val downloader = com.github.kiulian.downloader.YoutubeDownloader()
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

         fun id(url: String?): String? {
            return url?.substringAfter('=')?.substringBefore('&')
        }
         fun filename(url: String?): String {
            return downloader().getVideo(id(url)).details().title().substringBefore('|')
        }
        fun filepath(url: String?, path: String?): String {
            return "${path}/${filename(url)}"
        }
        fun videoWithAudio(url: String?, path: String?): Future<File>? {
            val videoid = downloader().getVideo(id(url))
            return videoid.downloadAsync(videoid.videoWithAudioFormats()[0],
                File(filepath(url, path)),
                object : OnYoutubeDownloadListener {
                    override fun onDownloading(p0: Int) {
                        runBlocking {
                            launch {
                                //
                                txt.text = p0.toString()
                            }.start()
                        }
                        println("$p0%")
                    }
                    override fun onFinished(p0: File?) {
                    }
                    override fun onError(p0: Throwable?) {
                        alert(Alert.AlertType.ERROR, p0?.localizedMessage.toString())
                    }
                })
        }
    }
