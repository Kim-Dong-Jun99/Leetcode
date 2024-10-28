class Solution {
    fun longestSquareStreak(nums: IntArray): Int {
        nums.sort()
        var answer = -1
        val mp = mutableMapOf<Int, Int>()
        for (num in nums) {
            val sqrt = Math.sqrt(num.toDouble()).toInt()

            if (sqrt * sqrt == num && mp.containsKey(sqrt)) {
                mp.put(num, mp.get(sqrt)!!+1)
                answer = Math.max(answer, mp.get(num)!!)
            } else {
                mp.put(num, 1)
            }
            
        }
        return answer
    }
}