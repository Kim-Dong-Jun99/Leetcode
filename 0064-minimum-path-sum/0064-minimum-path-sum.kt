class Solution {
    var n = 0
    var m = 0
    fun minPathSum(grid: Array<IntArray>): Int {
        n = grid.size
        m = grid[0].size
        return dfs(n-1, m-1, grid, Array(n) { IntArray(m) {Int.MAX_VALUE}})
    }

    fun dfs(x: Int, y: Int, grid: Array<IntArray>, dp: Array<IntArray>): Int {
        if (x == 0 && y == 0) {
            return grid[x][y]
        }
        if (dp[x][y] != Int.MAX_VALUE) {
            return dp[x][y]
        }
        var answer = Int.MAX_VALUE
        if (x-1 >= 0) {
            answer = Math.min(answer, dfs(x-1, y, grid, dp)+grid[x][y])
        }
        if (y-1 >= 0) {
            answer = Math.min(answer, dfs(x, y-1, grid, dp)+grid[x][y])
        }
        dp[x][y] = answer
        return dp[x][y]
    }
}