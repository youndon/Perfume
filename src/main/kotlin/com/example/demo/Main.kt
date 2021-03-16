import com.example.demo.box.Monitor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hyperic.sigar.Sigar

fun main() {

    System.setProperty("java.library.path", "/usr/lib64/")


    runBlocking {
        launch {
            println(Monitor.CPU.`core 1`())
            delay(70)
            println(Monitor.CPU.`core 2`())
            delay(70)
            println(Monitor.CPU.`core 3`())
            delay(70)
            println(Monitor.CPU.`core 4`())
            delay(70)
        }.start()

    }

}