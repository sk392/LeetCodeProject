import kotlin.math.max

fun main(args: Array<String>) {
    println(canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(canJump(intArrayOf(3, 2, 1, 0, 4)))
}

fun canJump(nums: IntArray): Boolean {
    val size = nums.size
    var maximumJumpIndex = 0

    for (i in 0 until size) {
        if (i > maximumJumpIndex) break

        maximumJumpIndex = Math.max(maximumJumpIndex, i + nums[i])
    }

    return maximumJumpIndex >= size - 1
}

