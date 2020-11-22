import java.util.*

fun main(args: Array<String>) {

}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    root ?: return emptyList()
    val result = mutableListOf<List<Int>>()
    val queue : Queue<Pair<TreeNode,Int>> =ArrayDeque()

    queue.add(Pair(root,0))
    var currentLevel = 0
    var list = mutableListOf<Int>()
    while(queue.isNotEmpty()){
        val current = queue.poll()
        val node = current.first
        val level = current.second

        if(node.left != null){
            queue.add(Pair(node.left!!,level+1))
        }
        if(node.right != null){
            queue.add(Pair(node.right!!,level+1))
        }

        if(currentLevel == level){
            list.add(node.`val`)
        }else{
            result.add(list.toList())
            list = mutableListOf()
            list.add(node.`val`)
            currentLevel++
        }
    }

    result.add(list.toList())

    return result
}