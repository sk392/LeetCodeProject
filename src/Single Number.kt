

fun singleNumber(nums: IntArray): Int {
    var sum = 0
    for (i in 0 until nums.size) {
        sum = sum xor nums[i]
    }
    return sum
}