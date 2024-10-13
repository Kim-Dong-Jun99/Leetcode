import java.util.*
class Solution {
    var s = ""
    val set = mutableSetOf<Char>()
    fun lengthOfLongestSubstring(s: String): Int {
        initialize(s)
        return solve()
    }

    fun initialize(s: String) {
        this.s = s
    }

    fun solve(): Int {
        var answer = 0
        var l = 0
        for (r in 0..s.lastIndex) {
            while (set.contains(s[r])) {
                set.remove(s[l])
                l++
            }
            set.add(s[r])
            answer = Math.max(answer, r-l+1)
        }
        
        return answer
    }
}