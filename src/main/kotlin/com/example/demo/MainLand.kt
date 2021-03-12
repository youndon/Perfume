package com.example.demo.view

import appeanaLib.Coding
import com.github.sarxos.webcam.Webcam
import com.github.sarxos.webcam.WebcamPanel
import com.github.sarxos.webcam.WebcamResolution
import com.sun.glass.ui.Screen
import javafx.animation.Interpolator
import javafx.application.Platform
import javafx.concurrent.Task
import javafx.embed.swing.SwingFXUtils
import javafx.scene.Camera
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.control.RadioButton
import javafx.scene.control.TextArea
import javafx.scene.image.Image
import javafx.scene.text.Text
import javafx.stage.Stage
import javafx.util.Duration
import org.hyperic.sigar.Sigar
import org.hyperic.sigar.SigarLoader
import org.hyperic.sigar.SigarProxy
import org.hyperic.sigar.SigarProxyCache
import org.hyperic.sigar.ptql.ProcessFinder
import tornadofx.*
import java.awt.Dimension
import kotlin.concurrent.thread

fun main() {
    launch<MainLand>()
}

class MainLand:App(ViewLand::class){
}

class ViewLand:UIComponent() {
    override val root = form {
        setPrefSize(300.0, 300.0)
    }
}


