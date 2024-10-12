import java.util.*

class Solution {
    var answer = 0
    var intervals = arrayOf<IntArray>()

    fun minGroups(intervals: Array<IntArray>): Int {
        initialize(intervals)
        solve()
        return answer    
    }

    fun initialize(intervals: Array<IntArray>) {
        this.intervals = intervals
        this.intervals.sortWith(
            kotlin.Comparator {o1, o2 ->
                if (o1[0] != o2[0]) {
                    o1[0] - o2[0]
                } else {
                    o1[1] - o2[1]
                }
            }
        )
    }

    fun solve() {
        val heap = PriorityQueue<IntArray>(kotlin.Comparator {o1, o2 -> 
            o1[1] - o2[1]
        })
        intervals.forEach {arr -> 
            if (heap.isEmpty()) {
                heap.add(arr)
            } else {
                while (!heap.isEmpty() && !intersect(heap, arr)) {
                    heap.remove()
                }
                heap.add(arr)
            }
            answer = Math.max(answer, heap.size)
        }
    }

    fun intersect(heap: PriorityQueue<IntArray>, arr: IntArray): Boolean {
        val first = heap.peek()
        return arr[0] in first[0]..first[1] || first[1] in arr[0]..arr[1]
    }
}