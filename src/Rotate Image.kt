fun main(args: Array<String>) {
    val a = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    rotate(a)
    a.forEach { list ->
        list.forEach {
            print(it)
        }
        println()
    }

}

fun rotate(matrix: Array<IntArray>) {
    var n = 0
    val size = matrix.size
    val s = size - 1

    while (n < (size / 2)) {
        for (x in n until size - 1 - n) {
            val temp = matrix[s - x][n]

            matrix[s - x][n] = matrix[s - n][s - x]
            matrix[s - n][s - x] = matrix[x][s - n]
            matrix[x][s - n] = matrix[n][x]
            matrix[n][x] = temp
        }
        n++
    }
}

