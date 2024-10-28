class Solution {
    val translations = mapOf(
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000
    )
    fun romanToInt(s: String): Int {

        var modifiedString = s 
            .replace("IV", "IIII")
            .replace("IX", "VIIII")
            .replace("XL", "XXXX")
            .replace("XC", "LXXXX")
            .replace("CD", "CCCC")
            .replace("CM", "DCCCC")

        var number = 0

        for (char in modifiedString) {
            number += translations.getValue(char.toString()) 
        }

        return number
    }
}