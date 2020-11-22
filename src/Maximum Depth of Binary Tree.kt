import java.util.*

fun main(args: Array<String>) {

}

fun maxDepth(root: TreeNode?): Int {
    root ?: return 0
    val queue : Queue<Pair<TreeNode,Int>> = LinkedList()
    var depth = 0
    queue.add(Pair(root,0))

    while(queue.isNotEmpty()){
        val curr = queue.poll()
        val node = curr.first
        val currDepth = curr.second
        if(node.left != null){
            queue.add(Pair(node.left!!,currDepth+1))
        }
        if(node.right != null){
            queue.add(Pair(node.right!!,currDepth+1))
        }
        depth = currDepth
    }

    return depth +1
}