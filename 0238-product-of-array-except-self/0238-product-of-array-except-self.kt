class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var prod = 1
        var i = nums.size
        while (i > 0) {
            i--
            result[i] = prod
            prod *= nums[i]
        }

        prod = 1
        while (i < nums.size) {
            result[i] *= prod
            prod *= nums[i]
            i++
        }
        return result
    }
}