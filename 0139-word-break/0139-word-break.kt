class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return dfs(s, mutableMapOf<String, Boolean>(), wordDict)
    }

    fun dfs(s: String, visited: MutableMap<String, Boolean>, wordDict: List<String>): Boolean {
        if (s.length == 0) {
            return true
        }
        if (visited.containsKey(s)) {
            return visited[s]!! 
        }
        var answer = false
        for (word in wordDict) {
            if (s.startsWith(word)) {
                answer = answer || dfs(s.substring(word.length), visited, wordDict)
            }
        }
        visited[s] = answer
        return answer
    }
}