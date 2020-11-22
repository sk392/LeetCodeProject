import java.util.*

fun main(args: Array<String>) {
    searchRange(intArrayOf(5,7,7,8,8,10), 8).forEach {
        println(it)
    }
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    var l = 0
    var r = nums.size - 1
    var targetIndex = -1
    val mutableList =  mutableListOf<Int>(1,2,3,4)
    mutableList.apply {
        size
        this[1] = 2
    }

    loop@ while (l <= r) {
        val mid = (l + r) / 2
        val value = nums[mid]
        when {
            value == target -> {
                targetIndex = mid
                break@loop
            }
            value > target -> {
                r = mid - 1
            }
            value < target -> {
                l = mid + 1
            }
        }
    }
    if (targetIndex != -1) {
        l = targetIndex
        r = targetIndex
        while (l >= 0 && nums[l] == target) {
            l--
        }
        while (r < nums.size && nums[r] == target) {
            r++
        }
        return intArrayOf(l + 1, r - 1)
    } else {
        return intArrayOf(-1, -1)
    }
}