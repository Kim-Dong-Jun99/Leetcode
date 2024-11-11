class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if(s.length != t.length) return false

        for (i in 0 until s.length) {
            if(s.indexOf(s[i]) != t.indexOf(t[i])) return false
        }

        return true
    }
}