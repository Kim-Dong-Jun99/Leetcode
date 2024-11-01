class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        var n = matrix.size
        var x = 0
        var y = 0
        while (n > 1) {
            for (j in 0 until n-1) {
                val i = 0
                val ps = arrayOf(
                    intArrayOf(i, j), 
                    intArrayOf(j, n-1-i), 
                    intArrayOf(n-1-i, n-1-j),
                    intArrayOf(n-1-j, i)
                )
                val vs = arrayOf(
                    matrix[ps[0][0]+x][ps[0][1]+y],
                    matrix[ps[1][0]+x][ps[1][1]+y],
                    matrix[ps[2][0]+x][ps[2][1]+y],
                    matrix[ps[3][0]+x][ps[3][1]+y]
                )
                matrix[ps[0][0]+x][ps[0][1]+y] = vs[3]
                matrix[ps[1][0]+x][ps[1][1]+y] = vs[0]
                matrix[ps[2][0]+x][ps[2][1]+y] = vs[1]
                matrix[ps[3][0]+x][ps[3][1]+y] = vs[2]
            }
            x += 1
            y += 1
            n -= 2
        }
        for (i in 0 until n) {
            for (j in 0 until n) {
                
            }
        }
    }
}