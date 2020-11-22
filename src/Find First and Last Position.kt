fun main(args: Array<String>) {
    searchRange1(intArrayOf(5, 7, 7, 8, 8, 10), 6).forEach {
        print("$it ,")
    }
}

var min = Integer.MAX_VALUE
var max = Integer.MIN_VALUE

fun searchRange1(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty() || nums.first() > target || nums.last() < target) return intArrayOf(-1, -1)

    recursive(0, nums.size, nums, target)
    if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
        return intArrayOf(-1, -1)
    }
    return intArrayOf(min, max)
}

fun recursive(s: Int, e: Int, nums: IntArray, target: Int) {
    if (s == e) return
    val curr = (s + e) / 2

    when {
        nums[curr] > target -> {
            recursive(s, curr, nums, target)
        }

        nums[curr] < target -> {
            recursive(curr + 1, e, nums, target)
        }
        else -> {
            min = Math.min(min, curr)
            max = Math.max(max, curr)
            recursive(s, curr, nums, target)
            recursive(curr + 1, e, nums, target)
        }
    }
}