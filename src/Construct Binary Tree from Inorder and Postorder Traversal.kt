fun main(args: Array<String>) {
    val a = ConstructBinaryTreefromInorderandPostorderTraversal()
    a.buildTree(intArrayOf(9, 3, 15, 20, 7), intArrayOf(9, 15, 7, 20, 3))
}

//    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
//        return recurs(postorder.reversedArray().toList(), inorder.toList())
//    }
//
//    fun recurs(revPost: List<Int>, inorder: List<Int>): TreeNode? {
//        if (inorder.isEmpty()) return null
//
//        val root = TreeNode(revPost[0])
//        val rootIndex = inorder.indexOf(revPost[0])
//
//        root.left = recurs(
//            revPost.slice(revPost.size - rootIndex until revPost.size)
//            , inorder.slice(0 until rootIndex)
//        )
//        root.right = recurs(
//            revPost.slice(1 until revPost.size - rootIndex)
//            , inorder.slice(rootIndex + 1 until inorder.size)
//        )
//        return root
//    }

class ConstructBinaryTreefromInorderandPostorderTraversal{

    private lateinit var inorder: IntArray
    private lateinit var postorder: IntArray
    private var postIdx = 0
    private var inMap = mutableMapOf<Int, Int>()
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        this.inorder = inorder
        this.postorder = postorder
        this.postIdx = postorder.size-1

        inorder.mapIndexed { index, value -> inMap[value] = index }
        return recursive( 0, postorder.size)
    }

    fun recursive(
        leftIdx: Int,
        rightIdx: Int
    ): TreeNode? {
        if(leftIdx == rightIdx) return null

        val rootValue = postorder[postIdx]
        val rootIndex = inMap[rootValue]!!
        val root = TreeNode(rootValue)
        postIdx--

        root.right = recursive(rootIndex+1, rightIdx)
        root.left = recursive(leftIdx,rootIndex)

        return root
    }
}