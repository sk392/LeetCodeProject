fun main(args: Array<String>) {

}

fun isHappy(n: Int): Boolean {
    val set = mutableSetOf<Int>()
    var nextValue = n

    while (!set.contains(nextValue)) {
        set.add(nextValue)
        var newValue = 0
        while (nextValue > 0) {
            newValue += Math.pow((nextValue % 10).toDouble(), 2.0).toInt()
            nextValue /= 10
        }
        nextValue = newValue
        if(nextValue == 1) return true
    }
    return false
}