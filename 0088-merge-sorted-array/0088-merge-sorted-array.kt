import java.util.*
class Solution {
    var nums1 = intArrayOf()
    var m = 0
    var nums2 = intArrayOf()
    var n = 0
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        initialize(nums1, m, nums2, n)
        solve()
    }

    fun initialize(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        this.nums1 = nums1
        this.m = m
        this.nums2 = nums2
        this.n = n
    }

    fun solve() {
        val queue = LinkedList<Int>()
        var index = 0

        for (i in 0 until m+n) {
            if (i < m) {
                queue.add(nums1[i])
            }
            if (index == n) {
                nums1[i] = queue.remove()
                continue
            }
            if (queue.isEmpty()) {
                nums1[i] = nums2[index]
                index++
                continue
            }
            if (queue.peek() < nums2[index]) {
                nums1[i] = queue.remove()
            } else {
                nums1[i] = nums2[index]
                index ++
            }
        }
    }
}