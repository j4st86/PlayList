import java.io.File
import org.w3c.dom.Document
import org.w3c.dom.Node
import javax.xml.parsers.DocumentBuilderFactory

fun main(){

    val xmlFile = File("REKORDBOX.xml")

    val xmlDoc: Document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile)
    xmlDoc.documentElement.normalize()

    val rootNode: Node = xmlDoc.firstChild

    val root = Root(rootNode.nodeName)
    println(rootNode.nodeName)
    root.getAttributes(rootNode)
    println("------------------------")
    root.getChildren(rootNode)
    println("------------------------")

}