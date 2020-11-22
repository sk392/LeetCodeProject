import java.lang.StringBuilder

fun main(args: Array<String>) {
//    println(reverseStr("abcd", 2))
//    println(reverseStr("abcd", 4))
//    println(reverseStr("abcdefg", 2))
//    println(reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl",39))
    criticalConnections(
        5,
        listOf(listOf(2, 0), listOf(1, 0), listOf(3, 2), listOf(4, 2), listOf(4, 3), listOf(3, 0), listOf(4, 0))
    )
//    criticalConnections(6, listOf(listOf(0,1),listOf(1,2),listOf(2,0),listOf(1,3),listOf(3,4),listOf(4,5),listOf(5,3)))
}
var maxTime = 0

fun reverseStr(s: String, k: Int): String {
    if (s.length < k) return s.reversed()
    val stringBuilder = StringBuilder()
    val charArray = s.toCharArray()
    var lastIndex = 0

    while (lastIndex + k <= charArray.size) {
        charArray.slice(lastIndex until lastIndex + k).reversed().forEach {
            stringBuilder.append(it)
        }
        if (lastIndex + 2 * k < charArray.size) {
            charArray.slice(lastIndex + k until lastIndex + (2 * k)).forEach {
                stringBuilder.append(it)
            }
        } else {
            charArray.slice(lastIndex + k until charArray.size).forEach {
                stringBuilder.append(it)
            }
        }
        lastIndex += 2 * k
    }
    if (lastIndex < charArray.size) {
        charArray.slice(lastIndex until charArray.size).reversed().forEach {
            stringBuilder.append(it)
        }
    }

    return stringBuilder.toString()
}
fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val resultMap = hashMapOf<Int,Int>()
    val connectMap = hashMapOf<Int, MutableList<Int>>()
    connections.forEach {
        val leftNode = it[0]
        val rightNode = it[1]

        if (!connectMap.containsKey(leftNode)) {
            connectMap[leftNode] = mutableListOf()
        }
        connectMap[leftNode]!!.add(rightNode)
        if (!connectMap.containsKey(rightNode)) {
            connectMap[rightNode] = mutableListOf()
        }
        connectMap[rightNode]!!.add(leftNode)
    }

    connectMap.keys.forEach { start ->
        val list = connectMap[start]!!.toList()
        for( i in 0 until list.size){
            val end = list[i]
            val copied = hashMapOf<Int,MutableList<Int>>()
            connectMap.keys.forEach {
                copied[it] = connectMap[it]!!.toMutableList()
            }
            copied[start]!!.remove(end)
            val connectedSet = mutableSetOf<Int>()
            connectedSet.add(start)
            if (!findConnection(start, end, copied,connectedSet,1)) {
                if((resultMap[end] ?: -1) != start){
                    resultMap[start] = end
                }
            }
        }
    }
    resultMap.forEach { i, v ->
        result.add(listOf(i,v))
    }
    return result
}

fun findConnection(before: Int, end: Int, connectMap: HashMap<Int, MutableList<Int>>,connectedSet : MutableSet<Int>,time : Int): Boolean {
    maxTime = Math.max(maxTime,time)
    val list = connectMap[before]!!.toList()
    for( i in 0 until list.size){
        val curr = list[i]
        if (curr == end) return true
        else {
            if(!connectedSet.contains(curr)){
                connectedSet.add(before)
                connectMap[curr]!!.remove(before)
                if(findConnection(curr, end, connectMap,connectedSet,time +1)){
                    return true
                }
            }
        }
    }

    return false

}