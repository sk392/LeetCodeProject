import java.lang.Math.pow
import java.math.BigInteger

/*https://leetcode.com/problems/add-binary/
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/

fun main(args: Array<String>) {
    println(addBinary("11", "1"))
    println(addBinary("1010", "1011"))
//    println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"))
}

fun addBinary(a: String, b: String): String {
    BigInteger(a,2).add(BigInteger(b,2)).toString(2)
    val result = StringBuilder()
    val tempA = a.reversed()
    val tempB = b.reversed()
    var plusCount = 0
    for(i in 0 until  Math.max(a.length,b.length)){
        var temp= plusCount
        plusCount =0
        if( i<a.length){
            temp += tempA[i].toString().toInt()
        }
        if( i<b.length){
            temp += tempB[i].toString().toInt()
        }
        if(temp>=2){
            plusCount = 1
            temp -=2
        }
        result.append(temp)
    }
    if(plusCount!= 0){
        result.append(plusCount)
    }

    return result.toString().reversed()
}
