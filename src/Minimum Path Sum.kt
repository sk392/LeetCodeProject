fun main(args: Array<String>) {
    println(
        minPathSum(
            arrayOf(
                intArrayOf(1, 3, 1),
                intArrayOf(1, 5, 1),
                intArrayOf(4, 2, 1)
            )
        )
    )
}

fun minPathSum(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size

    for (i in 0 until n) {
        for (j in 0 until m) {
            val current = grid[i][j]
            var min = current
            if (i >= 1) {
                min = grid[i - 1][j] + current
            }
            if (j >= 1) {
                min = if (min > current) {
                    Math.min(grid[i][j - 1] + current, min)
                } else {
                    grid[i][j - 1] + current
                }
            }
            grid[i][j] = min
        }
    }

    return grid[n - 1][m - 1]
}
