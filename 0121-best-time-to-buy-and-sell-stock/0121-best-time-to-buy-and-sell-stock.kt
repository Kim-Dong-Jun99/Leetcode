class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = Integer.MAX_VALUE
        var profit = 0
        for (price in prices) {
            min = Math.min(min, price)
            profit = Math.max(profit, price-min)
        }        
        return profit
    }
}