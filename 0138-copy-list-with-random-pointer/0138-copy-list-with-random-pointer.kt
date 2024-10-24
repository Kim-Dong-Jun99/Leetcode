/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) {
            return null
        }
        val n = getN(node)
        val nodes = Array(n) {Node(0)}
        connectNextNode(node, nodes, n)
        connectRandomNode(node, nodes, n)
        return nodes[0]
    }

    fun getN(node: Node?): Int {
        var cur = node
        var n = 0
        while (cur != null) {
            n += 1
            cur = cur?.next
        }
        return n
    }

    fun connectNextNode(node: Node?, nodes: Array<Node>, n:Int) {
        var cur = node
        for (i in 0 until n) {
            nodes[i].`val`= cur!!.`val`
            if (i+1 < n) {
                nodes[i].next = nodes[i+1]
            }
            cur = cur?.next
        }
    }

    fun connectRandomNode(node: Node?, nodes: Array<Node>, n:Int) {
        var cur = node
        for (i in 0 until n) {
            if (cur?.random == null) {
                nodes[i].random = null
            } else {
                val index = getIndex(cur?.random, n)
                nodes[i].random = nodes[index]
            }
            cur = cur?.next
        }
    }

    fun getIndex(node: Node?, n:Int): Int {
        var cur = node
        var moved = 0
        while (cur != null) {
            cur = cur.next
            moved++
        }
        return n - moved
    }
}