class RandomizedSet {
    private val indices: HashMap<Int, Int> = hashMapOf()
    private val arr: MutableList<Int> = mutableListOf()
    fun insert(value: Int): Boolean {
        if (indices.containsKey(value).not()) {
            arr.add(value)
            indices[value] = arr.size - 1
            return true
        }
        return false
    }

    fun remove(value: Int): Boolean {
        if (indices.containsKey(value)) {
            val index = indices[value] ?: 0
            val lastVal = arr.last()
            arr[index] = lastVal
            arr.removeAt(arr.lastIndex)
            indices[lastVal] = index
            indices.remove(value)
            return true
        }
        return false
    }

    fun getRandom(): Int {
        val randomIdx = (0..arr.lastIndex).random()
        return arr[randomIdx]
    }
}