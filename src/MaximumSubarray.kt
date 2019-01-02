import kotlin.math.max

/*https://leetcode.com/problems/maximum-subarray/

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

*/

fun main(args: Array<String>) {
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
}

fun maxSubArray(nums: IntArray): Int{
    var maxValue = Int.MIN_VALUE
    var sum = 0
    nums.forEach { value ->
        sum += value

        if(sum >maxValue) maxValue = sum
        if(sum<=0) sum = 0
    }
    return maxValue
}
