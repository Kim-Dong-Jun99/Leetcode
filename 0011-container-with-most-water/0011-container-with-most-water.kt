import java.util.*

class Solution {
    var height = intArrayOf()
    val ts = TreeSet<Int>()
    val heap = PriorityQueue<Node>(kotlin.Comparator{o1, o2 -> 
        o1.h-o2.h
    })
    fun maxArea(height: IntArray): Int {
        initialize(height)
        return solve()
    }

    fun initialize(height: IntArray) {
        this.height = height
        for (i in 0..height.lastIndex) {
            ts.add(i)
            heap.add(Node(height[i], i))
        }
    }

    fun solve(): Int {
        var answer = 0
        while (!heap.isEmpty()) {
            val node = heap.remove()
            answer = Math.max(answer, node.h * Math.abs(ts.first() - node.index))
            answer = Math.max(answer, node.h * Math.abs(ts.last() - node.index))
            ts.remove(node.index)
        }

        return answer
    }

    class Node(val h: Int, val index: Int) {}
}