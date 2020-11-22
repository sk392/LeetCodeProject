import javax.swing.tree.TreeNode

fun main(args: Array<String>) {
    rearrangeBarcodes(intArrayOf(1,1,1,1,2,2,3,3)).forEach {
        print("$it, ")
    }
}

fun rearrangeBarcodes(barcodes: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()

    barcodes.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    val result = IntArray(barcodes.size)

    var tempBarcode = 0
    for (i in 0 until barcodes.size) {
        var barcode = getMostValueWithOutTheNumber(map, tempBarcode)
        map[barcode] = (map[barcode] ?: 0) - 1
        tempBarcode = barcode

        result[i] = barcode
    }

    return result
}

fun getMostValueWithOutTheNumber(map: Map<Int, Int>, withOutNumber: Int): Int {
    var maxValue = 0
    var maxKey = 0

    map.forEach {
        if (maxValue < it.value && it.key != withOutNumber) {
            maxKey = it.key
            maxValue = it.value
        }
    }
    return maxKey
}