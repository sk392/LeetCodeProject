fun main(args: Array<String>) {
//    println(search(intArrayOf(1, 3, 5), 6))
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 2))
}

fun search(nums: IntArray, target: Int): Int {
    var leftIndex = 0
    var rightIndex = nums.size - 1
    var midIndex: Int

    while (leftIndex <= rightIndex) {
        midIndex = (leftIndex + rightIndex) / 2
        when {
            nums[midIndex] == target -> {
                return midIndex
            }
            nums[midIndex] > nums[rightIndex] && (target < nums[leftIndex] || target > nums[midIndex]) -> {
                leftIndex = midIndex + 1
            }
            nums[midIndex] > nums[rightIndex] -> {
                rightIndex = midIndex - 1
            }
            nums[midIndex] <= nums[rightIndex] && (target > nums[rightIndex] || target < nums[midIndex]) -> {
                rightIndex = midIndex - 1
            }
            nums[midIndex] <= nums[rightIndex] -> {
                leftIndex = midIndex + 1
            }
        }
    }

    return -1
}