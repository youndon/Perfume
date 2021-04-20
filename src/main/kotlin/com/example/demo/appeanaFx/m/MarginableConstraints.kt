package AppeanaFx.m

import tornadofx.MarginableConstraints

abstract class MarginableConstraints {
    lateinit var marginableConstraints: MarginableConstraints
    init {
        marginableConstraints.run {
            this.margin
            this.marginTop
            this.marginRight
            this.marginLeft
            this.marginBottom
            this.marginLeftRight(1.0)
            this.marginTopBottom(1.0)
        }
    }
}