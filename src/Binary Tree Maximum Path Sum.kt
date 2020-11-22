fun main(args: Array<String>) {
    val root = TreeNode(-10)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(9)
    print(maxPathSum(root))
}

var maxPathSumResult = Int.MIN_VALUE
fun maxPathSum(root: TreeNode?): Int {
    recursive(root!!)
    return maxPathSumResult
}

private fun recursive(root: TreeNode): Int {
    val leftChild = root.left
    val rightChild = root.right
    var result = root.`val`

    when {
        leftChild != null && rightChild != null -> {
            val leftMaxValue = recursive(leftChild)
            val rightMaxValue = recursive(rightChild)

            maxPathSumResult = Math.max(maxPathSumResult, root.`val` + leftMaxValue + rightMaxValue)
            result = Math.max(
                result,
                Math.max(leftMaxValue, rightMaxValue) + root.`val`
            )
        }
        leftChild != null -> {
            result = Math.max(
                result,
                recursive(leftChild) + root.`val`
            )
        }
        rightChild != null -> {
            result = Math.max(
                result,
                recursive(rightChild) + root.`val`
            )
        }
    }

    maxPathSumResult = Math.max(maxPathSumResult, result)
    return result
}
