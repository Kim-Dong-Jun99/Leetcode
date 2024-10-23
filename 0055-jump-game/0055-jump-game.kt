class Solution {
    var nums = intArrayOf()
    fun canJump(nums: IntArray): Boolean {
        initialize(nums)
        return solve()
    }

    fun initialize(nums: IntArray) {
        this.nums = nums
    }

    fun solve(): Boolean {
        var gas = 0
        for (n in nums) {
            if (gas < 0) {
                return false
            } else if(n > gas) {
                gas = n
            }
            gas -= 1
        }
        return true
    }

}