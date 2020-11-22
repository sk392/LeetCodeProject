import java.util.*

fun main(args: Array<String>) {
    println(longestValidParentheses("(()"))
    println(longestValidParentheses(")()())"))
    println(longestValidParentheses("()(()"))
    println(longestValidParentheses(")("))
    println(longestValidParentheses("((()))())"))
}

fun longestValidParentheses(s: String): Int {
    if (s.length in 0..1) return 0
    var longestResult = 0
    var startIndex = -1

    val stack: ArrayDeque<Int> = ArrayDeque()

    for (index in 0 until s.length) {
        if (s[index] == '(') {
            stack.push(index)
        } else {
            if (stack.isNotEmpty()) {
                stack.pop()

                val length = if (stack.isNotEmpty()) {
                    index - stack.peek()
                } else {
                    index - startIndex
                }

                longestResult = Math.max(longestResult, length)
            }else{
                startIndex = index
            }
        }
    }

    return longestResult
}
