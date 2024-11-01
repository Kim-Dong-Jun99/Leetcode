class Solution {
    fun makeFancyString(s: String): String {
        val sb = StringBuilder()

        for (i in 0..s.lastIndex) {
            if (sb.length < 2) {
                sb.append(s[i])
            } else {
                if (sb[sb.lastIndex-1] == s[i] && sb[sb.lastIndex] == s[i]) {
                    continue
                }
                sb.append(s[i])
            }
        }

        return sb.toString()
    }
}