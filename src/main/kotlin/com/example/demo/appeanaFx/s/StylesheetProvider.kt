package AppeanaFx.s

import tornadofx.osgi.StylesheetProvider

interface StylesheetProvider {
     var stylesheetProvider:StylesheetProvider
    fun main(){
        stylesheetProvider.stylesheet
    }
}