import java.util.*

fun main(args: Array<String>) {
    println(orangesRotting(arrayOf(intArrayOf(2,1,1),intArrayOf(1,1,0),intArrayOf(0,1,1))))
}

fun orangesRotting(grid: Array<IntArray>): Int {
    var freshOranges = 0
    val rotQueue: Queue<Int> = ArrayDeque()
    val row = grid.size
    val column = grid[0].size
    var time = 0

    for (r in 0 until row) {
        for (c in 0 until column) {
            if (grid[r][c] == 2) {
                rotQueue.add(r * column + c)
            }
            if (grid[r][c] == 1) {
                freshOranges++
            }
        }
    }

    val dirs = arrayOf(intArrayOf(0,1),intArrayOf(0,-1),intArrayOf(1,0),intArrayOf(-1,0))
    while (freshOranges !=0 && rotQueue.isNotEmpty()) {
        for( i in 0 until rotQueue.size){
            val curr = rotQueue.poll()

            for(dir in dirs) {
                val r = curr / column + dir[0]
                val c = curr % column + dir[1]

                if(r in 0 until row && c in 0 until column && grid[r][c] == 1){
                    grid[r][c] = 2
                    rotQueue.add(r* column + c)
                    freshOranges--
                }
            }
        }

        time++
    }

    return if(freshOranges == 0) time else -1
}