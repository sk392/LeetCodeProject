/*https://leetcode.com/problems/4sum/
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

fun main(args: Array<String>) {
//    println(fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))
    println(fourSum(intArrayOf(0, 0, 0, 0), 0))
//    println(fourSum(intArrayOf(-1,0,1,2,-1,-4), -1))
//    println(fourSum(intArrayOf(-3, -2, -1, 0, 0, 1, 2, 3), 0))
//    println(fourSum(intArrayOf(-1,2,2,-5,0,-1,4), 3))
}

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    nums.sort()
    val result = mutableListOf<List<Int>>()

    for (i in 0 until nums.size) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        for (j in i + 1 until nums.size) {
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue
            }
            var left = j + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[j] + nums[left] + nums[right]

                when {
                    sum == target -> {
                        result.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        while(left <right && nums[left] == nums[left+1]) left++
                        while(left <right && nums[right] == nums[right-1]) right--

                        right--
                        left++
                    }
                    sum > target -> right--

                    sum < target -> left++
                }
            }
        }
    }
    return result
}