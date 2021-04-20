package AppeanaFx.s

import tornadofx.Controller
import tornadofx.Slideshow
import tornadofx.View

class Slideshow {
    lateinit var slideshow: Slideshow
    init {
        slideshow.run {
            this.currentSlide
            this.currentSlideProperty
            this.defaultBackTransition
            this.defaultBackTransitionProperty
            this.defaultTimeout
            this.defaultTimeoutProperty
            this.defaultTransition
            this.defaultTransitionProperty
            this.index
            this.indexProperty
            this.nextKey
            this.nextKeyProperty
            this.previousKey
            this.previousKeyProperty
            this.scope
            this.slides
            this.slide<View>()
            this.previous()
            this.hasNext()
            this.next()
        }
    }
}