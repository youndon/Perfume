import com.example.demo.box.Monitor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hyperic.sigar.Sigar

fun main() {

    System.setProperty("java.library.path","/usr/lib64/")
    (0..3).forEach {
        println("${Monitor.CPU.cpulis(it)}")

    }
}