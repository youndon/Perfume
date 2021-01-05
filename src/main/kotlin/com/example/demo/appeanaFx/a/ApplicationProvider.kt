package AppeanaFx.a

import tornadofx.osgi.ApplicationProvider

private interface ApplicationProvider {
     var applicationProvider:ApplicationProvider
    fun main(){
        applicationProvider.application
    }
}