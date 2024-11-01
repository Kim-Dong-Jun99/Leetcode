class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) {-1}}
        return dfs(0, 0, dp, m, n)
    }

    fun dfs(x: Int, y: Int, dp: Array<IntArray>, m: Int, n: Int): Int {
        if (x == m-1 && y == n-1) {
            return 1
        }

        if (dp[x][y] != -1) {
            return dp[x][y]
        }
        var result = 0
        if (x+1 < m) {
            result += dfs(x+1, y, dp, m, n)
        }
        if (y+1 < n) {
            result += dfs(x, y+1, dp, m, n)
        }
        dp[x][y] = result
        return dp[x][y]

    }
}