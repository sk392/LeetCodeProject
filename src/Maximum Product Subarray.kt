import kotlin.math.roundToInt
import kotlin.math.roundToLong

fun main(args: Array<String>) {
//    println(maxProduct(intArrayOf(2, 3, -2, 4)))
//    println(maxProduct(intArrayOf(-2, 0, -1)))
//    println(maxProduct(intArrayOf(-4, -3)))
//    println(maxProduct(intArrayOf(2, -1, 4)))
//    println(maxProduct(intArrayOf(0, 2)))
//    println(maxProduct(intArrayOf(-2)))
    println(maxProduct(intArrayOf(1, 0, 4, 5, 2, 0, 3, 2, 4, 0, 3, 4)))
}

fun maxProduct(nums: IntArray): Int {
    var localProduct = 1
    var globalProduct = 1
    var maxProduct = Int.MIN_VALUE

    for (num in nums) {
        if (num == 0) {
            localProduct = 1
            globalProduct = 1
            maxProduct = Math.max(maxProduct, 0)
            continue
        } else {
            globalProduct *= num
            localProduct *= num

            val sameSign = localProduct < 0 && globalProduct < 0 || localProduct > 0 && globalProduct > 0

            if (sameSign) {
                localProduct = num
            }
        }
        maxProduct = Math.max(maxProduct, Math.max(globalProduct, localProduct))
    }
    return maxProduct
}
