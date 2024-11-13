class Solution {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        nums.sort()
        return countLess(nums, upper) - countLess(nums, lower-1)
    }

    fun countLess(nums: IntArray, sum: Int): Long {
        var answer = 0L
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            while (nums[left] + nums[right] > sum && left < right) {
                right--
            }
            answer += right - left
            left++
        }
        return answer
    }
}