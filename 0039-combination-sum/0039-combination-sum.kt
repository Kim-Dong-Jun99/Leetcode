import java.util.*
class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        return backtrack(0, 0, LinkedList<Int>(), candidates, target)
    }

    fun backtrack(sum: Int, lastValue: Int, q: Deque<Int>, candidates: IntArray, target: Int): List<List<Int>> {
        if (sum == target) {
            var answer = mutableListOf<Int>()
            for (i in q) {
                answer.add(i)
            }
            return listOf(answer)
        }
        val answer = mutableListOf<List<Int>>()
        for (c in candidates) {
            if (c >= lastValue && sum + c <= target) {
                q.addLast(c)
                val temp = backtrack(sum+c, c, q, candidates, target)
                for (l in temp) {
                    answer.add(l)
                }
                q.removeLast()
            }
        }
        return answer
    }
}