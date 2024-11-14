class Solution {
    fun compressedString(word: String): String {
        val sb = StringBuilder()
        var c = '-'
        var size = 0
        for (w in word) {
            if (c == '-') {
                c = w
                size = 1
                continue
            }

            if (size == 9 || c != w) {
                sb.append(size)
                sb.append(c)       
                c = w
                size = 1
                continue     
            }
            if (c == w) {
                size += 1
            }
        }
        sb.append(size)
        sb.append(c)
        return sb.toString()
    }
}