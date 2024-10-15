import java.util.*

class Solution {
    var s = ""
    fun myAtoi(s: String): Int {
        initialize(s)
        return solve()
    }

    fun initialize(s: String) {
        this.s = s.trim()
    }

    fun solve(): Int {
        val sb = StringBuilder()
        for (i in 0..s.lastIndex) {
            if (s[i].isDigit()) {
                sb.append(s[i])
            } else {
                if (i == 0 && (s[i]=='-' || s[i]=='+')) {
                    if (s[i] == '-') {
                        sb.append(s[i])
                    }
                } else {
                    break
                }
            }
        }
        if (sb.length == 0) {
            return 0
        }
        try {
            if (isNumeric(sb.toString())) {
                return sb.toString().toInt()
            } else {
                return 0
            }
            
        } catch (e: NumberFormatException) {
            if (s[0] == '-') {
                return Int.MIN_VALUE
            } else {
                return Int.MAX_VALUE
            }
        }
    }

    fun isNumeric(toCheck: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return toCheck.matches(regex)
    }
}