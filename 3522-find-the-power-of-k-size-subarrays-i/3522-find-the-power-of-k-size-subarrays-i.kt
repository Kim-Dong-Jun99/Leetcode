class Solution {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        if (k == 1) {
            return IntArray(nums.size) {nums[it]}
        }
        val answer = IntArray(nums.size-k+1) {-1}
        for (i in 0..answer.lastIndex) {
            if (i == 0) {
                var consecutive = true
                for (j in i+1 until i+k) {
                    if (nums[j-1] != nums[j]-1) {
                        consecutive = false
                        break
                    } 
                }
                if (consecutive) {
                    answer[i] = nums[i] + k - 1
                }
            } else {
                if (answer[i-1] == -1) {
                    var consecutive = true
                    for (j in i+1 until i+k) {
                        if (nums[j-1] != nums[j]-1) {
                            consecutive = false
                            break
                        } 
                    }
                if (consecutive) {
                    answer[i] = nums[i] + k - 1
                }
                } else {
                    if (nums[i+k-1] == answer[i-1]+1) {
                        answer[i] = answer[i-1]+1
                    } else {
                        answer[i] = -1
                    }
                }
            }
        }
        return answer
    }
}