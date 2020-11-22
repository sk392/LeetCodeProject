fun main(args: Array<String>) {
//    println(lengthOfLongestSubstring("abcabcbb"))
//    println(lengthOfLongestSubstring("bbbbb"))
//    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring("aab"))
}

fun lengthOfLongestSubstring(s: String): Int {
    var longestLength = 0
    var subChars = mutableMapOf<Char, Int>()

    for (i in 0 until s.length) {
        val char = s[i]
        if (subChars.containsKey(char)) {
            val values = subChars.toList()
            val startIndex = (subChars[char] ?: 0)
            values.forEach {
                if (it.second > startIndex) return@forEach

                subChars.remove(it.first)
            }
        }
        subChars[char] = i

        longestLength = Math.max(longestLength, subChars.size)
    }

    return longestLength
}