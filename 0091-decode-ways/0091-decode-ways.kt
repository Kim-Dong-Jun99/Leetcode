class Solution {
    fun numDecodings(s: String): Int {
        return dfs(0, IntArray(s.length) {-1}, s)
    }

    fun dfs(cur: Int, dp: IntArray, s: String): Int {
        if (cur == s.length) {
            return 1
        }
        if (dp[cur] != -1) {
            return dp[cur]
        }
        var result = 0
        if (s.substring(cur, cur+1).toInt() in 1..9) {
            result += dfs(cur+1, dp, s)
        }
        if (cur + 1 <= s.lastIndex && s.substring(cur, cur+2).toInt() in 10..26) {
            result += dfs(cur+2, dp, s)
        }
        dp[cur] = result
        return dp[cur]
    }
}