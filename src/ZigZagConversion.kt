import java.lang.StringBuilder

/*https://leetcode.com/problems/zigzag-conversion/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
*/

fun main(args: Array<String>) {
    println(convert("PAYPALISHIRING", 3))
    println(convert("", 2))
}

fun convert(s: String, numRows: Int): String {
    if(s.isEmpty()){
        return ""
    }
    if(numRows == 1){
        return s
    }
    val result = StringBuilder()
    for (i in 0 until numRows) {
        if(i>=s.length){
            break
        }
        var index = i
        result.append(s[index])
        while (index < s.length && result.length !=s.length) {

            if (numRows-1 - i > 0) {
                if (index + (numRows-1 - i)*2 < s.length) {
                    index += (numRows-1 - i)*2
                    result.append(s[index])
                } else {
                    break

                }
            }

            if (i > 0) {
                if (index + i*2 < s.length) {
                    index += i*2
                    result.append(s[index])

                } else {
                    break
                }
            }
        }

    }
    return result.toString()
}