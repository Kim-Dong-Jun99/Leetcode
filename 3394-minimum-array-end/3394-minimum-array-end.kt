import java.util.*

class Solution {
    fun minEnd(n: Int, x: Int): Long {
        val binary = Integer.toBinaryString(x)
        println("${binary}")
        val nb = Integer.toBinaryString(n-1)
        val stack = Stack<Char>()
        var index = nb.lastIndex
        for (i in binary.lastIndex downTo 0) {
            if (binary[i] == '1') {
                stack.push(binary[i])
            } else {
                if (index >= 0) {
                    stack.push(nb[index])
                    index--
                } else {
                    stack.push('0')
                }
            }
        }
        for (i in index downTo 0) {
            stack.push(nb[i])
        }
        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.append(stack.pop())
        }
        return sb.toString().toLong(2)
    }
}