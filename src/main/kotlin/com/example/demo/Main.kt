package com.example.demo

import com.github.kiulian.downloader.OnYoutubeDownloadListener
import com.github.kiulian.downloader.YoutubeDownloader
import com.github.kiulian.downloader.model.Extension
import com.github.kiulian.downloader.model.quality.AudioQuality
import com.github.kiulian.downloader.model.quality.VideoQuality
import java.io.File
import java.util.function.Consumer


fun main() {
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

    // parsing data:
    val video = downloader.getVideo("sVPYIRF9RCQ")

    // video details:
    video.details().run {
        println("title: "+title())
        println("viewCount: "+viewCount())
        println("author: " + author())
        this.keywords().forEach {
            println("keywords: $it")
        }
        println("lengthSeconds: "+lengthSeconds())
        println("id: "+videoId())
        println("averageRating: "+averageRating())
        println("description: "+description())
        println("isLive: $isLive")
        println("isLiveContent: $isLiveContent")
        this.thumbnails().forEach {
            println("thumbnails: $it")
        }
    }

    // get video with audio:
    val audioVF = video.videoWithAudioFormats()
    audioVF.forEach {
    }

    // filtering only video formats
    val audioF = video.findAudioWithQuality(AudioQuality.medium)
    audioF.forEach(Consumer {
        println("${it.audioQuality()} : ${it.url()}")
    })

    // itags can be found here - https://gist.github.com/sidneys/7095afe4da4ae58694d128b1034e01e2
//    val formatByItag = video.findFormatByItag(136)
//    formatByItag?:println(formatByItag?.url())

    val outputDir = File("/home/yon/")
    val format = audioVF[0]

    // sync downloading:
    val file = video.download(format,outputDir)
    println(video.subtitles())

    // async downloading with callback
    val future = video.downloadAsync(audioF[0], outputDir, object : OnYoutubeDownloadListener {
        override fun onDownloading(progress: Int) {
            println("Downloaded %d%%".format(progress))
        }
        override fun onFinished(file: File) {
            println("Finished file: $file")
        }
        override fun onError(throwable: Throwable) {
            println("Error: " + throwable.localizedMessage)
        }
    }).get()
/**
    // async downloading without callback
//    val future = video.downloadAsync(format, outputDir)
//    future.get(100, TimeUnit.DAYS)

// cancel downloading
//    future.cancel(true); // true is required to interrupt downloading thread

    // live videos and streams
    if (video.details().isLive) {
        println("Live Stream HLS URL: " + video.details().liveUrl())
    }

    // naming
// by default file name will be same as video title on youtube,
// but you can specify output file name
    val myAwesomeFile0 = video.download(format, outputDir, "myAwesomeName")
    println(file.name) // myAwesomeName.mp4

// if file with such name already exits sufix will be added myAwesomeFile(1).mp4
// you may disable this feature by passing overwrite flag
    val myAwesomeFile1 = video.download(format, outputDir, "myAwesomeName", true)

    // subtitles
// you can get subtitles from video captions if you have already parsed video meta
    val subtitles0 = video.subtitles() // NOTE: includes auto-generated

// if you don't need video meta, but just subtitles use this instead
    val subtitles1 = downloader.getVideoSubtitles("") // NOTE: does not include auto-generated

    subtitles0.forEach {
        val subtitles = it.subtitles
            .formatTo(Extension.JSON3)
            .translateTo("uk")
        // sync download
        val subtitlesData = subtitles.download()
        // async download
        val subtitlesFuture = subtitles.downloadAsync() // optional
        // to download using external download manager
        val downloadUrl = subtitles.downloadUrl
    }

    // playlists

// parsing data
    val playlist = downloader.getPlaylist(video.details().videoId())

// playlist details
    val details = playlist.details()
    println(details.title())
    println(details.videoCount())

    // get video details
    val videoDetails = playlist.videos()[0]
    println(videoDetails.title())
    println(videoDetails.index())

// get video
    val video1 = downloader.getVideo(videoDetails.videoId())
    */

}