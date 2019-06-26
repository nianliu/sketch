package kt


fun main(args: Array<String>) {
    val xml = XMLContainer()
            .child("LinearLayout") {
                attr("android:layout_height", "match_parent")
                attr("android:layout_width", "match_parent")
                attr("android:orientation", "vertical")
//s
            }
    println(xml.data())
}

open class XMLContainer {
    private val data = StringBuilder()

    fun child(tag: String, action: XMLChildContainer.() -> Unit): XMLContainer {
        data.append("<$tag")
        val tagData = XMLChildContainer()
        tagData.action()
        data.append(tagData.attrData())
        data.append(">")
        data.append(tagData.data())
        data.append("\n</$tag>")
        return this
    }

    fun data() = data.toString()
}

class XMLChildContainer : XMLContainer() {
    private val tagData = StringBuilder()

    fun attr(attrName: String, value: String) {
        tagData.append(" $attrName=\"$value\"")
    }

    fun attrData() = tagData.toString()
}