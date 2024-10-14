import java.util.*

class Solution {
    var s = ""
    fun longestPalindrome(s: String): String {
        initialize(s)
        return solve()
    }

    fun initialize(s: String) {
        this.s = s
    }

    fun solve(): String {
        var index = 0
        var left = 0
        var right = 0
        var result = s.substring(0 until 1)
        while (index <= s.lastIndex) {
            if (index - 1 >= 0 && index + 1 <= s.lastIndex && s[index+1] == s[index-1]) {
                left = index - 1
                right = index + 1
                while (left - 1 >= 0 && right + 1 <= s.lastIndex && s[left-1] == s[right+1]) {
                    left -= 1
                    right += 1
                }
                if (right - left + 1 > result.length) {
                    result = s.substring(left until right+1)
                }
            }
            if (index + 1 <= s.lastIndex && s[index] == s[index + 1]) {
                left = index
                right = index + 1
                while (left - 1 >= 0 && right + 1 <= s.lastIndex && s[left-1] == s[right+1]) {
                    left -= 1
                    right += 1
                }
                if (right - left + 1 > result.length) {
                    result = s.substring(left until right+1)
                }
            } 
            index ++
            
        }
        return result
    }
}