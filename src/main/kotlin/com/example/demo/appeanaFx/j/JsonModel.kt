package AppeanaFx.j

import tornadofx.JsonModel
import javax.json.JsonValue

interface JsonModel {
     var jsonModel: JsonModel
    fun main(){
        jsonModel.run {
            this.copy(this)
            this.toJSON()
            this.update(this)
            this.updateModel(JsonValue.EMPTY_JSON_OBJECT)
        }
    }
}