/*https://leetcode.com/problems/search-insert-position/

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
*/


fun main(args: Array<String>) {
    println(searchInsert(intArrayOf(1,2,4,6,7),3))

//    println(searchInsert(intArrayOf(1,3,5,6),5))
//    println(searchInsert(intArrayOf(1,3,5,6),2))
//    println(searchInsert(intArrayOf(1,3,5,6),7))
//    println(searchInsert(intArrayOf(1,3,5,6),0))
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var result =-1
    var tempArray = nums
    var left = 0
    var right = nums.size
    while(result == -1){
        if(left == right) result = left
        val position = left + tempArray.size /2
        when {
            nums[position]==target -> result = position
            nums[position]> target ->{
                if(position == 0){
                    result = 0
                }
                if(tempArray.size == 1){
                    result = left
                }
                right = position
                tempArray = nums.copyOfRange(left,right)
            }
            else -> {
                if(position == nums.size-1){
                    result = nums.size
                }
                if(tempArray.size == 1){
                    result = right
                }
                left = position +1
                tempArray = nums.copyOfRange(left,right)

            }
        }
    }

    return result
}