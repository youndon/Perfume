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

fun main() = launch<MainLand>()
class MainLand:App(ViewLand::class)

class ViewLand:UIComponent() {
    var traffic = LineChart(NumberAxis(), NumberAxis(), FXCollections.observableArrayList())
    var cpuCombined = LineChart(NumberAxis(), NumberAxis(), FXCollections.observableArrayList())
    var cpu = LineChart(NumberAxis(), NumberAxis(), FXCollections.observableArrayList())
    var mem = PieChart()
    var swap = PieChart()
    var lisDown = (0L..10L).toList() as ArrayList
    var lisUp = (0L..10L).toList() as ArrayList
    var down = arrayListOf(0L)
    var up = arrayListOf(0L)
    override val root = tabpane {
        tab("Network") {
            traffic = linechart("Traffic", NumberAxis(), NumberAxis())
        }
        tab("RAM/SWAP") {
            borderpane {
                right {
                    mem = piechart("RAM")
                }
                left {
                    swap = piechart("SWAP")
                }
            }
        }
        tab("CPU") {
            borderpane {
                top{
                    cpu = linechart("CPU", NumberAxis(), NumberAxis())
                }
                bottom {
                    cpuCombined = linechart("CPU_Combined", NumberAxis(), NumberAxis())
                }
            }
        }

        val cc = Timeline(
            KeyFrame(Duration.ZERO, {
                // traffic
                traffic.data.clear()
                traffic.animated = false
                traffic.series("downloads") {
                    lisDown.withIndex().forEach {
                       data(it.index, it.value)
                    }
                }
                traffic.series("uploads") {
                    lisUp.withIndex().forEach {
                        data(it.index, it.value)
                    }
                }
                down.plusAssign(Monitor.NETWORK.totalDownloads())
                up.plusAssign(Monitor.NETWORK.totalUploads())

                lisDown.add(down.last()-down.first())
                lisUp.add(down.last()-down.first())
                down.removeAt(0)
                up.removeAt(0)
                lisDown.removeAt(0)
                lisUp.removeAt(0)



                // MEM
                mem.data.clear()
                mem.animated = false
                mem.data("used(${"%.2f".format(Monitor.MEM.usedPercent())})%", Monitor.MEM.usedPercent())
                mem.data("free(${"%.2f".format(Monitor.MEM.freePercent())})%", Monitor.MEM.freePercent())

                // SWAP
                swap.data.clear()
                swap.animated = false
                swap.data("used(${Monitor.SWAP.used()})", Monitor.SWAP.used().toDouble())
                swap.data("free(${Monitor.SWAP.free()})", Monitor.SWAP.free().toDouble())

                // CUP
                cpu.data.clear()
                cpu.animated = false
                cpu.series("...") {
                    (0..50).forEach {
                        data((0..50).random(), (0..100).random())
                    }
                }
                // CPU_Combined
                cpuCombined.data.clear()
                cpuCombined.animated = false
                cpuCombined.series("...") {
                    (0..50).forEach {
                        data((0..50).random(), (0..100).random())
                    }
                }
            }),
            KeyFrame(Duration.seconds(1.0))
        )
        cc.cycleCount = Animation.INDEFINITE
        cc.play()
    }
}
