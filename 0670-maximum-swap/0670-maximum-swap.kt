import java.util.*
class Solution {
    var num = 0
    fun maximumSwap(num: Int): Int {
        initialize(num)
        return solve()
    }

    fun initialize(num: Int) {
        this.num = num
    }

    fun solve(): Int {
        var answer = num
        val digit = getDigit(num)
        println("$digit")
        for (i in 0..digit) {
            for (j in i+1..digit) {
                answer = Math.max(answer, swap(i, j))
            }
        }
        return answer
    }

    fun swap(i: Int, j: Int): Int {
        val di = num/pow(i) - num/pow(i+1)*10
        val dj = num/pow(j) - num/pow(j+1)*10

        return num-di*pow(i)-dj*pow(j)+di*pow(j)+dj*pow(i)
    }

    fun getDigit(num: Int): Int {
        var cur = num
        var d = 0
        while (cur >= 10) {
            cur /= 10
            d++
        }
        return d
    }

    fun pow(p: Int): Int {
        var v = 1
        for (i in 0 until p) {
            v *= 10
        }
        return v
    }
}