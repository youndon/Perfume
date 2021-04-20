package AppeanaFx.s

import tornadofx.SetConversionListener

class SetConversionListener {
    lateinit var setConversionListener: SetConversionListener<*,*>
    init {
        setConversionListener.converter
    }
}