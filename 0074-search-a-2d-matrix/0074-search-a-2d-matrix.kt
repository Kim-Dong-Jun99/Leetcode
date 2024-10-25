class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val size = matrix.size * matrix[0].size
        val lastIndex = size-1
        var left = 0
        var right = lastIndex

        while (left <= right) {
            val mid = (left+right)/2
            val x = mid/matrix[0].size
            val y = mid%matrix[0].size
            if (matrix[x][y] == target) {
                return true
            }
            if (matrix[x][y] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return false
    }
}