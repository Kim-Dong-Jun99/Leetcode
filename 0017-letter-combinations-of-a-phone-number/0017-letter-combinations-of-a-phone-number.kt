class Solution {
    val strs = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    fun letterCombinations(digits: String): List<String> {
        return dfs(0, StringBuilder(), digits)
    }

    fun dfs(index: Int, sb: StringBuilder, digits: String): List<String> {
        if (index == digits.length) {
            if (sb.isNotEmpty()) {
                return listOf(sb.toString())
            } else {
                return listOf<String>()
            }
            
        }
        val list = mutableListOf<String>()
        for (c in strs[digits[index].digitToInt()]) {
            sb.append(c)
            for (str in dfs(index+1, sb, digits)) {
                list.add(str)
            }
            sb.deleteAt(sb.lastIndex)
        }

        return list
    }
}