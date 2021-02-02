/*
 * Copyright (c) 2011 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.example.demo.box

import javafx.stage.Stage
import javafx.scene.Scene
import javafx.collections.ObservableList
import com.example.demo.box.HelloEffects
import javafx.application.Application
import javafx.scene.effect.Light.Distant
import javafx.geometry.VPos
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.effect.*
import javafx.scene.shape.Circle
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import tornadofx.App
import tornadofx.launch
import kotlin.jvm.JvmStatic

fun main() {
    launch<HelloEffects>()
}
class HelloEffects : App() {
    var stage: Stage? = null
    var scene: Scene? = null
    override fun start(stage: Stage) {
        stage.show()
        scene = Scene(Group(), 840.0, 680.0)
        val content = (scene!!.root as Group).children

        /// Perspective
        content.add(perspective())
        /// DropShadow
        content.add(dropShadow())
        /// BlendMode
        content.add(blendMode())
        /// Bloom
        content.add(bloom())
        /// BoxBlur
        content.add(boxBlur())
        /// DisplacementMap
        content.add(displacementMap())
        /// InnerShadow
        content.add(innerShadow())
        /// Lighting
        content.add(lighting())
        /// MotionBlur
        content.add(motionBlur())
        /// Reflection
        content.add(reflection())
        /// GaussianBlur
        content.add(gaussianBlur())
        /// DistantLight
        content.add(distantLight())
        stage.scene = scene
    }

    companion object {
        fun distantLight(): Node {
            val light = Distant()
            light.azimuth = -135.0
            light.elevation = 30.0
            val l = Lighting()
            l.light = light
            l.surfaceScale = 5.0
            val t = Text()
            t.text = "Distant Light"
            t.fill = Color.RED
            t.font = Font.font("null", FontWeight.BOLD, 70.0)
            t.x = 10.0
            t.y = 50.0
            t.textOrigin = VPos.TOP
            t.effect = l
            val r = Rectangle()
            r.fill = Color.BLACK
            val g = Group()
            g.children.add(r)
            g.children.add(t)
            g.translateY = 460.0
            return g
        }

        fun perspective(): Node {
            val g = Group()
            val pt = PerspectiveTransform()
            pt.ulx = 10.0
            pt.uly = 10.0
            pt.urx = 210.0
            pt.ury = 40.0
            pt.lrx = 210.0
            pt.lry = 60.0
            pt.llx = 10.0
            pt.lly = 90.0
            g.effect = pt
            g.isCache = true
            val r = Rectangle()
            r.x = 10.0
            r.y = 10.0
            r.width = 280.0
            r.height = 80.0
            r.fill = Color.DARKBLUE
            val t = Text()
            t.x = 20.0
            t.y = 65.0
            t.text = "Perspective"
            t.fill = Color.RED
            t.font = Font.font("null", FontWeight.BOLD, 36.0)
            g.children.add(r)
            g.children.add(t)
            return g
        }

        fun gaussianBlur(): Node {
            val t2 = Text()
            t2.x = 10.0
            t2.y = 140.0
            t2.isCache = true
            t2.text = "Gaussian Blur"
            t2.fill = Color.RED
            t2.font = Font.font("null", FontWeight.BOLD, 36.0)
            t2.effect = GaussianBlur()
            return t2
        }

        fun reflection(): Node {
            val t = Text()
            t.x = 10.0
            t.y = 50.0
            t.isCache = true
            t.text = "Reflections on JavaFX..."
            t.fill = Color.RED
            t.font = Font.font("null", FontWeight.BOLD, 30.0)
            val r = Reflection()
            r.fraction = 0.7
            t.effect = r
            t.translateY = 400.0
            return t
        }

        fun motionBlur(): Node {
            val t = Text()
            t.x = 20.0
            t.y = 80.0
            t.text = "Motion Blur"
            t.fill = Color.RED
            t.font = Font.font("null", FontWeight.BOLD, 60.0)
            val mb = MotionBlur()
            mb.radius = 15.0
            mb.angle = 45.0
            t.effect = mb
            t.translateX = 520.0
            t.translateY = 100.0
            return t
        }

        fun lighting(): Node {
            val light = Distant()
            light.azimuth = -135.0
            val l = Lighting()
            l.light = light
            l.surfaceScale = 5.0
            val t = Text()
            t.text = "JavaFX\nLighting!"
            t.fill = Color.RED
            t.font = Font.font("null", FontWeight.BOLD, 70.0)
            t.x = 500.0
            t.y = 100.0
            t.textOrigin = VPos.TOP
            t.effect = l
            t.translateX = 0.0
            t.translateY = 320.0
            return t
        }

        fun innerShadow(): Node {
            val `is` = InnerShadow()
            `is`.offsetX = 2.0
            `is`.offsetY = 2.0
            val t = Text()
            t.effect = `is`
            t.x = 20.0
            t.y = 100.0
            t.text = "Inner Shadow"
            t.fill = Color.RED
            t.font = Font.font("null", FontWeight.BOLD, 80.0)
            t.translateX = 300.0
            t.translateY = 300.0
            return t
        }

        fun displacementMap(): Node {
            val w = 220
            val h = 100
            val map = FloatMap()
            map.width = w
            map.height = h
            for (i in 0 until w) {
                val v = (Math.sin(i / 50.0 * Math.PI) - 0.5) / 40.0
                for (j in 0 until h) {
                    map.setSamples(i, j, 0.0f, v.toFloat())
                }
            }
            val g = Group()
            val dm = DisplacementMap()
            dm.mapData = map
            val r = Rectangle()
            r.x = 20.0
            r.y = 20.0
            r.width = w.toDouble()
            r.height = h.toDouble()
            r.fill = Color.BLUE
            g.children.add(r)
            val t = Text()
            t.x = 40.0
            t.y = 80.0
            t.text = "Wavy Text"
            t.fill = Color.YELLOW
            t.font = Font.font("null", FontWeight.BOLD, 36.0)
            g.children.add(t)
            g.effect = dm
            g.isCache = true
            g.translateX = 400.0
            g.translateY = 200.0
            return g
        }

        fun boxBlur(): Node {
            val t = Text()
            t.text = "Blurry Text!"
            t.fill = Color.RED
            t.font = Font.font("null", FontWeight.BOLD, 36.0)
            t.x = 10.0
            t.y = 40.0
            val bb = BoxBlur()
            bb.width = 5.0
            bb.height = 5.0
            bb.iterations = 3
            t.effect = bb
            t.translateX = 300.0
            t.translateY = 100.0
            return t
        }

        fun blendMode(): Node {
            val r = Rectangle()
            r.x = 590.0
            r.y = 50.0
            r.width = 50.0
            r.height = 50.0
            r.fill = Color.BLUE
            val c = Circle()
            c.fill = Color.rgb(255, 0, 0, 0.5)
            c.centerX = 590.0
            c.centerY = 50.0
            c.radius = 25.0
            val g = Group()
            g.blendMode = BlendMode.MULTIPLY
            g.children.add(r)
            g.children.add(c)
            return g
        }

        fun dropShadow(): Node {
            val g = Group()
            val ds = DropShadow()
            ds.offsetY = 3.0
            ds.color = Color.color(0.4, 0.4, 0.4)
            val t = Text()
            t.effect = ds
            t.isCache = true
            t.x = 10.0
            t.y = 270.0
            t.fill = Color.RED
            t.text = "JavaFX drop shadow..."
            t.font = Font.font("null", FontWeight.BOLD, 32.0)
            val ds1 = DropShadow()
            ds1.offsetY = 4.0
            val c = Circle()
            c.effect = ds1
            c.centerX = 50.0
            c.centerY = 325.0
            c.radius = 30.0
            c.fill = Color.ORANGE
            c.isCache = true
            g.children.add(t)
            g.children.add(c)
            return g
        }

        fun bloom(): Node {
            val g = Group()
            val r = Rectangle()
            r.x = 10.0
            r.y = 10.0
            r.width = 160.0
            r.height = 80.0
            r.fill = Color.DARKBLUE
            val t = Text()
            t.text = "Bloom!"
            t.fill = Color.YELLOW
            t.font = Font.font("null", FontWeight.BOLD, 36.0)
            t.x = 25.0
            t.y = 65.0
            g.isCache = true
            //g.setEffect(new Bloom());
            val bloom = Bloom()
            bloom.threshold = 1.0
            g.effect = bloom
            g.children.add(r)
            g.children.add(t)
            g.translateX = 350.0
            return g
        }

    }
}