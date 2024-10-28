class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val wordLen = words[0].length
        val subStrLen = words.size * wordLen

        val result = mutableListOf<Int>()
        val wordCounts = words.groupingBy { it }.eachCount()
        
        for (i in 0 until wordLen) {
            val used = mutableMapOf<String, Int>()
            var start = i
            var end = i + subStrLen

            if (end > s.length) break

            s.substring(start, end).chunked(wordLen).forEach { word ->
                used[word] = used.getOrElse(word) { 0 } + 1
            }

            if (used == wordCounts) {
                result.add(start)
            }

            while (end <= s.length - wordLen) {
                val oldWord = s.substring(start, start + wordLen)
                
                if (used[oldWord]!! > 1) {
                    used[oldWord] = used[oldWord]!! - 1
                } else {
                    used.remove(oldWord)                    
                }

                val newWord = s.substring(end, end + wordLen)

                used[newWord] = used.getOrElse(newWord) { 0 } + 1

                start += wordLen
                end += wordLen

                if (used == wordCounts) {
                    result.add(start)
                }
            }
        }

        return result
    }
}