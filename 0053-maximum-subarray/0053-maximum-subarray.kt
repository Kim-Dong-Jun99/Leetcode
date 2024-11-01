class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val dp = IntArray(nums.size) {Int.MIN_VALUE}

        dfs(0, dp, nums)
        return dp.max()
    }

    fun dfs(index: Int, dp: IntArray, nums: IntArray): Int {
        if (index == dp.lastIndex) {
            dp[index] = nums[index]
            return nums[index]
        }
        if (dp[index] != Int.MIN_VALUE) {
            return dp[index]
        }
        dp[index] = Math.max(nums[index], nums[index] + dfs(index+1, dp, nums))
        return dp[index]
    }
}