fun main(args: Array<String>) {

}

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var buyPrice = Int.MAX_VALUE

    for (i in 0 until prices.size) {
        buyPrice = Math.min(buyPrice, prices[i])
        maxProfit = Math.max(maxProfit, prices[i] - buyPrice)
    }

    return maxProfit
}