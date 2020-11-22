import java.util.*

fun main(args: Array<String>) {

}

fun leastInterval(tasks: CharArray, n: Int): Int {
    val heap = MaxHeap(tasks.size)
    val map = mutableMapOf<Char, Int>()
    val queue :Queue<Char> = LinkedList<Char>()
    var time = 0
    tasks.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    map.keys.forEach {
        heap.push(map[it]!!)
    }
    var isNotDone = true


    return 0
}

class MaxHeap(private val maxsize: Int) {
    private val heap: IntArray
    private var size: Int = 0

    init {
        this.size = 0
        heap = IntArray(this.maxsize + 1)
        heap[0] = Integer.MAX_VALUE
    }

    // Returns position of parent
    private fun parent(pos: Int): Int {
        return pos / 2
    }

    // Below two functions return left and
    // right children.
    private fun leftChild(pos: Int): Int {
        return 2 * pos
    }

    private fun rightChild(pos: Int): Int {
        return 2 * pos + 1
    }

    // Returns true of given node is leaf
    private fun isLeaf(pos: Int): Boolean {
        return pos >= (size / 2) && pos <= size
    }

    private fun swap(fpos: Int, spos: Int) {
        val tmp: Int = heap[fpos]
        heap[fpos] = heap[spos]
        heap[spos] = tmp
    }

    // A recursive function to max heapify the given
    // subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need
    // to fix the root.
    private fun maxHeapify(pos: Int) {
        if (isLeaf(pos))
            return

        if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {

            if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                swap(pos, leftChild(pos))
                maxHeapify(leftChild(pos))
            } else {
                swap(pos, rightChild(pos))
                maxHeapify(rightChild(pos))
            }
        }
    }

    // Inserts a new element to max heap
    fun push(element: Int) {
        heap[++size] = element

        // Traverse up and fix violated property
        var current = size
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current))
            current = parent(current)
        }
    }

    // Remove an element from max heap
    fun pop(): Int {
        val popped = heap[1]
        heap[1] = heap[size--]
        maxHeapify(1)
        return popped
    }

}