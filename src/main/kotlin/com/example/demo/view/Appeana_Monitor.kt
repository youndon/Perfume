package com.example.demo.view

import com.example.demo.box.Monitor
import dyorgio.runtime.run.`as`.root.RootExecutor
import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.collections.FXCollections
import javafx.scene.chart.LineChart
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.PieChart
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.util.Duration
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import tornadofx.*
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    launch<MonitorApp>()
}
class MonitorApp:App(Appeana_Monitor::class)

class Appeana_Monitor:UIComponent("System Monitor") {
    var traffic = LineChart(NumberAxis(), NumberAxis(), FXCollections.observableArrayList())
    var cpu = LineChart(NumberAxis(), NumberAxis(), FXCollections.observableArrayList())
    var mem = PieChart()
    var swap = PieChart()
    var lisDown = (0L..60L).toList() as ArrayList
    var lisUp = (0L..60L).toList() as ArrayList
    var down = arrayListOf(0L)
    var up = arrayListOf(0L)
    var cpuperc = List(Monitor.CPU.coresN()) { text() }

    override val root = tabpane {
        tab("NETWORK") {
            this.isClosable=false
            // drawer
            traffic = linechart(
                "Traffic | Total Down:${(Monitor.NETWORK.totalDownloadsF())} | Total Up:${
                    (Monitor.NETWORK.totalUploadsF())
                }", NumberAxis(), NumberAxis()
            )
        }

        tab("MEM") {
            this.isClosable=false
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
            this.isClosable=false
            borderpane {
                center {
                    cpu = linechart(
                        "CPU | ${Monitor.CPU.info()?.model} (${Monitor.CPU.coresN()})",
                        NumberAxis(),
                        NumberAxis()
                    )
                }
            }
        }
        tab("FILE") {
            this.isClosable=false
            tableview(Monitor.FILE.fileSys) {
                readonlyColumn("Device", Monitor.AA::dev)
                readonlyColumn("Directory", Monitor.AA::dir)
                readonlyColumn("Type", Monitor.AA::type)
                readonlyColumn("Total", Monitor.AA::total)
                readonlyColumn("Used", Monitor.AA::used)
                readonlyColumn("Free", Monitor.AA::free)
                readonlyColumn("Files", Monitor.AA::files)
                readonlyColumn("Percent", Monitor.AA::perc)
                readonlyColumn("Progress", Monitor.AA::progressBar)
            }.style{
                font = Font("Ubuntu-Light",13.0)
            }
        }
        tab("OS_INFO") {
            this.isClosable=false
            scrollpane {
                form {
                    // OS name
                    label {
                        text = "OS: ${Monitor.OS_INFO.os}\n" +
                                "Host Name: ${Monitor.OS_INFO.hostName}\n" +
                                "User Name: ${Monitor.OS_INFO.userName}\n" +
                                "Description: ${Monitor.OS_INFO.description}\n" +
                                "Version: ${Monitor.OS_INFO.version}\n" +
                                "Kernel: ${Monitor.OS_INFO.kernel}\n" +
                                "Arch: ${Monitor.OS_INFO.archName}\n" +
                                "Desktop: ${Monitor.OS_INFO.de}\n" +
                                "Language: ${Monitor.OS_INFO.lang}\n" +
                                "Windowing System: ${Monitor.OS_INFO.ws}\n" +
                                "Home: ${Monitor.OS_INFO.home}\n" +
                                "DNS: ${Monitor.OS_INFO.dns}\n" +
                                "NetMask: ${Monitor.OS_INFO.netmask}\n" +
                                "Hardware Address: ${Monitor.OS_INFO.hwaddr}\n" +
                                "Address: ${Monitor.OS_INFO.address}\n" +
                                "CPU:${Monitor.OS_INFO.cpu()}\n" +
                                "Resolution: ${Monitor.OS_INFO.resolution()}\n" +
                                "Uptime: ${Monitor.OS_INFO.upTime()}"
                    }.style {
                        font = Font("Ubuntu-Light", 18.0)
                    }
                    button("Advanced").action {
                        Monitor.OS_INFO.command("sudo lshw").lines().forEach {
                          text(it).style{
                              font = Font("Ubuntu-Light",14.0)
                          }
                      }
                    }
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
                swap.data(
                    "used(${"%.2f".format(Monitor.SWAP.usedPerc())})%",
                    Monitor.SWAP.usedPerc()
                )
                swap.data(
                    "used(${"%.2f".format(Monitor.SWAP.freePerc())})%",
                    Monitor.SWAP.freePerc()
                )

                // CUP
                cpu.data.clear()
                cpu.animated = false
                cpu.run {
                    (1..Monitor.CPU.coresN()).withIndex().forEach { core ->
                        runBlocking {
                            launch {
                                series("cpu ${core.value}") {
                                    lisCpu[core.index].withIndex().forEach {
                                        data(it.index, it.value as Number?)
                                    }
                                }
                                lisCpu[core.index].add(Monitor.CPU.dr(core.index)!!.toLong())
                                lisCpu[core.index].removeAt(0)

                                cpuperc.forEach {
                                    it.text = "${Monitor.CPU.dr(core.index)!!.toLong()}"
                                }
                                delay(70)
                            }.start()
                        }
//                        Thread.sleep(70)
                    }
                }
            }),
            KeyFrame(Duration.seconds(1.0))
        )
        cc.cycleCount = Animation.INDEFINITE
        cc.play()
    }
}

var lisCpu = arrayListOf(
    arrayListOf(0L,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
    arrayListOf(0L,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
    arrayListOf(0L,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
    arrayListOf(0L,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
    arrayListOf(0L,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
    arrayListOf(0L,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
    arrayListOf(0L,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
    arrayListOf(0L,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
)

