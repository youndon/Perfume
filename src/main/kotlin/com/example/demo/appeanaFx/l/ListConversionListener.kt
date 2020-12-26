package AppeanaFx.l

import tornadofx.ListConversionListener

class ListConversionListener {
    lateinit var listConversionListener: ListConversionListener<*,*>
    init {
        listConversionListener.converter
    }
}