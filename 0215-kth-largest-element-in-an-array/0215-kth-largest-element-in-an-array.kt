import java.util.*
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>(kotlin.Comparator {o1, o2 -> 
            o2-o1
        })
        nums.forEach{ num ->
        heap.add(num)
        }
        for (i in 1 until k) {
            heap.remove()
        }
        return heap.remove()
    }
}