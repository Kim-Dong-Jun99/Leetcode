class Solution {
    private fun maxCntSplit(i: Int, s: String, hash: HashSet<String>, n: Int): Int{
        if(i >= n)return 0

        var maxi = Int.MIN_VALUE
        for(k in i until n){
            var substr = s.substring(i, k+1)
            if(!hash.contains(substr)){
                hash.add(substr)
                var cnt = 1 + maxCntSplit(k+1, s, hash, n)
                hash.remove(substr)
                maxi = max(maxi, cnt)
            }
        }
        return maxi
    }
    fun maxUniqueSplit(s: String): Int {
        val n = s.length
        val hash = HashSet<String>()
        return maxCntSplit(0, s, hash, n)
    }
}