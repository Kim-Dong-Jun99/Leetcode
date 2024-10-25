class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        return dfs(0, 0, triangle, Array(triangle.size) {IntArray(triangle.size) {Int.MAX_VALUE}})
    }

    fun dfs(depth: Int, index: Int, triangle: List<List<Int>>, dp: Array<IntArray>): Int {
        if (depth == triangle.size) {
            return 0
        }
        if (dp[depth][index] != Int.MAX_VALUE) {
            return dp[depth][index]
        }
        var answer = Int.MAX_VALUE
        answer = Math.min(answer, triangle[depth][index] + dfs(depth+1, index, triangle, dp))
        answer = Math.min(answer, triangle[depth][index] + dfs(depth+1, index+1, triangle, dp))
        dp[depth][index] = answer
        return answer
        
    }
}