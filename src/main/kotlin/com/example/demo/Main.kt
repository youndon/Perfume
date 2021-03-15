import com.example.demo.box.Monitor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hyperic.sigar.Sigar

fun main() {

    System.setProperty("java.library.path","/usr/lib64/")

    while (true){
        runBlocking {
            launch {
                println(
                    Monitor.CPU.cpulis(4)
                )
                delay(600)
            }.start()
        }
    }
}