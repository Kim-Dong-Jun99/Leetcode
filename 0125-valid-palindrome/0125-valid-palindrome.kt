class Solution {
    fun isPalindrome(s: String): Boolean {
        val str = s.lowercase().trim()
        var left = 0
        var right = str.lastIndex
        while (left <= str.lastIndex && !str[left].isLetterOrDigit()) {
            left++
        }
        while (right >= 0 && !str[right].isLetterOrDigit()) {
            right --
        }
        while (left < right) {
            if (str[left] != str[right]) {
                return false
            }
            left++
            right--
            while (!str[left].isLetterOrDigit()) {
                left++
            }
            while (!str[right].isLetterOrDigit()) {
                right --
            }
        }
        return true
    }
}