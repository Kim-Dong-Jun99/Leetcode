import java.util.*

class Solution {
    var nums = intArrayOf()
    var k = 0

    fun maxKelements(nums: IntArray, k: Int): Long {
        initialize(nums, k)
        return solve()
    }

    fun initialize(nums: IntArray, k: Int) {
        this.nums = nums
        this.k = k
    }

    fun solve(): Long {
        var score = 0L
        val heap = PriorityQueue<Int>(kotlin.Comparator {o1, o2 -> 
            o2-o1
        })
        nums.forEach {heap.add(it)}
        for (i in 0 until k) {
            val num = heap.remove()
            score += num
            heap.add(Math.ceil(num.toDouble() / 3).toInt())
        }

        return score
    }
}