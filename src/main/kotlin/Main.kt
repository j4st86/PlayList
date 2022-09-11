import java.io.File
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import javax.xml.parsers.DocumentBuilderFactory

fun main(){

    val xmlFile = File("P:\\Programms\\java code\\PlaylistXML\\PlayList\\REKORDBOX.xml")
    val xmlDoc: Document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile)

    xmlDoc.documentElement.normalize()

    val rootNode: Node = xmlDoc.firstChild
    println("${rootNode.nodeName} -> ${rootNode.attributes.item(0).nodeName} -> ${rootNode.attributes.item(0).nodeValue}")
    println("")

    val root = Root(rootNode.nodeName)
    root.attributesName = rootNode.attributes.item(0).nodeName
    root.attributesValue = rootNode.attributes.item(0).nodeValue
    println(root.getVersion())
    println("")
    println(root.getFull())
    println("")

    val rootChild: NodeList = rootNode.childNodes
    for(i in 0 until rootChild.length){

        if(rootChild.item(i).nodeType != Node.ELEMENT_NODE){
            continue
        }

        print(rootChild.item(i).nodeName)

        for (j in 0 until rootChild.item(i).attributes.length){

            if(rootChild.item(i).attributes.equals(null)){
                break
            }

            print("  ")
            println("${rootChild.item(i).attributes.item(j).nodeName} -> ${rootChild.item(i).attributes.item(j).nodeValue}")

        }

    }

}