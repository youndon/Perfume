package AppeanaFx.a

import tornadofx.osgi.ApplicationProvider

interface ApplicationProvider {
     var applicationProvider:ApplicationProvider
    fun main(){
        applicationProvider.application
    }
}