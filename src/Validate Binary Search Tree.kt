import java.util.*

fun main(args: Array<String>) {

}
fun t(t : Any?){
    t as Test1?

}
class Test1{

}
fun isValidBST(root: TreeNode?): Boolean {
    var prevVal:Int?= null
    var curr =root
    val stack : Deque<TreeNode?> = LinkedList()

    while(curr != null || stack.isNotEmpty()){
        while(curr != null){
            stack.push(curr)
            curr = curr.left
        }
        curr = stack.pop()!!

        if(prevVal != null && prevVal >=curr.`val` ) return false

        prevVal = curr.`val`
        curr = curr.right
    }

    return true
}