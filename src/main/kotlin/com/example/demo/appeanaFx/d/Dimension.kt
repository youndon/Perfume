package AppeanaFx.d

import tornadofx.Dimension

class Dimension {
    lateinit var dimension: Dimension<*>
    init {
        dimension.run {
            this.units
            this.value
//            this.div()
//            this.minus()
//            this.plus()
//            this.rem()
//            this.times()
            this.unaryMinus()
            this.unaryPlus()
        }
    }
}