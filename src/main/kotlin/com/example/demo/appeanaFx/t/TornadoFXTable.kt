package AppeanaFx.t

import tornadofx.adapters.TornadoFXTable

interface TornadoFXTable {
     var tornadoFXTable:TornadoFXTable<*,*>
    fun main(){
        tornadoFXTable.run {
            this.contentColumns
            this.contentWidth
            this.properties
            this.skin
            this.skinProperty
            this.table
        }
    }
}