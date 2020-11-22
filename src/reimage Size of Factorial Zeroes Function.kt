fun main(args: Array<String>) {
    var result :Int = 1
    for (i in 1..24){
        result *= i
    }
}

fun preimageSizeFZF(K: Int): Int {
    // sanity check
    if (K < 0) return 0
    var l = K / 5 * 3
    var r = K
    while (l <= r) {
        val mid = l + (r - l) / 2
        val count = countFive(mid)
        when {
            count == K -> return 5
            count > K -> r = mid - 1
            else -> l = mid + 1
        }
    }
    return 0
}

private fun countFive(bound: Int): Int {
    var tempBound = bound
    var res = tempBound
    while (tempBound > 0) {
        res += tempBound / 5
        tempBound /= 5
    }
    return res
}