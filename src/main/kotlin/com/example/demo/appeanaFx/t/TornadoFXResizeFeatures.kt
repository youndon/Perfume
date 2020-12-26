package AppeanaFx.t

import tornadofx.adapters.TornadoFXResizeFeatures

interface TornadoFXResizeFeatures {
     var tornadoFXResizeFeatures:TornadoFXResizeFeatures<*,*>
    fun main(){
        tornadoFXResizeFeatures.run {
            this.column
            this.delta
            this.table
        }
    }
}