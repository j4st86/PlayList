import org.w3c.dom.Node
import org.w3c.dom.NodeList

data class Root (var mainName: String) {

    fun getChildren(mainNode : Node) {

        val nodeChild : NodeList = mainNode.childNodes

        repeat(nodeChild.length) { indexNode ->

            if (nodeChild.item(indexNode).nodeType == Node.ELEMENT_NODE) {

                println(nodeChild.item(indexNode).nodeName)

                getAttributes(nodeChild.item(indexNode))

            }

            if (nodeChild.item(indexNode).hasChildNodes()) getChildren(nodeChild.item(indexNode))

        }
    }

    fun getAttributes(nodeItem : Node) {

        repeat(nodeItem.attributes.length) { indexAttributes ->

            if (nodeItem.attributes.equals(null))
                return

            println("  ${nodeItem.attributes.item(indexAttributes).nodeName} -> " +
                    "${nodeItem.attributes.item(indexAttributes).nodeValue}",)

        }
    }
}