fun main(args: Array<String>) {
    println(numTrees(4))

}

fun numTrees(n: Int): Int {
    val dp = MutableList(n + 1) { 1 }

    for (i in 2..n) {
        val excludeRoot = i - 1
        var result = 0
        for (j in 0..excludeRoot) {
            result += dp[j] * dp[excludeRoot - j]
        }
        dp[i] = result
    }

    return dp[n]
}


//2,0 1,1 0,2
//3,0 2,1 1,2 0,3
//4,0 3,1 2,2 1,3 0,4