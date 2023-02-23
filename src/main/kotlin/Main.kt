import java.io.File
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import javax.xml.parsers.DocumentBuilderFactory

fun main(){

    val xmlFile = File("REKORDBOX.xml")

    val xmlDoc: Document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile)
    xmlDoc.documentElement.normalize()

    val rootNode: Node = xmlDoc.firstChild

    val root = Root(rootNode.nodeName)
    root.attributesName = rootNode.attributes.item(0).nodeName
    root.attributesValue = rootNode.attributes.item(0).nodeValue
    println(root.mainName)
    println(root.getVersion())
    println(root.getFull())
    println("------------------------")
    getRoots(rootNode)
    println("------------------------")

}
fun getRoots(mainNode : Node) {

    val nodeChild : NodeList = mainNode.childNodes

    repeat(nodeChild.length) { indexNode ->

        if (nodeChild.item(indexNode).nodeType == Node.ELEMENT_NODE) {

            println(nodeChild.item(indexNode).nodeName)

            repeat(nodeChild.item(indexNode).attributes.length) { indexAttributes ->

                if (nodeChild.item(indexNode).attributes.equals(null))
                    return

                print("  ")
                println("${nodeChild.item(indexNode).attributes.item(indexAttributes).nodeName} -> ${nodeChild.item(indexNode).attributes.item(indexAttributes).nodeValue}")
            }

        }

        if (nodeChild.item(indexNode).hasChildNodes()) getRoots(nodeChild.item(indexNode))

    }

}