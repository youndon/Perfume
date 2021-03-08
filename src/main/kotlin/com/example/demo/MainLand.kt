package com.example.demo.view

import appeanaLib.Coding
import com.github.sarxos.webcam.Webcam
import javafx.application.Platform
import javafx.concurrent.Task
import javafx.embed.swing.SwingFXUtils
import javafx.scene.Camera
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.control.RadioButton
import javafx.scene.control.TextArea
import javafx.scene.image.Image
import javafx.scene.text.Text
import org.hyperic.sigar.Sigar
import org.hyperic.sigar.SigarLoader
import org.hyperic.sigar.SigarProxy
import org.hyperic.sigar.SigarProxyCache
import org.hyperic.sigar.ptql.ProcessFinder
import tornadofx.*
import kotlin.concurrent.thread

class MainLand:App(ViewLand::class)
class ViewLand:UIComponent(){
    override val root = form{
        setPrefSize(300.0,300.0)
      borderpane {

      }
    }
}

fun main() {
    val GB_metric = 1073742000
//        launch<MainLand>()
    System.setProperty("java.library.path","/usr/lib64")
    val ss = Sigar().getNetInterfaceStat(Sigar().netInterfaceList[0])
    Sigar().getNetInterfaceConfig(Sigar().netInterfaceList[0])

    ss.rxBytes ; ss.txBytes

}


