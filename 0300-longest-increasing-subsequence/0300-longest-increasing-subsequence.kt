class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        var answer = 1
        val dp = IntArray(n){1}
        for (i in 1..nums.lastIndex) {
            for (j in 0 until i) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1)
                }
            }
            answer = Math.max(answer, dp[i])
        }
        // val dp = Array(n) { IntArray(n) {0}}
        // dp[0][0] = 1
        // for (i in 1..nums.lastIndex) {
        //     for (j in 0..i) {
        //         if (nums[j] < nums[i]) {
        //             dp[i][j] = Math.max(dp[i][j], dp[j][j] + 1)
        //         }
        //         answer = Math.max(answer, dp[i][j])
        //     }
        // }
        return answer
    }
}