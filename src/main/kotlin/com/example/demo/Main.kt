import dyorgio.runtime.run.`as`.root.RootExecutor
import java.io.File
import javax.activation.FileTypeMap
import kotlin.concurrent.thread

fun main() {
//        HashCodeBuilder.reflectionHashCode("")
//    System.setProperty("java.library.path", "/usr/lib64/")

//    val cmd = arrayOf("/bin/bash", "-c", "echo password | sudo -S ls")
//    val pb = Runtime.getRuntime().exec(cmd)
//    var line: String?
//    val input = BufferedReader(InputStreamReader(pb.inputStream))
//    while (input.readLine().also { line = it } != null) {
//        println(line)
//    }
//    input.close()

    System.setProperty("java.io.tmpdir", "/home/yon/temp")
    try {
    RootExecutor("-Xmx64m").run {
        println("...")
}
    }catch (ex:Exception){
        println(ex.localizedMessage)
    }
}



