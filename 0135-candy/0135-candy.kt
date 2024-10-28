class Solution {
    fun candy(ratings: IntArray): Int {
        var answer = 0
        val candies = IntArray(ratings.size) {1}
        val visited = BooleanArray(ratings.size) {false}
        for (i in 0..ratings.lastIndex) {
            if (!visited[i]) {
                dfs(i, candies, visited, ratings)
            }
            answer += candies[i]
        }

        return answer
    }

    fun dfs(cur: Int, candies: IntArray, visited: BooleanArray, ratings: IntArray) {
        visited[cur] = true
        // if (cur - 1 >= 0 && !visited[cur-1] && ratings[cur] ) {
        //     dfs(cur-1, candies, visited, ratings)
        // }
        if (cur + 1 <= candies.lastIndex && !visited[cur+1] && ratings[cur] > ratings[cur+1]) {
            dfs(cur+1, candies, visited, ratings)
        }
        var toAdd = 0
        if (cur - 1 >= 0 && ratings[cur-1] < ratings[cur]) {
            toAdd = Math.max(toAdd, candies[cur-1])
        }
        if (cur + 1 <= candies.lastIndex && ratings[cur+1] < ratings[cur]) {
            toAdd = Math.max(toAdd, candies[cur+1])
        }
        candies[cur] = toAdd+1
    }
}