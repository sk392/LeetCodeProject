import java.util.*

fun main(args: Array<String>) {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(5)
    root.right?.right = TreeNode(6)
    flatten(root)
}

fun flatten(root: TreeNode?): Unit {
    if(root!= null)
    recursive(root)
}


private fun recursive(root: TreeNode){
    val left = root.left
    val right = root.right
    if(left != null ){
        recursive(left)
    }
    if(right != null ){
        recursive(right)
    }
    var leftLastNode = left

    while(leftLastNode?.right != null){
        leftLastNode = leftLastNode.right
    }

    if(left != null){
        root.right =left
        leftLastNode?.right = right
        root.left =null
    }
}