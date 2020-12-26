package AppeanaFx.t

import tornadofx.adapters.TornadoFXColumn

interface TornadoFXColumn {
     var tornadoFXColumn:TornadoFXColumn<Int>
    fun main(){
        tornadoFXColumn.run {
            this.column
            this
            this.maxWidth
            this.maxWidthProperty
            this.minWidth
            this.minWidthProperty
            this.prefWidth
            this.properties
            this.width
        }
    }
}