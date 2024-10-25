class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        return dfs(0, 0, coins, amount, IntArray(amount+1) { Int.MAX_VALUE})
    }

    fun dfs(cur: Int, used: Int,  coins: IntArray, amount: Int, dp: IntArray): Int {
        if (cur == amount) {
            return 0
        }
        if (dp[cur] != Int.MAX_VALUE) {
            return dp[cur]
        }

        var answer = Int.MAX_VALUE
        for (coin in coins) {
            if (coin <= amount && cur + coin <= amount) {
                val temp = dfs(cur+coin, used+1, coins, amount, dp)
                if (temp != -1) {
                    answer = Math.min(answer, temp)
                }
            }
        }
        if (answer == Int.MAX_VALUE) {
            dp[cur] = -1
        } else {
            dp[cur] = answer + 1
        }
        return dp[cur]
    }
}