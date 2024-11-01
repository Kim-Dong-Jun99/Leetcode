class Solution {
    fun lengthOfLastWord(s: String): Int {
        var lastLength = 0
        var curLength = 0
        for (i in 0..s.lastIndex) {
            if (s[i] == ' ') {
                if (curLength != 0) {
                    lastLength = curLength
                    curLength = 0
                }
            } else {
                curLength += 1
            }
        }
        if (curLength != 0) {
            lastLength = curLength
        }
        return lastLength
    }
}