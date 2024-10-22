class Solution {
    fun rotate(nums: IntArray, k: Int) {
        val n = nums.size
        val k = k % n
        val res = IntArray(n)
        for (i in nums.indices) {
            res[(i + k) % n] = nums[i]
        }
        for (i in nums.indices) {
            nums[i] = res[i]
        }
    }
}