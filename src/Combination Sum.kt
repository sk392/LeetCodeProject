fun main(args: Array<String>) {
    combinationSum(intArrayOf(2, 3, 5), 8).forEach { list ->
        list.forEach {
            print(it)
        }
        println()
    }
}

val combinationSumResult = mutableListOf<List<Int>>()

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    combinationCalculate(candidates, target, mutableListOf(), 0)
    return combinationSumResult
}

fun combinationCalculate(candidates: IntArray, target: Int, list: MutableList<Int>, startIndex: Int) {
    when {
        target < 0 -> return
        target == 0 -> combinationSumResult.add(list.toList())
        else -> {
            for (i in startIndex until candidates.size) {
                val value = candidates[i]
                if (value <= target) {
                    list.add(value)
                    combinationCalculate(candidates, target - value, list, i)
                    list.removeAt(list.size - 1)
                }
            }
        }
    }
}