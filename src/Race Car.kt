fun main(args: Array<String>) {

    println(racecar(0))
}

fun racecar(target: Int): Int {
    val dp = IntArray(target + 1) // min steps to get i
    dp[0] = 0

    for (i in 1..target) {

        var rightPosition = 0
        var rightSteps = 0
        while (rightPosition < i) {
            rightSteps++
            rightPosition = (1 shl rightSteps) - 1
        }
        if (rightPosition == i) {
            dp[i] = rightSteps
            continue
        }

        dp[i] = rightSteps + 1 + dp[rightPosition - i]


        val leftSteps = rightSteps - 1
        val leftPosition = (1 shl leftSteps) - 1

        for (j in 0 until leftSteps) {
            val reversePosition = leftPosition - ((1 shl j) - 1)
            dp[i] = Math.min(dp[i], leftSteps + 1 + j + 1 + dp[i - reversePosition])
        }
    }
    return dp[target]
}
