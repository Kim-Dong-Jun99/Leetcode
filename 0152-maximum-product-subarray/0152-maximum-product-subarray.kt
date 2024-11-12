class Solution {
    fun maxProduct(nums: IntArray): Int {
        val dp = Array(nums.size) { intArrayOf(nums[it], nums[it])}
        var answer = dp[0][0]
        for (i in 1..nums.lastIndex) {
            dp[i][0] = max(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i], nums[i])
            dp[i][1] = min(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i], nums[i])
            answer = max(dp[i][0], dp[i][1], answer)
        }
        return answer
    }

    fun max(vararg num: Int): Int {
        var answer = Int.MIN_VALUE
        for (n in num) {
            answer = Math.max(answer, n)
        }
        return answer
    }

    fun min(vararg num: Int): Int {
        var answer = Int.MAX_VALUE
        for (n in num) {
            answer = Math.min(answer, n)
        }
        return answer
    }
}