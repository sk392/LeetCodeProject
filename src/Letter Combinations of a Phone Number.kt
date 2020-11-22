fun main(args: Array<String>) {
    println(letterCombinations("223"))
}

fun letterCombinations(digits: String): List<String> {
    var results = mutableListOf<String>()

    var index = 0
    while (index < digits.length) {
        val list = getStringDigits(digits[index])
        if (results.isEmpty()) {
            list.forEach {
                results.add(it)
            }
        } else {
            val newList = mutableListOf<String>()

            results.forEach { result ->
                list.forEach {
                    newList.add(result + it)
                }
            }

            results = newList
        }

        index++
    }
    return results
}

fun getStringDigits(c: Char): List<String> {
    return when (c) {
        '2' -> listOf("a", "b", "c")
        '3' -> listOf("d", "e", "f")
        '4' -> listOf("g", "h", "i")
        '5' -> listOf("j", "k", "l")
        '6' -> listOf("m", "n", "o")
        '7' -> listOf("p", "q", "r", "s")
        '8' -> listOf("t", "u", "v")
        '9' -> listOf("w", "x", "y", "z")
        else -> emptyList()
    }
}