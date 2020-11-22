fun main(args: Array<String>) {

}

fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    val result: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    edges.forEach {
        addMap(it[0], it[1], map)
        addMap(it[1], it[0], map)
    }
    return emptyList()
}

private fun addMap(key: Int, value: Int, map: MutableMap<Int, MutableList<Int>>) {
    map[key] = (map[key] ?: mutableListOf()).apply {
        add(value)
    }
}

fun getMinLength(startPosition: Int, map: MutableMap<Int, MutableList<Int>>): Int {
    var beforeTemp = startPosition
    var result: Int = 0
    return 0

}