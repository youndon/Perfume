The Rectangle class defines a rectangle with the specified size and location. By default the rectangle has sharp corners.
```kotlin
class MainView:View() {
    override val root = vbox {
        rectangle(10,10,100,100) {
            this.width
            this.height
            this.arcHeight
            this.arcWidth
            this.x
            this.y
        }
    }
}
```
The Arc class represents a 2D arc object, defined by a center point, start angle (in degrees), angular extent (length of the arc in degrees), and an arc type (ArcType.OPEN, ArcType.CHORD, or ArcType.ROUND).
```kotlin
class MainView:View() {
    override val root = vbox {
        arc { 
            this.centerX
            this.centerY
            this.length
            this.radiusX
            this.radiusY
            this.startAngle
            this.type
        }
    }
}
```
The Circle class creates a new circle with the specified radius and center location measured in pixels Example usage. The following code creates a circle with radius 50px centered at (100,100)px.
```kotlin
class MainView:View() {
    override val root = vbox {
        circle {
            this.centerX
            this.centerY
            this.radius
        }
    }
}
```
The CubiCurve class defines a cubic Bézier parametric curve segment in (x,y) coordinate space. Drawing a curve that intersects both the specified coordinates (startX, startY) and (endX, enfY), using the specified points (controlX1, controlY1) and (controlX2, controlY2) as Bézier control points.
```kotlin
class MainView: View() {
    override val root = vbox {
        cubiccurve {
            startX = 0.0
            startY = 50.0
            controlX1 = 25.0
            controlY1 = 0.0
            controlX2 = 75.0
            controlY2 = 100.0
            endX = 150.0
            endY = 50.0
        }
    }
}
```
The Ellipse class creates a new ellipse with the specified size and location in pixels
```kotlin
class MainView: View() {
    override val root = vbox {
        ellipse {
            centerX = 50.0
            centerY = 50.0
            radiusX = 100.0
            radiusY = 50.0
        }
    }
}
```
This Line represents a line segment in (x,y) coordinate space.
```kotlin
class MainView: View() {
    override val root = vbox {
        line {
            startX = 50.0
            startY = 50.0
            endX = 150.0
            endY = 100.0
        }
    }
}
```
Creates a polyline, defined by the array of the segment points. The Polyline class is similar to the Polygon class, except that it is not automatically closed.
```kotlin
class MainView: View() {
    override val root = vbox {
     polyline(0.0, 0.0, 80.0, 40.0, 40.0, 80.0){
         this.points
     }
    }
}
```
The Quadcurve class defines a quadratic Bézier parametric curve segment in (x,y) coordinate space. Drawing a curve that intersects both the specified coordinates (startX, startY) and (endX, enfY), using the specified point (controlX, controlY) as Bézier control point.
```kotlin
class MainView: View() {
    override val root = vbox {
        quadcurve {
            startX = 0.0
            startY = 150.0
            endX = 150.0
            endY = 150.0
            controlX = 75.0
            controlY = 0.0
        }
    }
}
```
The SVGPath class represents a simple shape that is constructed by parsing SVG path data from a String.
```kotlin
class MainView: View() {
    override val root = vbox {
        svgpath("M70,50 L90,50 L120,90 L150,50 L170,50 L210,90 L180,120 L170,110 L170,200 L70,200 L70,110 L60,120 L30,90 L70,50") {
            this.content
            this.fillRule
        }
    }
}
```
The Path class represents a simple shape and provides facilities required for basic construction and management of a geometric path.
```kotlin
class MainView: View() {
    override val root = vbox {
        path(){
            this.elements
            this.fillRule
            this.arcTo {  }
            this.closepath()
            this.hlineTo()
            this.lineTo()
            this.moveTo()
            this.vlineTo()
            this.quadqurveTo {  }
        }
    }
}
```
