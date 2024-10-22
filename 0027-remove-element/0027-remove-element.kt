class Solution {
    
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var removed = 0
        var lastIndex = nums.lastIndex
        var index = 0
        while (index <= lastIndex) {
            if (nums[index] == `val`) {
                nums[index] = nums[lastIndex]
                nums[lastIndex] = -1
                lastIndex--
                removed++
            } else {
                index++
            }
        }
        return nums.size-removed
    }
}