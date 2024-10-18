import java.util.*

class Solution {
    var nums = intArrayOf()
    var max = 0
    var n = 0
    fun countMaxOrSubsets(nums: IntArray): Int {
        initialize(nums)
        return solve()    
    }

    fun initialize(nums: IntArray) {
        this.nums = nums
        this.n = nums.size
        initMax()
    }

    fun solve(): Int {
        return dfs(0, BooleanArray(n){false}, 0, 0)
    }

    fun dfs(index: Int, visited: BooleanArray, count: Int, value: Int): Int {
        var result = 0
        if (value == max) {
            result += 1
        }
        if (count == n) {
            return result
        }
        for (i in index until n) {
            if (!visited[i]) {
                visited[i] = true
                result += dfs(i+1, visited, count+1, value or nums[i])
                visited[i] = false
            }
        }
        return result

    }

    fun initMax() {
        nums.forEach { num -> 
            max = max or num
        }
    }
}