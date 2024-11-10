class Solution {
    private fun addContribution(value: Int, bitvector: MutableList<Int>, add: Boolean){
        var num = value
        var i = 0
        while(num>0){
            if(add) bitvector[i] += (num and 1) else bitvector[i] -= (num and 1)
            num = num shr 1
            i++
        }
    }
    private fun getBitwiseOr(bitvector: MutableList<Int>): Int{
        var num = 0
        for(i in 0 until 32){
            if(bitvector[i]>0)num = num or (1 shl i)
        }
        return num
    }
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        var n = nums.size
        var i = 0; var j = 0
        var bitvector = MutableList(32){0}
        var result = Int.MAX_VALUE
        while(j<n){
            addContribution(nums[j], bitvector, true)

            while(getBitwiseOr(bitvector)>=k && i<=j){
                result = min(result, j-i+1)
                addContribution(nums[i], bitvector, false)
                i++
            }

            j++
        }
        if(result == Int.MAX_VALUE)return -1 
        return result
    }
}