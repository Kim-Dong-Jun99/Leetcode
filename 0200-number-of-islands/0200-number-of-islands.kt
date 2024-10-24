class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    fun numIslands(grid: Array<CharArray>): Int {
        var island = 0
        
        val n = grid.size
        val m = grid[0].size
        val visited = Array(n) { BooleanArray(m) {false}}
        for (x in 0 until n) {
            for (y in 0 until m) {
                if (grid[x][y] == '1' && !visited[x][y]) {
                    island += 1
                    val q = LinkedList<Position>()
                    q.add(Position(x, y))
                    visited[x][y] = true
                    while (q.isNotEmpty()) {
                        val p = q.remove()
                        for (d in 0 until 4) {
                            val nx = p.x + dx[d]
                            val ny = p.y + dy[d]

                            if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && grid[nx][ny] == '1') {
                                q.add(Position(nx, ny))
                                visited[nx][ny] = true
                            }
                        }
                    }
                }
            }
        }
        return island
    }

    class Position(val x: Int, val y: Int)
}