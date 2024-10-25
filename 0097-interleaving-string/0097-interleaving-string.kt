class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        return dfs(0, 0, s1, s2, s3, Array(s1.length+1) { IntArray(s2.length+1) {0}})
    }

    fun dfs(i: Int, j: Int, s1: String, s2: String, s3: String, dp: Array<IntArray>): Boolean {
        if (i + j == s3.length) {
            // if (s3.length == 0 || (Math.abs(i-j) <= 1 && i > 0 && j > 0) || (s1.length == 0) || (s2.length == 0)) {
            //     return true
            // }
            if (i == s1.length && j == s2.length) {
                return true
            }
            return false
        }
        if (dp[i][j] != 0) {
            return intToBoolean(dp[i][j])
        }

        var answer = -1
        if (i <= s1.lastIndex && s1[i] == s3[i+j]) {
            answer = Math.max(answer, booleanToInt(dfs(i+1, j, s1, s2, s3, dp)))
        }
        if (j <= s2.lastIndex && s2[j] == s3[i+j]) {
            answer = Math.max(answer, booleanToInt(dfs(i, j+1, s1, s2, s3, dp)))
        }
        dp[i][j] = answer
        return intToBoolean(dp[i][j])
    }

    fun intToBoolean(i: Int): Boolean {
        if (i == 1) {
            return true
        }
        return false
    }

    fun booleanToInt(b: Boolean): Int {
        if (b) {
            return 1
        }
        return -1
    }
}