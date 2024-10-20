import java.util.*

class Solution {
    val TRUE = 't'
    val FALSE = 'f'
    val AND = '&'
    val OR = '|'
    val NOT = '!'
    val CONTINUE = ','
    var expression = ""
    fun parseBoolExpr(expression: String): Boolean {
        initialize(expression)
        return solve()
    }

    fun initialize(expression: String) {
        this.expression = expression
    }

    fun solve(): Boolean {
        val stack = Stack<Expression>()
        val levelStack = Stack<Char>()
        var i = 0
        while (i in 0..expression.lastIndex) {
            val c = expression[i]
            if (c == CONTINUE) {
                i += 1
                continue
            }
            if (c == TRUE || c == FALSE) {
                stack.push(Expression(levelStack.size, charToBoolean(c)))
                i += 1
            } else {
                if (c == AND || c == NOT || c == OR) {
                    levelStack.push(c)
                    i += 2
                } else {
                    val operation = levelStack.pop()
                    var value = true
                    if (operation == AND) {
                        value = true
                        while (!stack.isEmpty() && stack.peek().level > levelStack.size) {
                            value = value.and(stack.pop().value)
                        }
                    }
                    if (operation == OR) {
                        value = false
                        while (!stack.isEmpty() && stack.peek().level > levelStack.size) {
                            value = value.or(stack.pop().value)
                        }
                    }
                    if (operation == NOT) {
                        value = true
                        while (!stack.isEmpty() && stack.peek().level > levelStack.size) {
                            value = value.and(stack.pop().value)
                        }
                        value = value.not()
                    }
                    stack.push(Expression(levelStack.size, value))
                    i += 1
                }
            }
        }
        return stack.pop().value
    }

    fun charToBoolean(c: Char): Boolean {
        if (c == TRUE) {
            return true
        }
        return false
    }

    class Expression(val level: Int, val value: Boolean)
}