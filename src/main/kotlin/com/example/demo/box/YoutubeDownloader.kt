package com.example.demo.box

import com.github.kiulian.downloader.OnYoutubeDownloadListener
import com.github.kiulian.downloader.YoutubeDownloader
import com.github.kiulian.downloader.model.Extension
import com.github.kiulian.downloader.model.quality.AudioQuality
import com.github.kiulian.downloader.model.quality.VideoQuality
import com.github.kiulian.downloader.model.subtitles.SubtitlesInfo
import javafx.collections.ObservableList
import javafx.scene.control.Alert
import tornadofx.alert
import tornadofx.observable
import java.io.File
import java.net.URL
import java.util.*
import java.util.concurrent.Future
import javax.imageio.ImageIO

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class YoutubeDownloader (){

     fun id(url:String?): String? {
        return url?.substringAfter('=')?.substringBefore('&')
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

    fun filepath(url: String?,path:String?): String {
        return "${path}/${filename(url)}"
    }

    private fun filename(url:String?): String {
        return downloader().getVideo(id(url)).details().title().substringBefore('|')
    }

    fun videoWithAudio(url:String?,path: String?): Future<File>? {
        val videoid = downloader().getVideo(id(url))
        return videoid.downloadAsync(videoid.videoWithAudioFormats()[0],
            File(filepath(url,path)),
            object : OnYoutubeDownloadListener {
                override fun onDownloading(p0: Int) {
                    println("$p0%")
                }
                override fun onFinished(p0: File?) {
                    println("Done!")
                }
                override fun onError(p0: Throwable?) {
                    alert(Alert.AlertType.ERROR, p0?.localizedMessage.toString())
                }
            })
    }

    fun videoOnly(url:String?,path: String?): Future<File>? {
        val videoid = downloader().getVideo(id(url))
        return videoid.downloadAsync(videoid.findVideoWithQuality(VideoQuality.highres)[0],
            File(filepath(url,path)),
            object : OnYoutubeDownloadListener {
                override fun onDownloading(p0: Int) {
                    println("$p0%")
                }
                override fun onFinished(p0: File?) {
                    println("Done!")
                }
                override fun onError(p0: Throwable?) {
                    alert(Alert.AlertType.ERROR, p0?.localizedMessage.toString())
                }
            })
    }

     fun audioOnly(url:String?,path: String?): Future<File>? {
        val videoid = downloader().getVideo(id(url))
        return videoid.downloadAsync(videoid.findAudioWithQuality(AudioQuality.medium)[0],
            File(filepath(url,path)),
            object : OnYoutubeDownloadListener {
                override fun onDownloading(p0: Int) {
                    println("$p0%")
                }
                override fun onFinished(p0: File?) {
                    println("Done!")
                }
                override fun onError(p0: Throwable?) {
                    alert(Alert.AlertType.ERROR, p0?.message.toString())
                }
            })
    }

     fun allSubtitles(url:String?,path: String?){
        val file = "${filepath(url,path)}/Subtitles"
        return downloader().getVideoSubtitles(id(url)).forEach { subInfo ->
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

    fun cc(url:String?,path: String?) {
        val dd = downloader().getVideoSubtitles("")[0]
        val file = "${filepath(url, path)}/Subtitles"
        dd.subtitles.formatTo(Extension.WEBVTT)
            .download().also {
                File(file).mkdir()
                File("$file/sub.vtt").run {
                    this.createNewFile()
                    this.appendText(it)
                }
            }
    }

    fun cclist(url:String?): ArrayList<String> {
        val list = arrayListOf<String>()
        downloader().getVideoSubtitles(id(url)).forEach { it ->
            list.add(it.language)
        }
        return list
    }

    fun thumbnails(url:String?,path:String?): Boolean {
        val img = ImageIO.read(URL("${downloader().getVideo(id(url)).details().thumbnails()[0]}.jpg"))
        val file = File("${filepath(url,path)}/${filename(url)}.jpg")
        return ImageIO.write(img, "jpg", file)
    }

    fun details(url:String?): ArrayList<String> {
        val list = arrayListOf<String>()
        downloader().getVideo(id(url)).details().run {
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