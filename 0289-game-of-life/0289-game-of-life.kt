class Solution {
    val dx = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
    val dy = intArrayOf(1, 1, 0, -1, -1, -1, 0, 1)
    fun gameOfLife(board: Array<IntArray>): Unit {
        val n = board.size
        val m = board[0].size
        val next = Array(n) {IntArray(m) {0}}
        for (i in 0 until n) {
            for (j in 0 until m) {
                var dead = 0
                var live = 0
                for (d in 0 until 8) {
                    val nx = i + dx[d]
                    val ny = j + dy[d]

                    if (nx in 0 until n && ny in 0 until m) {
                        if (board[nx][ny] == 0) {
                            dead += 1
                        } else {
                            live += 1
                        }
                    }
                }

                if (board[i][j] == 1) {
                    if (live in 2..3) {
                        next[i][j] = 1
                    }
                } else {
                    if (live == 3) {
                        next[i][j] = 1
                    }
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                board[i][j] = next[i][j]
            }
        }

    }
}