import java.util.*

fun main(args: Array<String>) {

    val pair = Pair(false, false)

    when (pair) {
        true to false -> {
            println("true , false")
        }
        false to false -> {
            println("false , false")
        }
    }


    permute(intArrayOf(1, 2, 3)).forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }
}

fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    recurs(nums, mutableListOf(), result)
    return result
}

fun recurs(nums: IntArray, prev: List<Int>, result: MutableList<List<Int>>) {
    if (prev.size == nums.size) {
        result.add(prev)
        return
    }

    for (i in 0 until nums.size) {
        if (!prev.contains(nums[i])) {
            val copyList = prev.toMutableList()
            copyList.add(nums[i])
            recurs(nums, copyList, result)
        }
    }

}


//
//fun permute(nums: IntArray): List<List<Int>> {
//    val result = mutableListOf<List<Int>>()
//    when (nums.size) {
//        0 -> return emptyList()
//        1 -> return listOf(listOf(nums[0]))
//        else -> {
//            val init = nums.copyOf()
//            do {
//                result.add(nums.toList())
//            } while (!init.contentEquals(nextPermutation1(nums)))
//        }
//    }
//    return result
//}
//
//fun nextPermutation1(nums: IntArray): IntArray {
//    if (nums.size in 0..1) return nums
//    for (i in (nums.size - 2) downTo 0) {
//        val prev = nums[i + 1]
//        val value = nums[i]
//        var minValue = Int.MAX_VALUE
//        var minIndex = -1
//
//        for (j in i + 1 until nums.size) {
//            val tempValue = nums[j]
//            if (tempValue in (value + 1)..(minValue - 1)) {
//                minValue = tempValue
//                minIndex = j
//            }
//        }
//
//        if (prev > value) {
//            nums[i] = minValue
//            nums[minIndex] = value
//            val list = nums.toMutableList().subList(i + 1, nums.size)
//            if (list.size > 1) {
//                list.sort()
//                for (j in 0 until list.size) {
//                    nums[j + i + 1] = list[j]
//                }
//            }
//            return nums
//        }
//    }
//    nums.sort()
//    return nums
//}
//
