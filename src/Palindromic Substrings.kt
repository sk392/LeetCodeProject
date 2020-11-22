fun main(args: Array<String>) {
    countSubstrings("aaa")
}

var palindromeCnt = 0
fun countSubstrings(s: String): Int {
    val chars = s.toCharArray()
    var leftIdx: Int
    var rightIdx: Int
    var prev: Char? = null
    for (i in 0 until chars.size) {
        val curr = chars[i]
        if (prev != null && prev == curr) {
            leftIdx = i - 1
            rightIdx = i
            palindromeCnt++
            isPalindrome(leftIdx, rightIdx, chars)
        }

        leftIdx = i
        rightIdx = i

        palindromeCnt++
        isPalindrome(leftIdx, rightIdx, chars)

        prev = curr
    }
    return palindromeCnt
}

private fun isPalindrome(leftIdx: Int, rightIdx: Int, chars: CharArray) {
    var leftIdx = leftIdx
    var rightIdx = rightIdx
    do {
        leftIdx--
        rightIdx++

        if (leftIdx >= 0 && rightIdx < chars.size && chars[leftIdx] == chars[rightIdx]) {
            palindromeCnt++
        } else {
            break
        }
    } while (leftIdx > 0 && rightIdx < chars.size - 1)
}