import com.example.demo.box.Monitor
import dyorgio.runtime.run.`as`.root.RootExecutor
import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager
import net.samuelcampos.usbdrivedetector.USBStorageDevice
import net.samuelcampos.usbdrivedetector.events.DeviceEventType
import net.samuelcampos.usbdrivedetector.events.USBStorageEvent
import org.hyperic.sigar.Sigar
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import javax.activation.FileTypeMap
import kotlin.concurrent.thread

fun main() {
//        HashCodeBuilder.reflectionHashCode("")


    // system, bus, generic, network, display, bridge,multimedia, storage, disk, volume,power, input ,communication,processor ,memory

    System.setProperty("java.library.path","/usr/lib64")
    println("uptime: ${Monitor.OS_INFO.upTime()}")


}



