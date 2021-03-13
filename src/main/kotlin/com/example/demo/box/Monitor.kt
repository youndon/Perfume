package com.example.demo.box

import org.hyperic.sigar.CpuInfo
import org.hyperic.sigar.CpuPerc
import org.hyperic.sigar.Sigar
import tornadofx.ItemViewModel
import kotlin.concurrent.thread

sealed class Monitor {
    companion object{
        val sigar = Sigar()
    }
    object SWAP {
        fun total(): String = Sigar.formatSize(sigar.swap.total)
        fun used(): String = Sigar.formatSize(sigar.swap.used)
        fun free(): String = Sigar.formatSize(sigar.swap.free)
    }

    object MEM {
        fun total(): String = Sigar.formatSize(sigar.mem.total)
        fun used(): String = Sigar.formatSize(sigar.mem.used)
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

class MonitorModel : ItemViewModel<Monitor>() {}
