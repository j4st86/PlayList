data class Root (var mainName: String) {

    var attributesName: String = ""

    var attributesValue: String = ""

    fun getVersion(): String {
        return "$attributesName -> $attributesValue"
    }

    fun getFull(): String{
        return "$mainName -> $attributesName -> $attributesValue"
    }

}