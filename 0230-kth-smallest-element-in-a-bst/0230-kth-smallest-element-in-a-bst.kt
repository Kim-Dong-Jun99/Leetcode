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
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var cur = root
        val stack = Stack<TreeNode?>()
        var count = 0
        val set = mutableSetOf<Int>()
        while (true) {
            if (cur?.left != null && !set.contains(cur?.left.hashCode())) {
                stack.push(cur)
                cur = cur.left
                continue
            }
            if (!set.contains(cur.hashCode())) {
                count += 1
                set.add(cur.hashCode())
            }
            
            if (count == k) {
                break
            }
            if (cur?.right != null && !set.contains(cur?.right.hashCode())) {
                stack.push(cur)
                cur = cur.right
                continue
            }
            cur = stack.pop()
            
        }
        return cur!!.`val`
    }
}