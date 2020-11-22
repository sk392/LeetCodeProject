fun main(args: Array<String>) {
    moveZeroes(intArrayOf(0, 1, 0, 3, 12))
}

fun moveZeroes(nums: IntArray): Unit {
    val set = mutableListOf<Int>()
    nums.forEachIndexed { index, value ->
        if (value == 0) set.add(index)
    }
    for (i in 0 until set.size) {
        val index = set[i]
        val startIndex = index - i
        val endIndex = nums.size - i - 1

        for (j in startIndex until endIndex) {
            nums[j] = nums[j + 1]
        }
        nums[endIndex] = 0
    }
}