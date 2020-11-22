fun main(args: Array<String>) {

    println(largestRectangleArea(intArrayOf(0, 2, 0)))
    println(largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
    println(largestRectangleArea(intArrayOf(4, 2, 0, 3, 2, 4, 3, 4)))
}

fun largestRectangleArea(heights: IntArray): Int {
    if (heights.isEmpty()) return 0

    var result = heights[0]
    for (i in 0 until heights.size) {
        var left = i
        var right = i
        val height = heights[i]

        while (left >= 0 && heights[left] >= height) left--
        while (right < heights.size && heights[right] >= height) right++
        result = Math.max(result, ((right - 1) - (left + 1) + 1) * height)

    }

    return result
}