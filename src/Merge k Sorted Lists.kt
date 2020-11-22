fun main(args: Array<String>) {

}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if(lists.isEmpty()) return null
    val headers = MutableList(lists.size) { lists[it] }
    var resultNode: ListNode? = null
    var currentNode: ListNode? = null

    do {
        val index = getMinimumNodeIndex(headers)

        if(resultNode == null){
            resultNode = headers[index]
            currentNode = resultNode
        }else{
            currentNode?.next = headers[index]
            currentNode = currentNode?.next
        }
        headers[index] = headers[index]?.next
    }while (currentNode != null)

    return resultNode
}

fun getMinimumNodeIndex(headers: MutableList<ListNode?>): Int {
    var minimumValue = Int.MAX_VALUE
    var minimumIndex = 0

    for (i in 0 until headers.size) {
        val value = headers[i]?.`val` ?: Int.MAX_VALUE
        if (minimumValue > value) {
            minimumValue = value
            minimumIndex = i
        }
    }
    return minimumIndex
}