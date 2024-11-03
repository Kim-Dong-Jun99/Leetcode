class Solution {
    fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length) {
            return false
        }
        loop@ for (i in 0..goal.lastIndex) {
            var index = i
            for (j in 0..s.lastIndex) {
                if (goal[index] == s[j]) {
                    index = (index + 1) % goal.length
                } else {
                    continue@loop
                }
            }
            return true
        }
        return false
    }
}