fun main(args: Array<String>) {
    val a = intArrayOf(1, 2, 4, 3)
    val b = intArrayOf(3,2,1)
    nextPermutation(b)
//    nextPermutation(a)
    b.forEach {
        println(it)
    }
}

fun nextPermutation(nums: IntArray) {
    if (nums.size in 0..1) return
    for (i in (nums.size - 2) downTo 0) {
        val prev = nums[i + 1]
        val value = nums[i]
        var minValue = Int.MAX_VALUE
        var minIndex = -1

        for (j in i + 1 until nums.size) {
            val tempValue = nums[j]
            if (tempValue in (value + 1)..(minValue - 1)) {
                minValue = tempValue
                minIndex = j
            }
        }

        if (prev > value) {
            nums[i] = minValue
            nums[minIndex] = value
            val list= nums.toMutableList().subList(i+1, nums.size)
            if(list.size>1){
                list.sort()
                for(j in 0 until list.size){
                    nums[j+i+1] = list[j]
                }
            }
            return
        }
    }

    nums.sort()
}

/*
1234
1243
1324
1342
1423
1432
2134
2143
2314
2341
2413
2431

*
* */