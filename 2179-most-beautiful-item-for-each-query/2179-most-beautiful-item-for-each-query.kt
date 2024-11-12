import java.util.*
class Solution {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        val answer = IntArray(queries.size) {0}
        val tm = TreeMap<Int, Int>()
        items.sortWith(kotlin.Comparator {o1, o2 -> 
            if (o1[0] != o2[0]) {
                o1[0] - o2[0]
            } else {
                o2[1] - o2[1]
            }
        })
        var maxBeauty = 0
        for (item in items) {
            maxBeauty = Math.max(maxBeauty, item[1])
            tm[item[0]] = maxBeauty
        }
        for (i in 0..queries.lastIndex) {
            val q = queries[i]
            val key = tm.floorKey(q)
            if (key == null) {
                continue
            }
            answer[i] = tm[key!!]!!
        }
        return answer
    }
}