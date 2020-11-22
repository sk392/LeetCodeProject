import java.util.Arrays

fun main(args: Array<String>) {
//
//    println(
//        maximalRectangle(
//            arrayOf(
//                charArrayOf('1', '0', '1', '0', '0'),
//                charArrayOf('1', '0', '1', '1', '1'),
//                charArrayOf('1', '1', '1', '1', '1'),
//                charArrayOf('1', '0', '0', '1', '0')
//            )
//        )
//    )
//
    println(
        maximalRectangle(
            arrayOf(
                charArrayOf('1', '1', '0', '1'),
                charArrayOf('1', '1', '0', '1'),
                charArrayOf('1', '1', '1', '1')
            )
        )
    )
//    println(
//        maximalRectangle(
//            arrayOf(
//                charArrayOf('0', '1'),
//                charArrayOf('0', '1')
//            )
//        )
//    )

//    println(
//        maximalRectangle(
//            arrayOf(
//                charArrayOf('1', '1', '1', '1', '1', '1', '1', '1'),
//                charArrayOf('1', '1', '1', '1', '1', '1', '1', '0'),
//                charArrayOf('1', '1', '1', '1', '1', '1', '1', '0'),
//                charArrayOf('1', '1', '1', '1', '1', '0', '0', '0'),
//                charArrayOf('0', '1', '1', '1', '1', '0', '0', '0')
//            )
//        )
//    )


}

fun maximalRectangle(matrix: Array<CharArray>): Int {
    if(matrix.isEmpty()) return 0

    val n = matrix[0].size
    val left = IntArray(n)
    val right = IntArray(n) { n }
    val height = IntArray(n)
    var result = 0

    for (aMatrix in matrix) {
        var curLeft = 0
        var curRight = n
        for (j in 0 until n) {
            if (aMatrix[j] == '1') {
                left[j] = Math.max(left[j], curLeft)
                height[j]++
            } else {
                left[j] = 0
                curLeft = j + 1
                height[j] = 0
            }
        }
        for (j in n - 1 downTo 0) {
            if (aMatrix[j] == '1') {
                right[j] = Math.min(right[j], curRight)
            } else {
                right[j] = n
                curRight = j
            }
        }
        for (j in 0 until n) {
            result = Math.max(result, (right[j] - left[j]) * height[j])
        }
    }
    return result
}
