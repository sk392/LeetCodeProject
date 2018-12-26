/*https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/



fun main(args: Array<String>) {
    val node1 = ListNode(2)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    node1.next = node2
    node2.next = node3
    val node4 = ListNode(3)
    val node5 = ListNode(5)
    val node6 = ListNode(6)
    val node7 = ListNode(9)
    val node8 = ListNode(10)
    node4.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node8
    mergeTwoLists(node1, node4)
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) {
        return null
    }
    val result = ListNode()
    var temp1 = l1
    var temp2 = l2

    var tempNode = result

    while (temp1 != null || temp2 != null) {

        if (temp1?.`val` ?: Int.MAX_VALUE > temp2?.`val` ?: Int.MAX_VALUE) {
            tempNode.next = temp2
            temp2 = temp2?.next
        } else {
            tempNode.next = temp1
            temp1 = temp1?.next
        }

        tempNode = tempNode.next!!
    }

    return result.next
}
