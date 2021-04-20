package AppeanaFx.v

import tornadofx.osgi.ViewProvider

interface ViewProvider {
     var viewProvider:ViewProvider
    fun main(){
        viewProvider.run {
            this.discriminator
            this.getView()
        }
    }
}