class Solution {
    fun simplifyPath(path: String): String {
        val sb = StringBuilder()
        val stack = Stack<String>()
        for (str in path.split('/')) {
            if (str.length == 0) {
                continue
            }
            if (str.equals(".")) {
                continue
            }
            if (str.equals("..")) {
                if (stack.isNotEmpty()) {
                    stack.pop()
                }
                continue
            }
            stack.push(str)

        }
        for (str in stack) {
            sb.append("/").append(str)
        }
        if (sb.isEmpty()) {
            sb.append("/")
        }
        return sb.toString()
    }
}