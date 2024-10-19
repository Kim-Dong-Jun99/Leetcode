import java.util.*
class Solution {
   fun findKthBit(n: Int, k: Int): Char {
        when (k) {
            1 -> return '0'
            2 -> return '1'
        }
        
        val list = mutableListOf<String>()
        list.add("0") 
        
        for (i in 1 until n) {
            list.add(makeString(list[i-1])) 
        }

        return list[n-1][k-1] 
    }
    
    fun makeString(str: String): String {
        val sb = StringBuilder(str)
        sb.append("1") 
        
        for (i in str.indices.reversed()) { 
            if (str[i] == '1')
                sb.append("0")
            else
                sb.append("1")
        }
        
        return sb.toString()
    }
}