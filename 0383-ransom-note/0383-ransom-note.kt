class Solution {
    val charMap = mutableMapOf<Char, Int>()
    val ransomMap = mutableMapOf<Char, Int>()
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        for (i in 0..magazine.lastIndex) {
            val count = charMap.get(magazine[i]) ?: 0
            charMap.put(magazine[i], count + 1)
            // if (!charMap.containsKey(magazine[i])) {
            //     charMap.put(magazine[i], 1)
            // } else {
            //     charMap.put(magazine[i], charMap.get(magazine[i])!! + 1)
            // }
        }
        for (i in 0..ransomNote.lastIndex) {
            val count = ransomMap.get(ransomNote[i]) ?: 0
            ransomMap.put(ransomNote[i], count+1)
        }
        for ((k,rCount) in ransomMap) {
            val mCount = charMap.get(k) ?: 0
            if (rCount > mCount) {
                return false
            }
        }
        return true
    }
}