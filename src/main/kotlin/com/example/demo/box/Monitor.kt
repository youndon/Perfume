package com.example.demo.box

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hyperic.sigar.CpuInfo
import org.hyperic.sigar.CpuPerc
import org.hyperic.sigar.Sigar
import tornadofx.ItemViewModel
import java.util.ArrayList
import kotlin.concurrent.thread

sealed class Monitor {
    companion object{
        val sigar = Sigar()
    }
    object SWAP {
        fun total(): String = Sigar.formatSize(sigar.swap.total)
        fun used(): Long = (sigar.swap.used)
        fun free(): Long = (sigar.swap.free)
    }

    object MEM {
        fun total(): String = Sigar.formatSize(sigar.mem.total)
        fun used(): Long = sigar.mem.used
        fun actualUsed(): String = Sigar.formatSize(sigar.mem.actualUsed)
        fun usedPercent() = sigar.mem.usedPercent
        fun free(): Long = (sigar.mem.free)
        fun actualFree(): String = Sigar.formatSize(sigar.mem.actualFree)
        fun freePercent() = sigar.mem.freePercent
        fun ram(): String? {
            return Sigar.formatSize(sigar.mem.ram)
        }
    }

    object NETWORK {
        fun totalDownloads() = sigar.getNetInterfaceStat(sigar.netInterfaceList[1]).rxBytes
        fun totalUploads() = sigar.getNetInterfaceStat(sigar.netInterfaceList[1]).txBytes

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
        fun cpu1() = try {
            sigar.cpuPercList[0].toString().slice(11..16)
        } catch (ex: Exception) {
            "No!"
        }

        fun cpu2() = try {
            sigar.cpuPercList[1].toString().slice(11..16)
        } catch (ex: Exception) {
            "No!"
        }

        fun cpu3() = try {
            sigar.cpuPercList[2].toString().slice(11..16)
        } catch (ex: Exception) {
            "No!"
        }

        fun cpu4() = try {
            sigar.cpuPercList[3].toString().slice(11..16)
        } catch (ex: Exception) {
            "No!"
        }

        fun cpu5() = try {
            sigar.cpuPercList[4].toString().slice(11..16)
        } catch (ex: Exception) {
            "No!"
        }

        fun cpu6() = try {
            sigar.cpuPercList[5].toString().slice(11..16)
        } catch (ex: Exception) {
            "No!"
        }
        fun combined(): CpuPerc = sigar.cpuPerc

        fun info(): CpuInfo? {
            return sigar.cpuInfoList[0]
        }
    }
}
