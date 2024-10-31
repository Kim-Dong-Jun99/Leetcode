class Solution {
    fun generateParenthesis(n: Int): List<String> {
        var answerList = mutableListOf<String>()
        dfs(0, 0, StringBuilder(), answerList, n)
        return answerList   
    }

    fun dfs(left: Int, right: Int, sb: StringBuilder, list: MutableList<String>, n: Int) {
        // println("${left} ${right}")
        if (left == n && right == n) {
            list.add(sb.toString())
            return
        }
        if (left < n) {
            sb.append("(")
            dfs(left+1, right, sb, list, n)
            sb.deleteAt(sb.lastIndex)
        }
        if (left > right) {
            sb.append(")")
            dfs(left, right+1, sb, list, n)
            sb.deleteAt(sb.lastIndex)
        }
    } 
}