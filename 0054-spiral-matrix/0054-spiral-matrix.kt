class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val list = mutableListOf<Int>()
        var x = 0
        var y = 0
        var d = 0
        val n = matrix.size
        val m = matrix[0].size
        val visited = Array(n) { BooleanArray(m) {false}}

        for (i in 0 until n*m) {
            list.add(matrix[x][y])
            visited[x][y] = true
            if (x + dx[d] in 0 until n && y + dy[d] in 0 until m && !visited[x+dx[d]][y+dy[d]]) {
                x += dx[d]
                y += dy[d]
            } else {
                d = (d + 1) % 4
                x += dx[d]
                y += dy[d]
            }
        }
        
        return list
    }
}