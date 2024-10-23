class Solution {
    var nums = intArrayOf()
    var dp = intArrayOf()
    fun canJump(nums: IntArray): Boolean {
        initialize(nums)
        return solve()
    }

    fun initialize(nums: IntArray) {
        this.nums = nums
        this.dp = IntArray(nums.size) {0}
    }

    fun solve(): Boolean {
        return dfs(0)
    }

    fun dfs(cur: Int): Boolean {
        if (cur == nums.lastIndex) {
            return true
        }
        if (dp[cur] != 0) {
            if (dp[cur] == 1) {
                return true
            } else {
                return false
            }
        }
        var result = false
        for (d in 1..nums[cur]) {
            if (cur + d <= nums.lastIndex) {
                result = result || dfs(cur+d)
            }
        }
        if (result == true) {
            dp[cur] = 1
        } else {
            dp[cur] = -1
        }
        return result
    }
}