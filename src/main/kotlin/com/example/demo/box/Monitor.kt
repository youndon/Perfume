package com.example.demo.box

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.objecthunter.exp4j.ExpressionBuilder
import org.hyperic.sigar.CpuInfo
import org.hyperic.sigar.CpuPerc
import org.hyperic.sigar.Sigar

sealed class Monitor {
    companion object{
        val sigar = Sigar()
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
        fun cores(): Int {
            return sigar.cpuInfoList[0].totalCores
        }

        fun combined(): CpuPerc = sigar.cpuPerc

        fun info(): CpuInfo? {
            return sigar.cpuInfoList[0]
        }
    }
}
