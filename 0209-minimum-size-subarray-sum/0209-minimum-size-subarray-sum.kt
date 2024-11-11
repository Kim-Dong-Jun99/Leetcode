class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var sum = 0
        var answer = Int.MAX_VALUE
        for (right in 0..nums.lastIndex) {
            sum += nums[right]
            if (sum >= target) {
                answer = Math.min(answer, right - left+1)
            }
            while (left < right) {
                if (sum - nums[left] >= target) {
                    sum -= nums[left]
                    left += 1
                    answer = Math.min(answer, right - left+1)
                } else {
                    break
                }
            }
            
        }
        if (answer == Int.MAX_VALUE) {
            return 0
        }
        return answer
    }
}