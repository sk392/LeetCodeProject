fun main(args: Array<String>) {
    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "ABCCED"
        )
    )
    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "SEE"
        )
    )
    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "ABCB"
        )
    )
    println(
        exist(
            arrayOf(
                charArrayOf('C', 'A', 'A'),
                charArrayOf('A', 'A', 'A'),
                charArrayOf('B', 'C', 'D')
            ), "AAB"
        )
    )

}

fun exist(board: Array<CharArray>, word: String): Boolean {
    val visitMap = MutableList(board.size) { MutableList(board[0].size) { false } }
    var result = false

    for (i in 0 until board.size) {
        for (j in 0 until board[0].size) {
            if (board[i][j] == word[0]) {
                result = result || findNextWord(0, word, board, Pair(i, j), getDeepCopyList(visitMap))
            }
        }
    }

    return result
}

fun findNextWord(
    wordIndex: Int,
    word: String,
    board: Array<CharArray>,
    currentPosition: Pair<Int, Int>,
    visitMap: List<MutableList<Boolean>>
): Boolean {
    val x = currentPosition.first
    val y = currentPosition.second

    if (x < 0 || x >= board.size || y < 0 || y >= board[0].size || wordIndex >= word.length || board[x][y] != word[wordIndex] || visitMap[x][y]) return false

    visitMap[x][y] = true
    if(wordIndex == word.length-1) return true

    return findNextWord(wordIndex + 1, word, board, Pair(x + 1, y), getDeepCopyList(visitMap))
            || findNextWord(wordIndex + 1, word, board, Pair(x, y + 1), getDeepCopyList(visitMap))
            || findNextWord(wordIndex + 1, word, board, Pair(x - 1, y), getDeepCopyList(visitMap))
            || findNextWord(wordIndex + 1, word, board, Pair(x, y - 1), getDeepCopyList(visitMap))
}

fun getDeepCopyList(list: List<MutableList<Boolean>>): List<MutableList<Boolean>> {
    val newList = mutableListOf<MutableList<Boolean>>()
    list.forEach {
        newList.add(it.toMutableList())
    }
    return newList
}