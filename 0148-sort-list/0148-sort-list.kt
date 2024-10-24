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
    fun sortList(head: ListNode?): ListNode? {
        val nodes = sortedMapOf<Int, MutableList<ListNode>>()

        var current = head ?: return null
        while (current != null) {
            nodes.getOrPut(current.`val`) { mutableListOf() }.add(current)
            current = current.next ?: break
        }

        val last = nodes.values.asSequence().flatMap { it }.reduce { left, right ->
            left.next = right
            right
        }
        last.next = null

        return nodes.values.first().first()
    }
}