import java.util.*

fun main(args: Array<String>) {
    println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap(intArrayOf(2, 0, 2)))
    println(trap(intArrayOf(4, 2, 3)))
    println(trap(intArrayOf(4, 2, 3, 1, 2)))
}

var resultTrapping = 0

fun trap(height: IntArray): Int {
    val heights = ArrayDeque<Pair<Int, Int>>()

    for (i in 0 until height.size) {
        val current = height[i]
        if (i - 1 >= 0) {
            val prev = height[i - 1]

            if (current > prev) {
                while (!heights.isEmpty() && heights.peek().second <= current) {
                    trapping(heights.pop(), i, current, height)
                }
                if (!heights.isEmpty()) {
                    trapping(heights.peek(), i, current, height)
                }
            }
        }

        if (current > 0) {
            heights.push(Pair(i, current))
        }
    }
    return resultTrapping
}

fun trapping(temp: Pair<Int, Int>, i: Int, current: Int, height: IntArray) {
    val min = Math.min(temp.second, current)

    for (j in temp.first..i) {
        val value = min - height[j]
        if (value > 0) {
            resultTrapping += value
            height[j] = min
        }
    }
}