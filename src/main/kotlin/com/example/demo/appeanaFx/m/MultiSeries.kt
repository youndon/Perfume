package AppeanaFx.m

import tornadofx.MultiSeries

class MultiSeries {
    lateinit var multiSeries: MultiSeries<Int,Int>
    init {
        multiSeries.run {
            this.chart
            this.series
            this.data(1,2)
        }
    }
}