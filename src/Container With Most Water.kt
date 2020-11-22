fun main(args: Array<String>) {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}

fun maxArea(height: IntArray): Int {
    var result = 0

    for (i in 0 until height.size) {
        if (height[i] * (height.size - i) < result) continue
        for (j in i + 1 until height.size) {

            val area = (j - i) * Math.min(height[i], height[j])

            if (area > result) {
                result = area
            }
        }
    }

    return result
}