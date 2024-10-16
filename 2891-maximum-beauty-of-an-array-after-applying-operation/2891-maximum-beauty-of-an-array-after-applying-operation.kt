import java.util.*

class Solution {
    var nums = intArrayOf()
    var k = 0
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        initialize(nums, k)
        return solve()
    }

    fun initialize(nums: IntArray, k: Int) {
        this.nums = nums
        this.k = k
        this.nums.sort()
    }

    fun solve(): Int {
        var answer = 0
        var left = 0
        var right = 0
        for (num in nums[0]..nums[nums.lastIndex]) {
            val min = num - k
            val max = num + k
            while (right + 1 <= nums.lastIndex && nums[right+1] <= max) {
                right++
            }
            while (left + 1 <= right && nums[left] < min) {
                left++
            }
            
            answer = Math.max(answer, right-left+1)
        }
        return answer
    }
}