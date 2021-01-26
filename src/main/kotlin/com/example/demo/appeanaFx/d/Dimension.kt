package AppeanaFx.d

import tornadofx.Dimension

class Dimension {
    lateinit var dimension: Dimension<*>
    init {
        dimension.run {
            this.units
            this.value
            this.div(1)
            this.minus(1)
            this.plus(1)
            this.rem(1)
            this.times(1)
            this.unaryMinus()
            this.unaryPlus()
        }
    }
}