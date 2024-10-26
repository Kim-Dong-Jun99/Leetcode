class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val n = gas.size
        var totalGas = 0
        var currentGas = 0
        var startIdx = 0

        for(i in 0 until n){
            val diff = gas[i] - cost[i]
            totalGas += diff
            currentGas += diff

            if(currentGas < 0){
                currentGas = 0
                startIdx = i + 1
            }
        }
        return if(totalGas >= 0) startIdx else -1
    }
}