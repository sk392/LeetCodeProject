fun main(args: Array<String>) {
    println(validUtf8(intArrayOf(197, 130, 1)))
    println(validUtf8(intArrayOf(235, 140, 4)))
    println(validUtf8(intArrayOf(250, 145, 145, 145, 145)))
}

fun validUtf8(data: IntArray): Boolean {
    val bits = mutableListOf<String>().apply {
        data.forEach {
            var str = Integer.toBinaryString(it)
            for (i in 0 until (8 - str.length)) {
                str = "0$str"
            }

            this.add(str)
        }
    }
    var bitCount = 0

    bits.forEach { bit ->
        if (bitCount == 0) {
            val zeroIndex = bit.toCharArray().indexOfFirst { it == '0' }

            bitCount = when {
                zeroIndex < 0 || zeroIndex > 4 || zeroIndex == 1 -> -1
                zeroIndex > 1 -> zeroIndex - 1
                else -> zeroIndex
            }

        } else if (bitCount > 0) {
            bitCount = if (bit.subSequence(0, 2) == "10") {
                bitCount - 1
            } else {
                -1
            }
        }
    }

    return bitCount == 0
}