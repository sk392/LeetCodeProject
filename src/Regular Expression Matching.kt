fun main(args: Array<String>) {
//    println(isMatch("aa", "a"))
//    println(isMatch("aa", "a*"))
//    println(isMatch("aa", ".*"))
    println(isMatch("aab", "c*a*b"))
//    println(isMatch("mississippi", "mis*is*p*"))
}

fun isMatch(s: String, p: String): Boolean {
    if (s.isEmpty() && p.isEmpty()) return true

    val dp = List(s.length + 1) { BooleanArray(p.length + 1) }
    dp[0][0] = true

    for (j in 2..p.length) {
        dp[0][j] = dp[0][j - 2] && p[j - 1] == '*'
    }

    for (i in 1..s.length) {
        for (j in 1..p.length) {
            val sc = s[i - 1]
            val pc = p[j - 1]

            if (pc == '*') {
                //never use * or use it at least once
                dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p[j - 2] == sc || p[j - 2] == '.'))
            } else if (sc == pc || pc == '.') {
                dp[i][j] = dp[i - 1][j - 1]
            }

        }
    }
    dp.forEach {array ->
        array.forEach {
            print("$it / ")
        }
        println()
    }
    return dp[s.length][p.length]
}

