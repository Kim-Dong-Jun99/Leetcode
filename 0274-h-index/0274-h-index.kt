class Solution {
    fun hIndex(citations: IntArray): Int {
        citations.sort()
        var answer = 0
        var index = 0
        for (i in 1..citations[citations.lastIndex]) {
            while (index < citations.size && citations[index] < i) {
                index++
            }
            if (index == citations.size) {
                break
            }
            if (citations.size-index >= i) {
                answer = i
            } else {
                break
            }
        }
        return answer
    }
}