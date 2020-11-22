import java.util.*

fun main(args: Array<String>) {

}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val stack: Deque<TreeNode?> = LinkedList()
    val result = mutableListOf<Int>()
    var curr = root
    while (curr != null || stack.isNotEmpty()) {
        while (curr != null) {
            stack.push(curr)
            curr = curr.left
        }
        curr = stack.pop()
        result.add(curr?.`val` ?: 0)

        curr = curr?.right
    }

    return result
}