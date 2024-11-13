class Solution {
    fun hIndex(citations: IntArray): Int {
        var left = 0
        var right = citations[citations.lastIndex]
        var answer = 0
        while (left <= right) {
            val mid = (left + right) / 2
            val index = bst(citations, mid)
            if (mid <= citations.size - index) {
                answer = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return answer
    }

    fun bst(citations: IntArray, value: Int): Int {
        var left = 0
        var right = citations.lastIndex
        var answer = 0
        while (left <= right) {
            val mid = (left+right)/2
            if (citations[mid] >= value) {
                answer = mid
                right = mid-1
            } else {
                left = mid+1
            }
        }
        return answer
    }
}