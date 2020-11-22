import java.util.*

fun main(args: Array<String>) {
    val cache = LRUCache(3)
    println(cache.put(1,1))
    println(cache.put(2,2))
    println(cache.put(3,3))
    println(cache.put(4,4))
    println(cache.get(3))
    println(cache.get(4))
}
class LRUCache(val capacity: Int) {
    private val map : MutableMap<Int, Int> = mutableMapOf()
    fun get(key: Int): Int {
        return if(map.containsKey(key)){
            val value = map[key]!!
            map.remove(key)
            map[key] = value
            value
        }else{
            -1
        }
    }

    fun put(key: Int, value: Int) {
        map.remove(key)
        map[key] = value

        if(map.size > capacity){
            map.remove(map.keys.first())
        }
    }
}
