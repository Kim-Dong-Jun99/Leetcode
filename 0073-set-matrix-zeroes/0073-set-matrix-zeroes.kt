class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rows = mutableListOf<Int>()
        val cols = mutableListOf<Int>()
        val rowVisited = BooleanArray(matrix.size) {false}
        val colVisited = BooleanArray(matrix[0].size) {false}
        for (i in 0..matrix.lastIndex) {
            for (j in 0..matrix[0].lastIndex) {
                if (matrix[i][j] == 0) {
                    if (!rowVisited[i]) {
                        rowVisited[i] = true
                        rows.add(i)
                    }
                    if (!colVisited[j]) {
                        colVisited[j] = true
                        cols.add(j)
                    }
                }
            }
        }
        for (r in rows) {
            for (j in 0..matrix[0].lastIndex) {
                matrix[r][j] = 0
            }
        }
        for (c in cols) {
            for (i in 0..matrix.lastIndex) {
                matrix[i][c] = 0
            }
        }
    }
}