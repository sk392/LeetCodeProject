/* https://leetcode.com/problems/two-sum/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
fun main(args: Array<String>) {

    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9

    twoSum(nums, target).forEachIndexed { index, value ->
        println("$index = $value")
    }

}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val calcMap: MutableMap<Int, Int> = HashMap()
    var result = intArrayOf()

    for (i in 0 until nums.size-1) {
        calcMap.put(target - nums[i], i)
    }

    nums.forEachIndexed { index, i ->
        if (calcMap.containsKey(i) && calcMap.get(i) != index) {
            result = intArrayOf(calcMap.get(i)!!, index)
        }
    }
    return result

}