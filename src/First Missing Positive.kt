fun main(args: Array<String>) {
    println(firstMissingPositive(intArrayOf(1, 2, 0)))
}

fun firstMissingPositive(nums: IntArray): Int {
    val size = nums.size

    for (i in 0 until size) {
        var num = nums[i]
        if (num > size || num <= 0) {
            nums[i] = size + 1
        }
    }

    for (i in 0 until size) {
        var num = Math.abs(nums[i])
        if (num == size + 1) {
            continue
        }

        num--
        if (nums[num] > 0) {
            nums[num] *= -1
        }
    }
    for (i in 0 until size) {
        if (nums[i] > 0) {
            return i + 1
        }
    }

    return size + 1
}


/*
fun firstMissingPositive(nums: IntArray): Int {
    val result = mutableSetOf<Int>()

    for( i in 1..nums.size){
        result.add(i)
    }

    for(number in nums){
        result.remove(number)
    }

    return result.min() ?: nums.size+1
}



*/