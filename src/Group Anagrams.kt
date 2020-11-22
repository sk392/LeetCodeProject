fun main(args: Array<String>) {
    groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()
    val result = mutableListOf<List<String>>()
    strs.forEach {
        val sorted = it.toCharArray().sorted().toString()
        if (map.containsKey(sorted)) {
            val list = map[sorted] ?: mutableListOf()
            list.add(it)
        } else {
            map[sorted] = mutableListOf(it)
        }
    }

    map.keys.forEach {
        result.add(map[it] ?: listOf())
    }
    return result
}