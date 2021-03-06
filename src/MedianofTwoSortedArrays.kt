import javax.swing.text.html.HTML.Attribute.N

/*https://leetcode.com/problems/median-of-two-sorted-arrays/
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

fun main(args: Array<String>) {
    println(findMedianSortedArrays(intArrayOf(1,3),intArrayOf(2)))
    println(findMedianSortedArrays(intArrayOf(1,2),intArrayOf(3,4)))
}
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var resultSort = mutableListOf<Int>()
    val medianSet = mutableListOf<Int>()
    var result = 0.0
    val size = nums1.size + nums2.size
    if(size%2 == 0){
        medianSet.add(size/2)
        medianSet.add(size/2-1)
    }else{
        medianSet.add(size/2)
    }

    var i = 0
    var j = 0
    while (i+j <size){

        if(j== nums2.size){
            resultSort.add(i+j, nums1[i])
            ++i
            continue
        }

        if(i== nums1.size){
            resultSort.add(i+j, nums2[j])
            ++j
            continue
        }

        if(nums1[i] < nums2[j] ){
            resultSort.add(i+j, nums1[i])
            ++i
        }else{
            resultSort.add(i+j, nums2[j])
            ++j
        }
    }
    medianSet.forEach{
        result += resultSort[it]
    }
    return result/medianSet.size
}