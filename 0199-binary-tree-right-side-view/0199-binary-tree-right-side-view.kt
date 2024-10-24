/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val answer = mutableListOf<Int>()
        val q = LinkedList<Node>()
        val set = mutableSetOf<Int>()

        q.add(Node(0, root))
        while (q.isNotEmpty()) {
            val node = q.remove()
            if (!set.contains(node.lvl)) {
                set.add(node.lvl)
                if (node.tn != null) {
                    answer.add(node.tn!!.`val`)
                }
                
            }
            if (node.tn?.right != null) {
                q.add(Node(node.lvl+1, node.tn?.right))
            }
            if (node.tn?.left != null) {
                q.add(Node(node.lvl+1, node.tn?.left))
            }
            
        }
        
        return answer
    }

    class Node(val lvl: Int, val tn: TreeNode?)
}