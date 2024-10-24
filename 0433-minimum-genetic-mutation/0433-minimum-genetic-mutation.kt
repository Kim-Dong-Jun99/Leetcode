class Solution {
    val dna = charArrayOf('A', 'C', 'G', 'T')
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        var changed = 0
        var curList = mutableListOf<String>()
        val visited = mutableSetOf<String>()
        val canGo = mutableSetOf<String>()
        for (b in bank) {
            canGo.add(b)
        }
        curList.add(startGene)
        visited.add(startGene)
        while (curList.isNotEmpty()) {
            val temp = mutableListOf<String>()
            for (cur in curList) {
                if (cur.equals(endGene)) {
                    return changed
                }
                for (next in getNextGene(cur)) {
                    if (!visited.contains(next) && canGo.contains(next)) {
                        visited.add(next)
                        temp.add(next)
                    }
                }
            }
            changed += 1
            curList = temp
        }

        return -1
    }

    fun getNextGene(cur: String): MutableList<String> {
        val list = mutableListOf<String>()
        for (i in 0..cur.lastIndex) {
            for (d in dna) {
                if (cur[i] != d) {
                    list.add(cur.substring(0, i)+d+cur.substring(i+1))
                }
            }
        }
        return list
    }
}