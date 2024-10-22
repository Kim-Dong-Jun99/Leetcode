class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var index = 1
        for (i in 2..nums.lastIndex) {
            if (nums[index] != nums[i] || nums[index-1] != nums[i]) {
                index ++
                nums[index] = nums[i]
            }
        }
        return index+1
    }
}