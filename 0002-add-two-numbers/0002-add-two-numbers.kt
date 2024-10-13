/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    var l1 = ArrayDeque<Int>()
    var l2 = ArrayDeque<Int>()

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        initialize(l1, l2)
        return solve()
    }

    fun initialize(l1: ListNode?, l2: ListNode?) {
        this.l1 = listToDeque(l1)
        this.l2 = listToDeque(l2)
    }

    fun solve(): ListNode? {
        return dequeToList(l1, l2)
    }

    fun dequeToList(l: ArrayDeque<Int>, r: ArrayDeque<Int>): ListNode? {

        val head = ListNode(0)
        var cur = head
        while (true) {
            var toAdd = 0
            if (!l.isEmpty()) {
                toAdd += l.removeFirst()
            }
            if (!r.isEmpty()) {
                toAdd += r.removeFirst()
            }
            if (toAdd / 10 > 0) {
                if (l.isEmpty()) {
                    l.addFirst(toAdd / 10)
                } else {
                    l.addFirst(l.removeFirst()+toAdd / 10)
                }
                toAdd %= 10
            }
            cur.`val` = toAdd
            if (l.isEmpty() && r.isEmpty()) {
                break
            }
            cur.next = ListNode(0)
            cur = cur.next

        }
        return head
    }

    fun listToDeque(l: ListNode?): ArrayDeque<Int> {
        val q = ArrayDeque<Int>()
        var cur = l
        while (cur != null) {
            q.addLast(cur.`val`)
            cur = cur.next
        }
        return q
    }
}