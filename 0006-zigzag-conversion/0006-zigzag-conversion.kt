import java.util.*

class Solution {
    var s = ""
    var numRows = 0
    var board = arrayOf<CharArray>()

    fun convert(s: String, numRows: Int): String {
        initialize(s, numRows)
        return solve()
    }

    fun initialize(s: String, numRows: Int) {
        this.s = s
        this.numRows = numRows
        this.board = Array(s.length) { CharArray(s.length) {'-'}}
    }

    fun solve(): String {
        if (numRows == 1) {
            return s
        }
        val sb = StringBuilder()
        var x = 0
        var y = 0

        board[x][y] = s[0]
        for (i in 0 until s.lastIndex) {
            if ((i / (numRows-1)) % 2 == 0) {
                x += 1
            } else {
                x -= 1
                y += 1
            }
            board[x][y] = s[i+1]
        }

        for (i in 0..s.lastIndex) {
            for (j in 0..s.lastIndex) {
                if (board[i][j] != '-') {
                    sb.append(board[i][j])
                }
            }
        }

        return sb.toString()
    }
}