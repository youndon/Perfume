package com.example.demo.box

import javafx.scene.control.ProgressBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hyperic.jni.ArchName
import org.hyperic.sigar.*
import tornadofx.observable
import tornadofx.useMaxWidth
import java.awt.Toolkit
import java.net.InetAddress

sealed class Monitor {

    companion object{
        val sigar = Sigar()
        val userPath = System.getProperty("user.path")
    }
    object SWAP {
        fun total(): Long = (sigar.swap.total)
        fun used(): Long = (sigar.swap.used)
        fun free(): Long = (sigar.swap.free)
        fun freePerc() = (free().toDouble() * 100) / total()
        fun usedPerc() = (used().toDouble() * 100) / total()
        // format.
        fun totalF() = Sigar.formatSize(total())
        fun freeF() = Sigar.formatSize(free())
        fun usedF() = Sigar.formatSize(used())
    }

    object MEM {
        fun total(): Long = (sigar.mem.total)
        fun totalF(): String = Sigar.formatSize(sigar.mem.total)
        fun used(): String? = Sigar.formatSize(sigar.mem.used)
        fun actualUsed(): Long = (sigar.mem.actualUsed)
        fun actualUsedPerc(): Double = (actualUsed() * 100).toDouble() / total()
        fun usedPercent() = sigar.mem.usedPercent
        fun free(): Long = (sigar.mem.free)
        fun actualFree(): Long = (sigar.mem.actualFree)
        fun actualFreePerc(): Double = (actualFree() * 100).toDouble() / total()
        fun freePercent() = sigar.mem.freePercent
        fun ram(): String? {
            return Sigar.formatSize(sigar.mem.ram)
        }
    }

    object NETWORK {
        fun totalDownloads() = sigar.getNetInterfaceStat(sigar.netInterfaceList[1]).rxBytes
        fun totalDownloadsF() = Sigar.formatSize(sigar.getNetInterfaceStat(sigar.netInterfaceList[1]).rxBytes)
        fun totalUploads() = sigar.getNetInterfaceStat(sigar.netInterfaceList[1]).txBytes
        fun totalUploadsF() = Sigar.formatSize(sigar.getNetInterfaceStat(sigar.netInterfaceList[1]).txBytes)

        fun traffic(): Pair<Long, Long> {
            var beforeLastDown: Long;
            var lastDown = 0L
            var beforeLastUp: Long;
            var lastUp = 0L
            runBlocking {
                launch {
                    beforeLastDown = totalDownloads(); beforeLastUp = totalUploads()
                    delay(1000)
                    lastDown = totalDownloads() - beforeLastDown; lastUp = totalUploads() - beforeLastUp
                }.start()
            }
            return Pair(lastDown,lastUp)
        }
        fun info() {
            sigar.netInfo.toMap()
        }
    }

    object CPU {
        fun coresN(): Int {
            return sigar.cpuInfoList[0].totalCores
        }
        fun dr(index: Int): Double? {
            try {
                return (sigar.cpuPercList[index].user) * 100
            } catch (ex:Exception){
                ex.localizedMessage
            }
            return null
        }
        fun combined(): CpuPerc = sigar.cpuPerc
        fun info(): CpuInfo? {
            return sigar.cpuInfoList[0]
        }
    }
    data class AA(val dev: String?,val dir:String?,val type:String?,val total:String?,val used:String?,val free:String?,val files:Long?,val perc:String?,val progressBar: ProgressBar?)
    object FILE {
        val fileSys = arrayListOf<AA>().observable()
        init {
            sigar.fileSystemList.forEach { it ->
                try {
                    val cc = sigar.getFileSystemUsage(it.dirName)
                    fileSys.add(
                        AA(
                            it.devName,
                            it.dirName,
                            it.sysTypeName,
                            Sigar.formatSize(cc.total * 1024),
                            Sigar.formatSize(cc.used * 1024),
                            Sigar.formatSize(cc.free * 1024),
                            cc.files,
                            "${cc.usePercent * 100}%",
                            ProgressBar(cc.usePercent)
                        )
                    )
                } catch (er: Exception) {
                }
            }
        }
    }
    object OS_INFO{
        // User
        val hostName = InetAddress.getLocalHost().hostName
        val userName = System.getenv("USER")
        // OS name
        val os = OperatingSystem.getInstance().name
        // Description
        val description = OperatingSystem.getInstance().vendor
        // Version
        val version = OperatingSystem.getInstance().vendorVersion
        // Kernel
        val kernel = OperatingSystem.getInstance().version
        // Arch -> 64bit
        val archName = ArchName.getName()
        // DE -> gnome
        val de = System.getenv("XDG_MENU_PREFIX").toUpperCase()
        // UpTime
        fun upTime() {

        }
        // Language
        val lang = System.getenv("LANGUAGE")
        // WindowingSystem -> x11
        val ws = System.getenv("XDG_SESSION_TYPE")
        // Home
        val home = System.getenv("HOME")
        // Host
        //CPU
        fun cpu(): String {
            val cc = Typography.times
            val ve = sigar.cpuInfoList[0].vendor
            val mod = sigar.cpuInfoList[0].model
            val mhz = sigar.cpuInfoList[0].mhz
            val cor = sigar.cpuInfoList[0].totalCores
            return "$ve $mod $mhz $cc ($cor)"
        }
        //GPU
        // Resolution
        fun resolution(): String {
            val ss = Toolkit.getDefaultToolkit()
            val cc = Typography.times
            return "${ss.screenSize.width}$cc${ss.screenSize.height}"
        }
        //RAM
        // Disk Capacity

        // DNS
        val dns = sigar.netInfo.defaultGateway

        // NetMask
        val netmask = sigar.netInterfaceConfig.netmask

        // Hardware Address
        val hwaddr = sigar.netInterfaceConfig.hwaddr

        // IPv4
        val address = sigar.netInterfaceConfig.address
    }
}
