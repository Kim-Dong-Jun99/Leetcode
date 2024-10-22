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
    var root: TreeNode? = TreeNode(5)
    var k = 0
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        initialize(root, k) 
        return solve()
    }

    fun initialize(root: TreeNode?, k: Int) {
        this.root = root
        this.k = k
    }

    fun solve(): Long {
        var sum = LongArray(100_000) {0L}

        treeTravel(root, 0, sum)

        sum.sortDescending()
        if (sum[k-1] == 0L) {
            return -1
        }
        return sum[k-1]
    }

    fun treeTravel(node: TreeNode?, level: Int, sum: LongArray) {
        if (node == null) {
            return
        }
        treeTravel(node.left, level+1, sum)
        
        sum[level] += (node?.`val` ?: 0).toLong()
        
        treeTravel(node.right, level+1, sum)
    }
}