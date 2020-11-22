fun main(args: Array<String>) {
    println(getAvailableFlowers(intArrayOf(1,0,0,0,1),1))
    println(getAvailableFlowers(intArrayOf(1,0,0,0,1),2))
    println(getAvailableFlowers(intArrayOf(1,0,0,0,1),0))
    println(getAvailableFlowers(intArrayOf(1,0,0,0,1,1,0,0,1,0,0,0),0))
    println(getAvailableFlowers(intArrayOf(1,0,0,0,1,1,0,0,1,0,0,0),2))
    println(getAvailableFlowers(intArrayOf(1,0,0,0,1,1,0,0,1,0,0,0),1))
    println(getAvailableFlowers(intArrayOf(1,0,0,0,1,1,0,0,1,0,0,0),3))
    println(getAvailableFlowers(intArrayOf(1,0,0,0,1,1,0,0,1,0,0,0),4))
}


fun getAvailableFlowers(array: IntArray, n: Int): Boolean {
    if (n == 0) return true
    val arrayTwo = mutableListOf(0)
    array.forEach {
        arrayTwo.add(it)
    }
    arrayTwo.add(0)

    var count = 0
    for (i in 1 until arrayTwo.size - 1) {
        if (array[i - 1] == 0 && array[i] == 0 && array[i + 1] == 0) {
            array[i] = 1
            count++
        }
    }

    return count >= n
}