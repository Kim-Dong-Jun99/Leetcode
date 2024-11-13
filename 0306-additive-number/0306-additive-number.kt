import java.util.*

class Solution {
    fun isAdditiveNumber(num: String): Boolean {
        
        return backtrack(0, LinkedList<Long>(), num)
    }

    fun backtrack(cur: Int, deque: Deque<Long>, num: String): Boolean {
        if (cur == num.length) {
            if (deque.size < 3) {
                return false
            }
            var first: Long? = null
            var second: Long? = null
            for (i in deque) {
                if (first == null) {
                    first = i
                    continue
                }
                if (second == null) {
                    second = i
                    continue
                }
                if (first + second != i) {
                    return false
                }
                first = second
                second = i
            }
            return true
        }
        var answer = false
        if (num[cur] == '0') {
            deque.addLast(0)
            answer = backtrack(cur+1, deque, num)
            deque.removeLast()
            return answer
        }
        
        for (j in cur+1..Math.min(num.length, cur+18)) {
            deque.addLast(num.substring(cur, j).toLong())
            answer = answer || backtrack(j, deque, num)
            deque.removeLast()
        }
        return answer
    }
}