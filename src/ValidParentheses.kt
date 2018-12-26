import java.util.*

/*https://leetcode.com/problems/valid-parentheses/
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

fun main(args: Array<String>) {
    print(isValid("()"))
    print(isValid("()[]"))
    print(isValid("([)]"))
    print(isValid("{([)]}"))
    print(isValid("{[]}}}"))
}
fun isValid(s: String): Boolean {
    val stack : Stack<Char> = Stack()
    var result = true
    for( i in 0 until s.length){
        if(isPop(s[i])){
            if(stack.size<=0 || stack.pop()!=s[i]){
                return false
            }
        }else{
            stack.push(convert(s[i]))
        }
    }

    if(stack.size!=0){
        result =false
    }

    return result

}
fun isPop(c :Char)  = c == ')' || c == ']' || c == '}'
fun convert(c : Char) = when(c){
    '(' -> ')'
    '[' -> ']'
    '{' -> '}'
    else -> null
}