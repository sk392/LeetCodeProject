fun main(args: Array<String>) {
//    longestConsecutive(intArrayOf(1, 2, 0, 1))
    longestConsecutive(intArrayOf(100,4,200,1,3,2))
//    longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1))
}

fun longestConsecutive(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    val visitMap = mutableMapOf<Int, Boolean>()
    var maxSequence = 0

    nums.forEach {
        map[it] = 1
        visitMap[it] = false
    }

    for (i in 0 until map.keys.size) {
        val currentKey = map.keys.elementAt(i)
        var length = 1
        if (visitMap[currentKey]!!) continue
        visitMap[currentKey] = true

        var newKey = currentKey+1
        while(map.containsKey(newKey)){
            if(!visitMap[newKey]!!){
                visitMap[newKey] = true
                length++
                newKey++
            }else{
                length += map[newKey]!!
                break
            }
        }
        map[currentKey] = length
        maxSequence = Math.max(maxSequence,length)
    }

    return maxSequence
}