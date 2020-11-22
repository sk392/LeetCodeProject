fun main(args: Array<String>) {
    println(minWindow("ADOBECODEBANC", "ABC"))
}

fun minWindow(s: String, t: String): String {
    val map = mutableMapOf<Char, Int>()
    var count = t.length
    var left = 0
    var right = 0
    var result = ""
    t.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    while (right <= s.length) {
        if (count == 0) {
            val char = s[left++]
            if (map.containsKey(char)) {
                map[char] = map.getOrDefault(char, 0) + 1

                if (map[char] ?: 0 > 0) count++
            }
        } else {
            if (right == s.length) return result
            val char = s[right++]
            if (map.containsKey(char)) {
                map[char] = map.getOrDefault(char, 0) - 1

                if (map[char] ?: 0 >= 0) count--
            }
        }

        if (count == 0 && (result.isEmpty() || right - left < result.length)) {
            result = s.slice(left until right)
        }
    }

    return result
}