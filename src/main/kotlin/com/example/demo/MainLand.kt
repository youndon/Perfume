package com.example.demo.view

import com.example.demo.box.Monitor
import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.scene.chart.*
import javafx.util.Duration
import tornadofx.*
import javafx.collections.FXCollections
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.LineChart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hyperic.sigar.Sigar

fun main() = launch<MainLand>()
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    var traffic = LineChart(NumberAxis(), NumberAxis(), FXCollections.observableArrayList())
    var cpuCombined = LineChart(NumberAxis(), NumberAxis(), FXCollections.observableArrayList())
    var cpu = LineChart(NumberAxis(), NumberAxis(), FXCollections.observableArrayList())
    var mem = PieChart()
    var swap = PieChart()
    var lisDown = (0L..60L).toList() as ArrayList
    var lisUp = (0L..60L).toList() as ArrayList
    var down = arrayListOf(0L)
    var up = arrayListOf(0L)
    var lisCpu = arrayListOf(
        (0L..60L).toList() as ArrayList<Double>,
        (0L..60L).toList() as ArrayList<Double>,
        (0L..60L).toList() as ArrayList<Double>,
        (0L..60L).toList() as ArrayList<Double>
    )
    override val root = tabpane {
        tab("Network") {
            traffic = linechart(
                "Traffic | Total Down:${(Monitor.NETWORK.totalDownloads())} | Total Up:${(Monitor.NETWORK.totalUploads())}",
                NumberAxis(), NumberAxis()
            )
            tab("RAM/SWAP") {
                borderpane {
                    right {
                        mem = piechart("RAM | ${Monitor.MEM.totalF()}")
                    }
                    left {
                        swap = piechart("SWAP | ${Monitor.SWAP.totalF()}")
                    }
                }
            }
            tab("CPU") {
                borderpane {
                    center {
                        cpu = linechart(
                            "CPU | core",
                            NumberAxis(), NumberAxis()
                        )
                    }
                }
            }

            val cc = Timeline(
                KeyFrame(Duration.ZERO, {
                    // traffic
                    traffic.data.clear()
                    traffic.animated = false
                    traffic.series("Downloads(${(lisDown.last())})") {
                        lisDown.withIndex().forEach {
                            data(it.index, it.value)
                        }
                    }
                    traffic.series("Uploads(${(lisUp.last())})") {
                        lisUp.withIndex().forEach {
                            data(it.index, it.value)
                        }
                    }
                    down.plusAssign(Monitor.NETWORK.totalDownloads())
                    up.plusAssign(Monitor.NETWORK.totalUploads())

                    lisDown.add(down.last() - down.first())
                    lisUp.add(up.last() - up.first())
                    down.removeAt(0)
                    up.removeAt(0)
                    lisDown.removeAt(0)
                    lisUp.removeAt(0)


                    // MEM
                    mem.data.clear()
                    mem.animated = false
                    mem.data(
                        "used(${"%.2f".format(Monitor.MEM.actualUsedPerc())})%",
                        Monitor.MEM.actualUsed().toDouble()
                    )
                    mem.data(
                        "free(${"%.2f".format(Monitor.MEM.actualFreePerc())})%",
                        Monitor.MEM.actualFree().toDouble()
                    )

                    // SWAP
                    swap.data.clear()
                    swap.animated = false
                    swap.data("used(${"%.2f".format(Monitor.SWAP.usedPerc())})%", Monitor.SWAP.usedPerc())
                    swap.data("used(${"%.2f".format(Monitor.SWAP.freePerc())})%", Monitor.SWAP.freePerc())

                    // CUP
                    cpu.data.clear()
                    cpu.animated = false
                    cpu.run {
                        (1..Monitor.CPU.cores()).withIndex().forEach { core ->
                            series("cpu${core.value}(${Monitor.CPU.cpulis(core.index)}%)") {
                                lisCpu[core.index].withIndex().forEach {
                                    data(it.index, it.value)
                                }
                            }
                            lisCpu[core.index].add((Monitor.sigar.cpuPercList[core.index].user) * 100)
                            lisCpu[core.index].removeAt(0)
                        }
                    }
                }),
                KeyFrame(Duration.seconds(1.0))
            )
            cc.cycleCount = Animation.INDEFINITE
            cc.play()
        }
    }
}
