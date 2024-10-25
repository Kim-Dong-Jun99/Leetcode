class Solution {
    var n = 0
    var m = 0
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        n = obstacleGrid.size
        m = obstacleGrid[0].size
        if (obstacleGrid[n-1][m-1] == 1) {
            return 0
        }
        return dfs(n-1, m-1, obstacleGrid, Array(n) {IntArray(m) {-1}})
    }

    fun dfs(x: Int, y: Int, obstacleGrid: Array<IntArray>, dp: Array<IntArray>): Int {
        if (x == 0 && y == 0) {
            return 1
        }
        if (dp[x][y] != -1) {
            return dp[x][y]
        }
        var answer = 0
        if (x - 1 >= 0 && obstacleGrid[x-1][y] == 0) {
            answer += dfs(x-1, y, obstacleGrid, dp)
        }
        if (y - 1 >= 0 && obstacleGrid[x][y-1] == 0) {
            answer += dfs(x, y-1, obstacleGrid, dp)
        }
        dp[x][y] = answer
        return dp[x][y]
    }
}