package AppeanaFx.f

import tornadofx.FXPropertyResourceBundle

class FXPropertyResourceBundle {
    lateinit var fXPropertyResourceBundle: FXPropertyResourceBundle
    init {
        fXPropertyResourceBundle.inheritFromGlobal()
    }
}