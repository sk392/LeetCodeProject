fun main(args: Array<String>) {
    merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))).forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }
    merge(arrayOf(intArrayOf(1,4), intArrayOf(2,3))).forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }
    merge(arrayOf(intArrayOf(1,4), intArrayOf(0,0))).forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }


}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.size in 0..1) return intervals

    val result = mutableListOf<IntArray>()
    var array = mutableListOf<Int>()
    var maximumIndex = 0

    for (i in 0 until intervals.size) {
        val current = intervals[i]
        if (array.isEmpty()) {
            array.add(current[0])
        } else {
            if(array[0] > current[0] && current[1] >= array[0]){
                array[0] = current[0]
            }
            if (current[0] > maximumIndex) {
                array.add(maximumIndex)
                result.add(array.toIntArray())
                array = mutableListOf()
                array.add(current[0])
            }
        }
        maximumIndex = Math.max(maximumIndex,current[1])

        if (i == intervals.size - 1) {
            array.add(maximumIndex)
            result.add(array.toIntArray())
        }
    }
    return result.toTypedArray()
}