class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val sb = StringBuilder()
        loop@ for (i in 0 until 200) {
            for (str in strs) {
                if (i > str.lastIndex) {
                    if (sb.length > i) {
                        sb.deleteAt(sb.lastIndex)
                    }
                    break@loop
                }
                if (sb.length == i) {
                    sb.append(str[i])
                } else {
                    if (sb[sb.lastIndex] != str[i]) {
                        sb.deleteAt(sb.lastIndex)
                        break@loop
                    }
                }
            }
        }
        return sb.toString()
    }
}