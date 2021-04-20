package AppeanaFx.m

import tornadofx.MapConversionListener

class MapConversionListener {
    lateinit var mapConversionListener: MapConversionListener<*,*,*>
    init {
        mapConversionListener.converter
    }
}