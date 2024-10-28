class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        var curLength = 0
        var curList = mutableListOf<String>()
        val result = mutableListOf<String>()
        for (word in words) {
            if (curLength == 0) {
                curLength += word.length
                curList.add(word)
                continue
            }
            if (curLength + word.length + 1 <= maxWidth) {
                curLength += word.length + 1
                curList.add(word)
            } else {
                result.add(listToString(curList, maxWidth, curLength))
                curLength = word.length
                curList = mutableListOf(word)
            }
        }
        if (curList.isNotEmpty()) {
            val sb = StringBuilder()
            curList.forEachIndexed {i, word ->
                if (i != 0) {
                    sb.append(" ")    
                }
                sb.append(word)
            }
            while (sb.length < maxWidth) {
                sb.append(" ")
            }
            result.add(sb.toString())
        }
        
        return result
    }

    fun listToString(curList: List<String>, maxWidth: Int, curLength: Int): String {
        val sb = StringBuilder()
        val spaces = curList.size - 1
        if (spaces == 0) {
            sb.append(curList[0])
            while (sb.length < maxWidth) {
                sb.append(" ")
            }
            return sb.toString()
        }
        var toFill = maxWidth - curLength
        val div = toFill / spaces
        val mod = toFill % spaces
        curList.forEachIndexed {i, word ->
            sb.append(word)
            if (i < spaces) {
                for (j in 0..div) {
                    sb.append(" ")
                }
                if (i < mod) {
                    sb.append(" ")
                }
            }
        }
        println("${sb.toString().length == maxWidth}")
        return sb.toString()
    }
}