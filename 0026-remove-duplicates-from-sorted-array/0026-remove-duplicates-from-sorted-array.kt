class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var index = 0
        for (i in 1..nums.lastIndex) {
            if (nums[index] != nums[i]) {
                index ++
                nums[index] = nums[i]
            }
        }
        return index+1
    }
}