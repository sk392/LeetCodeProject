import sun.rmi.runtime.Log
import java.lang.StringBuilder
import java.util.logging.Logger
import kotlin.math.abs

/* https://leetcode.com/problems/palindrome-number/
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
*/

fun main(args: Array<String>) {
    val test1 = 131
    val test2 = 13631
    val test3 = 136731
    val test4 = -13631

    println("${isPalindrome(test1)}")
    println("${isPalindrome(test2)}")
    println("${isPalindrome(test3)}")
    println("${isPalindrome(test4)}")

}


fun isPalindrome(x: Int): Boolean {
    val convertX = x.toString()
    for (i in 0 until convertX.length / 2 ) {
        if (convertX[i] != convertX[convertX.length - 1 - i]) {
            return false
        }
    }
    return true
}
