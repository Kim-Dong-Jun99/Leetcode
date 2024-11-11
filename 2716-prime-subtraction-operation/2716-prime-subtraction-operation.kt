class Solution {
    fun primeSubOperation(nums: IntArray): Boolean {
        val primeList = initPrimes()
        for (i in nums.lastIndex-1 downTo 0) {
            if (nums[i] >= nums[i+1]) {
                for (prime in primeList) {
                    if (prime >= nums[i]) {
                        break
                    }
                    if (nums[i] - prime < nums[i+1]) {
                        nums[i] -= prime
                        break
                    }
                }
                if (nums[i] >= nums[i+1]) {
                    return false
                }
            }
        }
        return true
    }

    fun initPrimes(): List<Int> {
        val primeList = mutableListOf<Int>()
        val isPrime = IntArray(1001) { 0 }
        for (i in 2..isPrime.lastIndex) {
            if (isPrime[i] == 0) {
                primeList.add(i)
                isPrime[i] = 1
                var cur = i + i
                while (cur <= isPrime.lastIndex) {
                    isPrime[cur] = -1
                    cur += i
                }
            }
        }
        return primeList
    }
}