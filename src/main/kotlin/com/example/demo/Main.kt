import com.example.demo.view.YDQ
import com.github.kiulian.downloader.YoutubeDownloader
import com.github.kiulian.downloader.model.Extension
import javafx.event.ActionEvent
import javafx.event.EventHandler
import java.io.File

fun main() {

    // //https://www.youtube.com/watch?v=3F2NeH_-f34
    // youtube.com/channel/UCAQg09FkoobmLquNNoO4ulg
    // https://www.youtube.com/watch?v=2EKEsvSbaPU


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


}

    //

