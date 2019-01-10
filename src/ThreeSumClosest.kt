import kotlin.math.abs

/*https://leetcode.com/problems/3sum-closest/

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/


fun main(args: Array<String>) {
    println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    var result: Int? = null
    for (i in 0 until nums.size) {
        var left = i + 1
        var right = nums.size - 1
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            when {
                sum == target -> {
                    return target
                }
                sum < target -> {
                    if (result == null || abs(target - result) > abs(target - sum)) {
                        result = sum
                    }
                    left++
                }
                sum > target -> {
                    if (result == null || abs(target - result) > abs(target - sum)) {
                        result = sum
                    }
                    right--
                }

            }
        }
    }
    return result ?: 0
}