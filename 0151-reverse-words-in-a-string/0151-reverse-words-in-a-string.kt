class Solution {
    fun reverseWords(s: String): String {
        var words = s.trim().replace("\\s+".toRegex(), " ").split(" ").toTypedArray()
        var (i,j) = Pair(0, words.size-1)
        while(i < j) {
            words[i] = words[j].also{ words[j--] = words[i++] }
        }
        return words.joinToString(" ")
    }
}