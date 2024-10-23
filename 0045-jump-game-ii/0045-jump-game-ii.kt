class Solution {
    fun jump(nums: IntArray): Int {
        if (nums.size <= 1) return 0

        var jumps = 0
        var currentEnd = 0
        var farthest = 0

        for (i in 0 until nums.size - 1) {
            farthest = maxOf(farthest, i + nums[i])
            if (i == currentEnd) {
                jumps++
                currentEnd = farthest
                if (currentEnd >= nums.size - 1) break
            }
        }

        return jumps
    }
}