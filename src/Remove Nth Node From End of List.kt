import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    val node5 = ListNode(0)
    val node4 = ListNode(0).apply {
        next = node5
    }
    val node3 = ListNode(0).apply {
        next = node4
    }
    val node2 = ListNode(0).apply {
        next = node3
    }
    val node1 = ListNode(0).apply {
        next = node2
    }
    val node10 = ListNode(0)
    val node0 = ListNode(0).apply {
        next = node10
    }

    val a = removeNthFromEnd(node0, 2)
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    head?.next ?: return null
    val queue = ArrayDeque<ListNode?>()

    var result = head
    while (result != null) {
        addQueue(queue, result, n + 1)
        result = result.next
    }

    return if (queue.size == n + 1) {

        val tempNode = queue.pop()
        val nextNode = tempNode?.next?.next
        tempNode?.next = nextNode
        head
    } else {
        head.next
    }

}

fun addQueue(queue: Queue<ListNode?>, item: ListNode?, maxSize: Int) {
    if (queue.size >= maxSize) {
        queue.remove()
    }
    queue.add(item)
}