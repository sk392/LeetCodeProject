fun main(args: Array<String>) {
//    println(longestPalindrome("babad"))
//    println(longestPalindrome("cbbd"))
    println(longestPalindrome("aaaa"))
}

fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return ""

    val chars = s.toCharArray()
    val map = mutableMapOf<Int, MutableList<Pair<Int, Int>>?>()

    //find size 2 & 3
    for (i in 0 until chars.size) {
        if (i + 1 < chars.size && chars[i] == chars[i + 1]) {
            if (map[2] == null) map[2] = mutableListOf()

            map[2]!!.add(Pair(i, i + 1))
        }
        if (i + 2 < chars.size && chars[i] == chars[i + 2]) {
            if (map[3] == null) map[3] = mutableListOf()

            map[3]!!.add(Pair(i, i + 2))
        }
    }

    if (map.isEmpty()) return chars[0].toString()

    if (chars.size >= 4) {
        for (i in 4..chars.size) {
            map[i - 2]?.forEach {
                val start = it.first - 1
                val end = it.second + 1
                if (start >= 0 && end < chars.size && chars[start] == chars[end]) {
                    if (map[i] == null) map[i] = mutableListOf()
                    map[i]!!.add(Pair(start, end))
                }
            }


        }
    }

    val resultKey = map.keys.max() ?: 0

    return s.substring(map[resultKey]?.get(0)?.first ?: 0, (map[resultKey]?.get(0)?.second ?: 0) + 1)
}