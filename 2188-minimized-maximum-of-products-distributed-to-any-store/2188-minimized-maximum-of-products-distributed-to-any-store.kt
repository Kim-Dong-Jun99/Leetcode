class Solution {
    fun minimizedMaximum(n: Int, quantities: IntArray): Int {
        var l = 1
        var r = 0
        for (q in quantities) r = max(r, q)
        while (l <= r) {
            val mid = l + (r - l) / 2
            when {
                canDistributeProducts(quantities, n, mid) -> r = mid - 1
                else -> l = mid + 1
            }
        }
        return l
    }

    private fun canDistributeProducts(quantities: IntArray, stores: Int, maxQuantity: Int): Boolean {
        var filledStores = 0.0
        for (quantity in quantities) {
            filledStores += ceil(quantity.toDouble() / maxQuantity)
        }
        return filledStores <= stores
    }
}