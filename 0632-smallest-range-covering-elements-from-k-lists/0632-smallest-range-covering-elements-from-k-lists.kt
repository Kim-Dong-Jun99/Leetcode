import java.util.*

class Solution {
    var k = 0
    var nums = listOf<List<Int>>()
    fun smallestRange(nums: List<List<Int>>): IntArray {
        initialize(nums)
        return solve()
    }

    fun initialize(nums: List<List<Int>>) {
        this.k = nums.size
        this.nums = nums
    }

    fun solve(): IntArray {
        val answer = intArrayOf(-100_000, 100_000)
        val heap = PriorityQueue<Node>(kotlin.Comparator {o1, o2 ->
            o1.v - o2.v
        })
        var max = -100_000
        for (i in 0..nums.lastIndex) {
            heap.add(Node(nums[i][0], i, 0))
            max = Math.max(max, nums[i][0])
        }
        while (!heap.isEmpty()) {
            val node = heap.remove()
            updateAnswer(node, max, answer)
            if (nums[node.i].lastIndex < node.j+1) {
                break
            }
            heap.add(Node(nums[node.i][node.j+1], node.i, node.j+1))
            max = Math.max(max, nums[node.i][node.j+1])
        }
        return answer
    }

    fun updateAnswer(node: Node, max: Int, answer: IntArray) {
        val min = node.v
        if (max - min < answer[1] - answer[0] || (max < answer[1] && max-min == answer[1]-answer[0])) {
            answer[1] = max
            answer[0] = min
        }
    }

    class Node(val v: Int, val i: Int, val j: Int) {}
}