package AppeanaFx.r

import tornadofx.Rendered

interface Rendered {
     var rendered: Rendered
    fun main(){
        rendered.render()
    }
}