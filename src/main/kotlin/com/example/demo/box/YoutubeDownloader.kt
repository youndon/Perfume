package com.example.demo.box

import com.github.kiulian.downloader.OnYoutubeDownloadListener
import com.github.kiulian.downloader.YoutubeDownloader
import com.github.kiulian.downloader.model.Extension
import com.github.kiulian.downloader.model.quality.AudioQuality
import com.github.kiulian.downloader.model.quality.VideoQuality
import dorkbox.notify.Notify
import dorkbox.notify.Pos
import javafx.application.Platform
import javafx.scene.control.Alert
import javafx.scene.control.ProgressBar
import javafx.scene.text.Text
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hyperic.sigar.Sigar
import tornadofx.alert
import java.io.File
import java.net.URL
import java.util.*
import java.util.concurrent.Future
import javax.imageio.ImageIO
import kotlin.concurrent.thread

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class YoutubeDownloader {

    private fun id(url: String?): String? {
        return url?.substringAfter('=')?.substringBefore('&')
    }
    fun downloader(): YoutubeDownloader {
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


    private fun filename(url: String?): String? {
        try{
//            val title = downloader().getVideo(id(url)).details().title()
            return "..."
        }catch (ex:Exception){
            println(ex.localizedMessage)
        }
        return null
    }

    fun filepath(url: String?, path: String?): String? {
        try{

            return "${path}/${filename(url)}"
        }catch (ex:Exception){

        }
        return null
    }

   fun videoWithAudio(url: String?, path: String?,progressBar: ProgressBar?,text: Text?): Future<File>? {
        val down = downloader().getVideo(id(url)).downloadAsync(downloader().getVideo(id(url)).videoWithAudioFormats()[0],
            File(filepath(url, path)),
            object : OnYoutubeDownloadListener {
                override fun onDownloading(p0: Int) {
                    thread {
                        Platform.runLater {
                            progressBar?.progress = p0.toDouble()/100
                        }
                        text?.text = "progressing... $p0%"
                        Thread.sleep(200)
                    }
                }
                override fun onFinished(p0: File?) {
                    text?.text = "Complete"
                }
                override fun onError(p0: Throwable?) {
                    alert(Alert.AlertType.ERROR, p0?.localizedMessage.toString())
                }
            })
       try{
           return down
       }catch (ex:Exception){
           println(ex.localizedMessage)
       }
       return null
    }

    fun videoListQuality(url:String?): Map<VideoQuality, String>? {
       val map = mutableMapOf<VideoQuality,String>()
        downloader().getVideo(id(url)).videoFormats().forEach {
            map.plusAssign(it.videoQuality() to Sigar.formatSize((it.bitrate()*8).toLong()))
        }
        try{
            return map

        }catch (ex:Exception){

        }
        return null
    }

    fun videoQuality(url: String?, path: String?, quality:VideoQuality,text: Text?,progressBar: ProgressBar?): Future<File>? {
        val videoid = downloader().getVideo(id(url))
        try{
        return videoid.downloadAsync(videoid.findVideoWithQuality(quality)[0],
            File(filepath(url, path)),
            object : OnYoutubeDownloadListener {
                override fun onDownloading(p0: Int) {
                    runBlocking {
                        launch {
                            text?.text = "$p0%"
                            progressBar?.progress = p0.toDouble()/100
                        }.start()
                    }
                }
                override fun onFinished(p0: File?) {
                    text?.text = "Complete"
                }
                override fun onError(p0: Throwable?) {
                    alert(Alert.AlertType.ERROR, p0?.localizedMessage.toString())
                }
            })
        }catch (ex:Exception){

        }
        return null
    }

    fun audioListQuality(url: String?): MutableMap<AudioQuality, String>? {
        val map = mutableMapOf<AudioQuality,String>()
        downloader().getVideo(id(url)).audioFormats().forEach {
            map.plusAssign(it.audioQuality() to Sigar.formatSize((it.bitrate()*8).toLong()))
        }
        try{
            return map

        }catch (ex:Exception){

        }
        return null
    }

    fun audioQuality(url: String?, path: String?, quality: AudioQuality,text: Text?,progressBar: ProgressBar?): Future<File>? {
        val videoid = downloader().getVideo(id(url))
        try {
            return videoid.downloadAsync(videoid.findAudioWithQuality(quality)[0],
                File(filepath(url, path)),
                object : OnYoutubeDownloadListener {
                    override fun onDownloading(p0: Int) {
                        runBlocking {
                            launch {
                                text?.text = "$p0%"
                                progressBar?.progress = p0.toDouble() / 100
                            }.start()
                        }
                    }

                    override fun onFinished(p0: File?) {
                        text?.text = "Complete"
                    }

                    override fun onError(p0: Throwable?) {
                        alert(Alert.AlertType.ERROR, p0?.message.toString())
                    }
                })
        } catch (ex: Exception) {

        }
        return null
    }
    fun thumbnails(url: String?, path: String?): Boolean? {
        val img = ImageIO.read(URL("${downloader().getVideo(id(url)).details().thumbnails()[0]}.jpg"))
        val file = File("${filepath(url, path)}/${filename(url)}.jpg")
        try{
            return ImageIO.write(img, "jpg", file)

        }catch (ex:Exception){

        }
        return null
    }

    fun details(url: String?): ArrayList<String>? {
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
        try{

            return list
        }catch (ex:Exception){

        }
        return null
    }

    fun allSubtitles(url: String?, path: String?) {
        val file = "${filepath(url, path)}/Subtitles"
        try{
            return downloader().getVideoSubtitles(id(url)).forEach { subInfo ->
                subInfo.subtitles
                    .formatTo(Extension.WEBVTT)
                    .download().also {
                        File(file).mkdir()
                        File(file + "/${subInfo.language}.vtt").run {
                            this.createNewFile()
                            this.appendText(it)
                        }
                    }
            }
        }catch (ex:Exception){

        }

    }

    fun ccList(url: String?): ArrayList<String>? {
        val list = arrayListOf<String>()
        downloader().getVideoSubtitles(id(url)).forEach {
            list.add(it.language)
        }
        try{
            return list

        }catch (ex:Exception){

        }
        return null
    }

    fun cc(url: String?, path: String?,index:Int?) {
        val file = filepath(url, path)
        try{
            downloader().getVideoSubtitles(id(url))[index!!].run {
                this.subtitles
                    .formatTo(Extension.WEBVTT)
                    .download().also {
                        File(file).mkdir()
                        File("$file/${this.language}.vtt").run {
                            this.createNewFile()
                            this.appendText(it)
                        }
                    }
            }
        }catch (ex:Exception){

        }

    }

    private fun notification(): Notify? {
        return Notify.create()
            .darkStyle()
            .position(Pos.TOP_RIGHT)
            .text("Downloaded filename is complete!")
            .title("KYD")
    }

    private fun fileSize(bit:Int): String {
        val kibibit = bit / 1024
        val mibibit = bit / 1048576
        val gibibit = bit / 1073742000
       return when{
           bit>=1024 -> "$kibibit Kb"
           bit>=1048576 -> "$mibibit Mb"
           bit>=1073742000 -> "$gibibit Gb"
           else -> "$bit Bit"
       }
    }

}