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

    val root = Root(rootNode.nodeName)
    root.attributesName = rootNode.attributes.item(0).nodeName
    root.attributesValue = rootNode.attributes.item(0).nodeValue
    println(root.getName())
    println(root.getVersion())
    println(root.getFull())
    println("------------------------")

    val rootChild: NodeList = rootNode.childNodes
    for(i in 0 until rootChild.length){

        if(rootChild.item(i).nodeType != Node.ELEMENT_NODE){
            continue
        }

        if (rootChild.item(i).nodeName.equals("PRODUCT")) {
            println("found")
        }

        print(rootChild.item(i).nodeName)

        for (j in 0 until rootChild.item(i).attributes.length){

            if(rootChild.item(i).attributes.equals(null)){
                break
            }

            print("  ")
            println("${rootChild.item(i).attributes.item(j).nodeName} -> ${rootChild.item(i).attributes.item(j).nodeValue}")

        }

        val rootFetus: NodeList = rootChild.item(i).childNodes

        for(k in 0 until rootFetus.length) {

            if (rootFetus.item(k).nodeType != Node.ELEMENT_NODE) {
                continue
            }

            print(rootFetus.item(k).nodeName)
            println(" ")

            for (q in 0 until rootFetus.item(k).attributes.length){

                if(rootFetus.item(k).attributes.equals(null)){
                    break
                }

                print("  ")
                println("${rootFetus.item(k).attributes.item(q).nodeName} -> ${rootFetus.item(k).attributes.item(q).nodeValue}")

            }

            val rootSperm: NodeList = rootFetus.item(k).childNodes

            for (u in 0 until rootSperm.length) {

                if (rootSperm.item(u).nodeType != Node.ELEMENT_NODE) {
                    continue
                }

                print(rootSperm.item(u).nodeName)
                println(" ")

                for (y in 0 until rootSperm.item(u).attributes.length){

                    if(rootSperm.item(u).attributes.equals(null)){
                        break
                    }

                    print("  ")
                    println("${rootSperm.item(u).attributes.item(y).nodeName} -> ${rootSperm.item(u).attributes.item(y).nodeValue}")

                }
            }
        }
    }
}