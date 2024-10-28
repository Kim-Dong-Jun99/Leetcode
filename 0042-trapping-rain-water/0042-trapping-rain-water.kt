import java.util.*
class Solution {
    fun trap(height: IntArray): Int {
        var answer = 0
        val heap = PriorityQueue<Int>()
        var max = 0
        for (h in height) {
            if (heap.isEmpty()) {
                if (h != 0) {
                    heap.add(h)
                    max = h
                }
                continue
            }
            val list = mutableListOf<Int>()
            while (heap.isNotEmpty() && heap.peek() <= h) {
                answer += Math.min(max, h) - heap.remove()
                list.add(Math.min(max, h))
            }
            
            if (heap.isEmpty()) {
                max = h
            } else {
                for (i in list) {
                    heap.add(i)
                }
            }
            heap.add(h)
        }
        return answer
    }
}