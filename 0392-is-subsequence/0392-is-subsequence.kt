class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var sIndex = 0
        var tIndex = 0
        while (sIndex <= s.lastIndex) {
            while (tIndex <= t.lastIndex && s[sIndex] != t[tIndex]) {
                tIndex += 1
            }
            if (tIndex == t.length) {
                return false
            }
            sIndex++
            tIndex++
        }
        return sIndex == s.length
    }
}