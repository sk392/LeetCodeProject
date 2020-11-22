fun main(args: Array<String>) {
}
class ConstructBinaryTreefromPreorderandInorderTraversal{
    private var preIdx = 0
    private lateinit var preorder: IntArray
    private lateinit var inorder: IntArray
    private lateinit var inorderMap: MutableMap<Int, Int>

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        this.preIdx = 0
        this.inorderMap = mutableMapOf()
        this.inorder = inorder
        this.preorder = preorder

        for (i in inorder.indices) {
            inorderMap[inorder[i]] = i
        }

        return constructTree(0, inorder.size)
    }

    private fun constructTree(
        inLeft: Int, // inclusive
        inRight: Int // exclusive
    ): TreeNode? {
        if (inLeft == inRight) return null

        val rootVal = preorder[preIdx]
        val rootIdx = inorderMap[rootVal]!!
        val root = TreeNode(rootVal)

        preIdx++
        root.left = constructTree(inLeft, rootIdx)
        root.right = constructTree(rootIdx + 1, inRight)

        return root
    }

}

