fun main(args: Array<String>) {
    println(maxResult(intArrayOf(7, 3, 1, 2, 3, 4, 5)))
    println(maxResult(intArrayOf(5, 4, 3, 2, 1)))
    println(maxResult(intArrayOf(1, 2, 3, 4, 5)))
}


fun maxResult(array: IntArray): Int {
    var minValue = Int.MAX_VALUE
    var result = 0

    for (i in 0 until array.size) {
        val curr = array[i]

        if (minValue > curr) {
            minValue = curr
        }

        result = Math.max(result, curr - minValue)
    }

    return result
}