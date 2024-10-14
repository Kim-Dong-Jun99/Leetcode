import java.util.*
/*

 */
class Solution {
    var nums1 = intArrayOf()
    var nums2 = intArrayOf()
    var m = 0
    var n = 0 

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.size > nums2.size) {
            initialize(nums2, nums1)
        } else {
            initialize(nums1, nums2)
        }
        return solve()    
    }

    fun initialize(nums1: IntArray, nums2: IntArray) {
        this.nums1 = nums1
        this.nums2 = nums2
        this.m = nums1.size
        this.n = nums2.size
    }

    fun solve(): Double {
        var left = (n + m + 1) / 2
        var low = 0
        var high = m

        while (low <= high) {
            val mid1 = (low + high) shr 1
            val mid2 = left - mid1

            var l1 = Int.MIN_VALUE
            var l2 = Int.MIN_VALUE
            var r1 = Int.MAX_VALUE
            var r2 = Int.MAX_VALUE

            if (mid1 < m) {
                r1 = nums1[mid1]
            }
            if (mid2 < n) {
                r2 = nums2[mid2]
            }
            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1-1]
            }
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2-1]
            }

            if (l1 <= r2 && l2 <= r1) {
                if ((n+m) % 2 == 1) {
                    return Math.max(l1, l2).toDouble()
                } else {
                    return (Math.max(l1,l2) + Math.min(r1,r2)).toDouble() / 2
                }
            } else if (l1 > r2) {
                high = mid1 - 1
            } else {
                low = mid1 + 1
            }
        }
        return 0.0
    }
}