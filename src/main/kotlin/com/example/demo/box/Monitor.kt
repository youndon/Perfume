package com.example.demo.box

import dyorgio.runtime.run.`as`.root.RootExecutor
import javafx.scene.control.ProgressBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hyperic.jni.ArchName
import org.hyperic.sigar.*
import tornadofx.observable
import java.awt.Toolkit
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.InetAddress
import java.nio.file.Paths

sealed class Monitor {

    companion object {
        val sigar = Sigar()
        val userPath = System.getProperty("user.path")
        val shell = System.getenv("SHELL")
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
            return Pair(lastDown, lastUp)
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
            } catch (ex: Exception) {
                ex.localizedMessage
            }
            return null
        }

        fun combined(): CpuPerc = sigar.cpuPerc
        fun info(): CpuInfo? {
            return sigar.cpuInfoList[0]
        }
    }

    data class FT(
        val dev: String?,
        val dir: String?,
        val type: String?,
        val total: String?,
        val used: String?,
        val free: String?,
        val files: Long?,
        val perc: String?,
        val progressBar: ProgressBar?
    )

    object FILE {
        val fileSys = arrayListOf<FT>().observable()
        init {
            sigar.fileSystemList.forEach { it ->
                try {
                    val cc = sigar.getFileSystemUsage(it.dirName)
                    fileSys.add(
                        FT(
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

    data class PR(
        val name:String?,
        val user:String?,
        val group:String?,
        val state:String?,
        val processor:Int?,
        val size:String?,
        val resident:String?,
        val share:String?,
        val cpu:Double?,
        val time:Long?,
        val nice:Int?,
        val commandLine :MutableList<Any?>?,
        val path:MutableMap<Any?,Any?>?
    )
    object PROCESSOR {
        val processor = arrayListOf<PR>().observable()
        init {
            sigar.procList.forEach {
                try {
                    processor.add(
                        PR(
                            sigar.getProcState(it).name,
                            sigar.getProcCredName(it).user,
                            sigar.getProcCredName(it).group,
                            sigar.getProcState(it).state.toString(),
                            sigar.getProcState(it).processor,
                            Sigar.formatSize(sigar.getProcMem(it).size),
                            Sigar.formatSize(sigar.getProcMem(it).resident),
                            Sigar.formatSize(sigar.getProcMem(it).share),
                            sigar.getProcCpu(it).percent,
                            sigar.getProcTime(it).startTime,
                            sigar.getProcState(it).nice,
                            sigar.getProcModules(it),
                            sigar.getProcEnv(it)
                        )
                    )
                } catch (ex: Exception) {

                }
            }
        }
    }
    object OS_INFO {
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
        fun upTime(): StringBuffer {
            return this.command("uptime")
        }

        // Language
        val lang = System.getenv("LANGUAGE")

        // WindowingSystem -> x11
        val ws = System.getenv("XDG_SESSION_TYPE")

        // Home
        val home = System.getenv("HOME")

        //CPU
        fun cpu(): String {
            val cc = Typography.times
            val ve = sigar.cpuInfoList[0].vendor
            val mod = sigar.cpuInfoList[0].model
            val mhz = sigar.cpuInfoList[0].mhz
            val cor = sigar.cpuInfoList[0].totalCores
            return "$ve $mod $mhz $cc ($cor)"
        }

        // Resolution
        fun resolution(): String {
            val ss = Toolkit.getDefaultToolkit()
            val cc = Typography.times
            return "${ss.screenSize.width}$cc${ss.screenSize.height}"
        }

        // DNS
        val dns = sigar.netInfo.defaultGateway

        // NetMask
        val netmask = sigar.netInterfaceConfig.netmask

        // Hardware Address
        val hwaddr = sigar.netInterfaceConfig.hwaddr

        // IPv4
        val address = sigar.netInterfaceConfig.address

        fun command(command: String): StringBuffer {
            System.setProperty("java.io.tmpdir", "/home/yon/")
            return RootExecutor("-Xmx64m").call {
                val pb = Runtime.getRuntime().exec(arrayOf(shell, "-c", command))
                val ss = StringBuffer()
                var line: String?
                val input = BufferedReader(InputStreamReader(pb.inputStream))
                while (input.readLine().also { line = it } != null) {
                    ss.appendln(line)
                }
                input.close()
                return@call ss
            }
        }
    }
}
