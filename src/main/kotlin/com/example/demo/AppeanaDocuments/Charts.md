Chart type that plots symbols for the data points in a series.
```kotlin
class MainView:View() {
    override val root = vbox {
        scatterchart("scatterchart", NumberAxis(), NumberAxis()) {
            series("One") {
                this.data
                this.chart
                this.name
                this.node
                data(1, 24).run { 
                    
                }
                data(2, 26)
                data(3, 29)
                data(4, 22)
                data(5, 18)
            }
            series("Tow") {
                data(1, 18)
                data(2, 16)
                data(3, 7)
                data(4, 10)
                data(5, 8)
            }
        }
    }
}
```

AreaChart - Plots the area between the line that connects the data points and the 0 line on the Y axis.
```kotlin
class MainView:View() {
    override val root = vbox {
        areachart("scatterchart", NumberAxis(), NumberAxis()) {
            this.createSymbols
        }
    }
}
```

A chart that plots bars indicating data values for a category. The bars can be vertical or horizontal depending on which axis is a category axis.
```kotlin
class MainView:View() {
    override val root = vbox {
        barchart("scatterchart", CategoryAxis(), NumberAxis()) {
            this.barGap
            this.categoryGap
            series("Product X") {
                data("MAR", 10245)
                data("APR", 23963)
                data("MAY", 15038)
            }
        }
    }
}
```

StackedBarChart is a variation of BarChart that plots bars indicating data values for a category. The bars can be vertical or horizontal depending on which axis is a category axis. The bar for each series is stacked on top of the previous series.
```kotlin
class MainView:View() {
    override val root = vbox {
        stackedbarchart("scatterchart", CategoryAxis(), NumberAxis()) {
            this.categoryGap
            series("Product X") {
                data("MAR", 10245)
                data("APR", 23963)
                data("MAY", 15038)
            }
        }
    }
}
```
Chart type that plots bubbles for the data points in a series. The extra value property of Data is used to represent the radius of the bubble it should be a java.lang.Number.
```kotlin
class MainView:View() {
    override val root = vbox {
        bubblechart("scatterchart", NumberAxis(), NumberAxis()) {
            series("Product X") {
                data(1,24,1)
                data(2,46,2)
                data(3,23,1)
                data(4,27,2)
                data(5,18,1)
            }
        }
    }
}
```
Line Chart plots a line connecting the data points in a series. The data points themselves can be represented by symbols optionally. Line charts are usually used to view data trends over time or category.
```kotlin
class MainView:View() {
    override val root = vbox {
        linechart("scatterchart", NumberAxis(), NumberAxis()) {
            this.axisSortingPolicy
            this.createSymbols
            series("Product X") {
                data(1,24)
                data(2,46)
            }
        }
    }
}
```
Displays a PieChart. The chart content is populated by pie slices based on data set on the PieChart.
The clockwise property is set to true by default, which means slices are placed in the clockwise order. The labelsVisible property is used to either display pie slice labels or not.
```kotlin
class MainView:View() {
    override val root = vbox {
        piechart {
            this.data
            this.isClockwise
            this.labelLineLength
            this.labelsVisible
            this.startAngle
            this.data("",25.0).run { 
                this.pieValue
            }
        }
    }
}
```
