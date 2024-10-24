class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return validSubSquare(board) &&
            validRows(board) &&
            validColumns(board)
    }

    fun validSubSquare(board: Array<CharArray>): Boolean {
        for (x in 0 until 9 step 3) {
            for (y in 0 until 9 step 3) {
                val intArray = IntArray(10) {0}
                for (i in 0 until 3) {
                    for (j in 0 until 3) {
                        if (board[x+i][y+j].isDigit()) {
                            intArray[board[x+i][y+j].digitToInt()] += 1
                            if (intArray[board[x+i][y+j].digitToInt()] > 1) {
                                return false
                            }
                        } 
                    }
                } 
            }
        }
        return true
    }

    fun validRows(board: Array<CharArray>): Boolean {
        for (x in 0 until 9) {
            val intArray = IntArray(10) {0}
            for (y in 0 until 9) {
                if (board[x][y].isDigit()) {
                    intArray[board[x][y].digitToInt()] += 1
                    if (intArray[board[x][y].digitToInt()] > 1) {
                        return false
                    }
                }
            }
        }
        return true
    }

    fun validColumns(board: Array<CharArray>): Boolean {
        for (y in 0 until 9) {
            val intArray = IntArray(10) {0}
            for (x in 0 until 9) {
                if (board[x][y].isDigit()) {
                    intArray[board[x][y].digitToInt()] += 1
                    if (intArray[board[x][y].digitToInt()] > 1) {
                        return false
                    }
                }
            }
        }
        return true
    }

}