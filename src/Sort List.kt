fun main(args: Array<String>) {
    val node1 = ListNode(1)
    val node2 = ListNode(5)
    val node3 = ListNode(2)
    val node4 = ListNode(3)
    val node5 = ListNode(4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    var node: ListNode? = sortList(node1)
    for (i in 0 until 5) {
        println(node?.`val`)
        node = node?.next
    }
    val data1 = Data("1")
    val data2 = Data("2")
    val data3 = Data("3")
    val data4 = Data("4")
    val list = listOf<Data>(data1,
        data2,data3,data4,Data("5"))
    val list2 = listOf<Data>(
        data2,data3,data4,Data("6"),Data("7"),Data("8"))


    list.map{data ->
        if(list2.firstOrNull { it == data } != null){

        }else{

        }
         ?: data.unregi()
    }
    list2.map{

    }
}

data class Data(val str : String){
    fun regi(){

    }
    fun unregi(){

    }

}

fun sortList(head: ListNode?): ListNode? {
    if(head?.next == null) return head

    var slow= head
    var fast= head
    var pre :ListNode? = null

    while(fast?.next !=null){
        pre = slow
        slow = slow?.next
        fast = fast.next?.next
    }
    pre?.next = null

    val mid = slow
    val left = sortList(head)
    val right = sortList(mid)

    return mergeSort(left,right)
}

fun mergeSort(left : ListNode?, right : ListNode?) : ListNode?{
    var current = ListNode()
    val dummy = current
    var left = left
    var right= right

    while(left != null && right !=null){
        if(left.`val` < right.`val`){
            current.next = left
            left = left.next
        }else{
            current.next = right
            right = right.next
        }
        current = current.next!!
    }
    if(left != null){
        current.next = left
    }else if( right!=null){
        current.next = right
    }

    return dummy.next
}