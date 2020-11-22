import kotlin.text.Typography.half

fun main(args: Array<String>) {
    println(pivotIndex(intArrayOf(-1,-1,-1,-1,0,0)))
}

fun pivotIndex(nums: IntArray): Int {
    val sum = nums.sum()
    var subSum = 0

    for (i in 0 until nums.size) {
        if((subSum * 2 + nums[i]) == sum) return i
        subSum += nums[i]
    }

    return -1
}