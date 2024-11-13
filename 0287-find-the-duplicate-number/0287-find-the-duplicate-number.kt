class Solution {
    fun findDuplicate(nums: IntArray): Int {
        nums.sort()
        for (i in 0..nums.lastIndex-1) {
            if (nums[i] == nums[i+1]) {
                return nums[i]
            }
        }
        return -1
    }
}