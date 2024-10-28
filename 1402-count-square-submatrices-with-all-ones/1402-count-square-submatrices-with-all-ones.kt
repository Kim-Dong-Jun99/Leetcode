class Solution {
    fun countSquares(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        val dp = MutableList(m+1) {MutableList(n+1) {0}}
        var cnt = 0
        for(i in 1..m){
            for(j in 1..n){
                if(matrix[i-1][j-1] == 1){
                    dp[i][j] = min(dp[i-1][j-1], min(dp[i][j-1], dp[i-1][j])) + 1
                    cnt += dp[i][j]
                }
            }
        }
        return cnt
    }
}