fun main(args: Array<String>) {
    val intArray = intArrayOf(0, 1, 0)
    sortColors(intArray)
    intArray.forEach {
        print("$it, ")
    }

}

fun sortColors(nums: IntArray): Unit {
    var lastZeroIndex = -1
    var lastOneIndex = -1

    for (i in 0 until nums.size) {
        val current = nums[i]

        when (current) {
            0 -> {
                if (i - 1 >= 0 && nums[i - 1] == 2) nums[i] = 2

                if (lastOneIndex != -1 && lastOneIndex < i) {
                    lastOneIndex++
                    nums[lastOneIndex] = 1
                }

                lastZeroIndex++
                nums[lastZeroIndex] = 0
            }
            1 -> {
                if (i - 1 >= 0 && nums[i - 1] == 2) nums[i] = 2

                if (lastOneIndex == -1) {
                    lastOneIndex = lastZeroIndex
                }
                lastOneIndex++
                nums[lastOneIndex] = 1
            }
        }
    }
}