class Solution {

    private var maxi = 0

    fun maximalSquare(matrix: Array<CharArray>): Int {
        
        maxi = 0
        val dp = Array(matrix.size) { IntArray(matrix[0].size) { -1 } }
        solve(matrix, 0, 0, dp)
        return maxi * maxi
    }

    private fun solve(matrix: Array<CharArray>, row: Int, col: Int, dp: Array<IntArray>): Int {

        // Base case
        if (row >= matrix.size || col >= matrix[0].size) {
            return 0
        }

        if (dp[row][col] != -1) {
            return dp[row][col]
        }

        val right = solve(matrix, row, col + 1, dp)
        val diagonal = solve(matrix, row + 1, col + 1, dp)
        val down = solve(matrix, row + 1, col, dp)

        if (matrix[row][col] == '1') {
            dp[row][col] = 1 + Math.min(right, Math.min(diagonal, down))
            maxi = Math.max(maxi, dp[row][col])
            return dp[row][col]
        }
        else {
            dp[row][col] = 0
            return dp[row][col]
        }

    }
}