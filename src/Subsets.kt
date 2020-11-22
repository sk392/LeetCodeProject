

fun main(args: Array<String>) {
    subsets(intArrayOf(1,2,3)).forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }
}


fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    result.add(listOf())

    for(i in 0 until nums.size){
        val value = nums[i]
        for(item in result.toList()){
            val list = item.toMutableList()
            list.add(value)
            result.add(list)
        }
    }
    return result
}
