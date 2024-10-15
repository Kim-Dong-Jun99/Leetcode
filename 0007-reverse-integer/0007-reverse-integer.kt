import java.util.*

class Solution {
    var x = 0

    fun reverse(x: Int): Int {
        initialize(x)
        return solve()
    }

    fun initialize(x: Int) {
        this.x = x
    }

    fun solve(): Int {
        
        val str = x.toString()
        var negative = false
        val sb = StringBuilder()
        for (i in str.lastIndex downTo 0) {
            if (str[i].isDigit()) {
                sb.append(str[i])
            } else {
                negative = true
            }
        }
        try {
            if (negative) {
                return ("-"+sb.toString()).toInt()
            } else {
                return sb.toString().toInt()
            }
        } catch (e: NumberFormatException) {
            return 0
        }
        
    }
}