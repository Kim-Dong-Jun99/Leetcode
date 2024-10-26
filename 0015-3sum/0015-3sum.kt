class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()

        for (i in nums.indices) {
            val a = nums[i]
            if (i > 0 && a == nums[i - 1]) continue

            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val threeSum = a + nums[left] + nums[right]
                when {
                    threeSum > 0 -> right--
                    threeSum < 0 -> left++
                    else -> {
                        res.add(listOf(a, nums[left], nums[right]))
                        left++
                        while (nums[left] == nums[left - 1] && left < right) {
                            left++
                        }
                    }
                }
            }
        }
        return res
    }
}