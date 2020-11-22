import java.util.LinkedList
import java.util.Deque
import kotlin.properties.Delegates
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution

fun main(args: Array<String>) {


}
fun minDiffInBST1(root: TreeNode?): Int {
    val stack: Deque<TreeNode> = LinkedList()
    var prev: TreeNode? = null
    var current = root
    var result = Int.MAX_VALUE

    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.push(current)
            current = current.left
        }

        current = stack.pop()

        if (prev != null && current != null) {
            result = Math.min(result, (current.`val`) - prev.`val`)
        }
        prev = current
        current = current.right
    }

    return result
}