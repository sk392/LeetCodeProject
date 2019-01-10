import java.lang.StringBuilder

/*https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

fun main(args: Array<String>) {
    generateParenthesis(3).forEach {
        println(it)
    }
    println("------------")

}

val result = mutableListOf<String>()

fun generateParenthesis(n: Int): List<String> {

    calc(n, n, "")

    return result
}

fun calc(openCnt: Int, closeCnt: Int, s: String) {

    if (openCnt == 0 && closeCnt == 0) {
        result.add(s)
    } else if (openCnt == 0) {
        calc(openCnt, closeCnt - 1, "$s)")
    } else {
        calc(openCnt - 1, closeCnt, "$s(")
        if(openCnt<closeCnt){
            calc(openCnt, closeCnt - 1, "$s)")
        }
    }
}