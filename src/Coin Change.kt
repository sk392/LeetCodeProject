fun main(args: Array<String>) {
    change(5, intArrayOf(1, 2, 5))
}

fun change(amount: Int, coins: IntArray): Int {
    val dp = IntArray(amount + 1) { if (it == 0) 1 else 0 }

    for (c in coins)
        for (i in c until dp.size)
            if (i -c >= 0)
                dp[i] += dp[i - c]

    return dp[amount]
}
//
//fun change(amount: Int, coins: IntArray): Int {
//    val dp = IntArray(amount + 1) { if (it == 0) 1 else 0 }
//
//    for (i in 0 until dp.size)
//        for (c in coins)
//            if (i -c >= 0)
//                dp[i] += dp[i - c]
//
//    return dp[amount]
//}