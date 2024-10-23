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
    fun replaceValueInTree(root: TreeNode?): TreeNode? {
        val nodes = LinkedList<TreeNode>()
        nodes.offer(root!!)
        root.`val` = 0
        while (nodes.isNotEmpty()) {
            val sum = nodes.sumOf { (it.left?.`val` ?: 0) + (it.right?.`val` ?: 0) }
            repeat(nodes.size) {
                val parent = nodes.poll()
                val localSum = sum - (parent.left?.`val` ?: 0) - (parent.right?.`val` ?: 0)
                parent.left?.let {
                    it.`val` = localSum
                    nodes.offer(it)
                }
                parent.right?.let {
                    it.`val` = localSum
                    nodes.offer(it)
                }
            }
        }
        return root
    }
}