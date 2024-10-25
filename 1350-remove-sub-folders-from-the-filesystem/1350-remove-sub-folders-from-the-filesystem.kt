class Solution {
    fun removeSubfolders(folder: Array<String>): List<String> {
        val answer = mutableListOf<String>()
        folder.sort()
        answer.add(folder[0])
        for (i in 1..folder.lastIndex) {
            val lastFolder = answer[answer.lastIndex]+"/"

            if (!folder[i].startsWith(lastFolder)) {
                answer.add(folder[i])
            }
        }
        return answer
    }
}