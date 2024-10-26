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
    fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {
        val answer = IntArray(queries.size) {0}
        val heights = IntArray(100_001){-1}
        val parents = Array<TreeNode?>(100_001) { null }
        initHeights(root, heights, parents)
        queries.forEachIndexed {i, query ->
            val org = heights[query]
            heights[query] = -1
            recalculateHeight(parents[query], heights, parents)
            answer[i] = heights[root!!.`val`]
            heights[query] = org
            recalculateHeight(parents[query], heights, parents)
        }
        return answer
    }

    fun initHeights(root: TreeNode?, heights: IntArray, parents: Array<TreeNode?>): Int {
        if (root!!.left == null && root!!.right == null) {
            heights[root!!.`val`] = 0
            return 0
        }
        var maxHeight = 0
        if (root!!.left != null) {
            parents[root!!.left!!.`val`] = root
            maxHeight = Math.max(maxHeight, initHeights(root!!.left, heights, parents))
        }
        if (root!!.right != null) {
            parents[root!!.right!!.`val`] = root
            maxHeight = Math.max(maxHeight, initHeights(root!!.right, heights, parents))
        }
        heights[root!!.`val`] = maxHeight + 1
        return maxHeight + 1
    }

    fun recalculateHeight(root: TreeNode?, heights: IntArray, parents: Array<TreeNode?>) {
        if (root == null) {
            return
        }
        var maxHeight = -1
        if (root!!.left != null) {
            maxHeight = Math.max(maxHeight, heights[root!!.left!!.`val`])
        }
        if (root!!.right != null) {
            maxHeight = Math.max(maxHeight, heights[root!!.right!!.`val`])
        }
        heights[root!!.`val`] = maxHeight + 1
        return recalculateHeight(parents[root!!.`val`], heights, parents)
    }
}