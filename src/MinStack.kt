class MinStack() {
    private val stack = mutableListOf<Int>()
    private val index: Int
        get() = stack.size - 1
    private val minMap = mutableMapOf<Int, Int>()

    fun push(x: Int) {
        stack.add(x)
        minMap[index] = Math.min(minMap[index - 1] ?: Int.MAX_VALUE, x)
    }

    fun pop() {
        stack.removeAt(index)
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minMap[index] ?: 0
    }
}
