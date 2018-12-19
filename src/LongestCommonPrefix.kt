/*https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

*/

fun main(args: Array<String>) {
    println("longestCommonPrefix(arrayOf(\"flower\", \"flow\", \"flight\")) = ${longestCommonPrefix(arrayOf("flower", "flow", "flight"))}")
    println("longestCommonPrefix(arrayOf(\"c\", \"c\")) = ${longestCommonPrefix(arrayOf("c", "c"))}")
    println("longestCommonPrefix(arrayOf(\"c\") = ${longestCommonPrefix(arrayOf("c"))}")
    println("longestCommonPrefix(arrayOf(\"\")) = ${longestCommonPrefix(arrayOf(""))}")
}

fun longestCommonPrefix(strs: Array<String>): String {
    if(strs.isEmpty()){
        return ""
    }
    if(strs.size==1){
        return strs[0]
    }
    var result = ""
    val tempValue = strs[0]

    for (i in 1 .. tempValue.length) {
        val tempString = tempValue.substring(0, i)
        for (j in 0 until strs.size) {
            if (strs[j].length < i || strs[j].substring(0, i) != tempString) {
                return result
            }
        }
        result = tempString
    }

    return result
}