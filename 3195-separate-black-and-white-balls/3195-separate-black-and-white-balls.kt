import java.util.*

class Solution {
    val ONE = '1'
    val ZERO = '0'
    var s = ""
    fun minimumSteps(s: String): Long {
        initialize(s)
        return solve()
    }

    fun initialize(s: String) {
        this.s = s
    }

    fun solve(): Long {
        var step = 0L
        var dest = s.lastIndex
        for (i in s.lastIndex downTo 0) {
            if (s[i] == ONE) {
                step += dest - i
                dest--
            }
        }
        return step
    }
}