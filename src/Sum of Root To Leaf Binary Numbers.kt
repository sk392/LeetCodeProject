var result = 0
fun main(args: Array<String>) {
    println("1101".toInt(2))
}

fun sumRootToLeaf(root: TreeNode?): Int {
    getResultRootToLeaf(root, "")
    return result
}

fun getResultRootToLeaf(node: TreeNode?, tempResult: String) {
    node ?: return
    val sumResult = tempResult + node.`val`
    if (!isHaveChild(node)) {
        result += sumResult.toInt(2)
    } else {
        getResultRootToLeaf(node.left, sumResult)
        getResultRootToLeaf(node.right, sumResult)
    }
}

fun isHaveChild(node: TreeNode?) = (node?.left != null || node?.right != null)