/* https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

fun main(args: Array<String>) {

    val node1 = ListNode(2)
    val node2 = ListNode(4)
    val node3 = ListNode(3)
    node1.next = node2
    node2.next = node3
    val node4 = ListNode(5)
    val node5 = ListNode(6)
    val node6 = ListNode(4)
    node4.next = node5
    node5.next = node6

    addTwoNumbers(node1, node4)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var currentNode1 = l1
    var currentNode2 = l2

    var isCarry = false
    val result = ListNode(0)
    var temp: ListNode? = result
    while (true) {

        var sum = ((currentNode1?.`val` ?: 0) + (currentNode2?.`val` ?: 0))
        if (isCarry) {
            sum++
            isCarry = false
        }

        if (sum >= 10) {
            isCarry = true
            sum %= 10
        }
        temp?.`val` = sum

        currentNode1 = currentNode1?.next
        currentNode2 = currentNode2?.next

        if(currentNode1 != null || currentNode2 != null || isCarry){
            temp?.next = ListNode(0)
            temp = temp?.next
        }else{
            return result
        }
    }

    return result
}



