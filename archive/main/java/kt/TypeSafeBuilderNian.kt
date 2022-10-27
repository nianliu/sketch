package kt

fun main(args: Array<String>) {
    val node = ParentContainer()
            .node("A") {
                addKid(1)
                addKid(2)
                addKid(6)
            }
            .node("B") {
                addKid(8)
                addKid(9)
                addKid(10)
            }

    println()
}

class ParentContainer {

    val nodes = mutableMapOf<String, List<Int>>()

    fun node(name: String, applyToLeaf: ChildrenContainer.() -> Unit): ParentContainer {

        val childrenContainer = ChildrenContainer()
        applyToLeaf(childrenContainer)

        nodes.put(name, childrenContainer.children)

        return this
    }

}

class ChildrenContainer {

    val children = mutableListOf<Int>()

    fun addKid(num: Int) {
        children.add(num)
    }
}