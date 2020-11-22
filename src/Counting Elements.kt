fun main(args: Array<String>) {
    fun countElements(arr: IntArray): Int {
        var result = 0
        val map = mutableMapOf<Int, Int>()

        arr.forEach { map[it] = (map[it] ?: 0) + 1 }
        map.keys.forEach { if (map.containsKey(it - 1)) result += map[it - 1]!! }

        return result
    }
}