import java.util.LinkedList
import java.util.HashSet

fun main(args: Array<String>) {
    print(wordBreak("aaaaaaa", listOf("aaa", "aaaa")))
}

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val wordDictSet = HashSet(wordDict)
    val queue = LinkedList<Int>()
    val visited = IntArray(s.length)
    queue.add(0)

    while (!queue.isEmpty()) {
        val start = queue.remove()
        if (visited[start] == 0) {
            for (end in start + 1..s.length) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end)
                    if (end == s.length) {
                        return true
                    }
                }
            }
            visited[start] = 1
        }
    }
    return false
}

/*
fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val wordDictSet = HashSet(wordDict)
    val queue = LinkedList<Int>()
    val visited = IntArray(s.length)
    queue.add(0)

    while (!queue.isEmpty()) {
        val start = queue.remove()
        if (visited[start] == 0) {
            for (end in start + 1..s.length) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end)
                    if (end == s.length) {
                        return true
                    }
                }
            }
            visited[start] = 1
        }
    }
    return false
}*/

//fun wordBreak(s: String, wordDict: List<String>): Boolean {
//    val marking = Array(s.length + 1) { it == 0 }
//
//    for (i in 0..s.length) {
//        for (j in 0 until i) {
//            if (marking[j] && wordDict.contains(s.substring(j until i))) {
//                marking[i] = true
//                break
//            }
//        }
//    }
//    return marking[s.length]
//}


/*
* val map : MutableSet<String> = mutableSetOf()
fun wordBreak(s: String, wordDict: List<String>): Boolean {
    wordDict.forEach { map.add(it) }

    return recursive(s, 0)
}

fun recursive(s: String, startIndex : Int) : Boolean{
    if(startIndex>=s.length) return true

    map.forEach {
        val endIndex = startIndex+it.length
        if(endIndex <= s.length){
            val curr = s.slice(startIndex until endIndex)
            if(it == curr){
                if(recursive(s,endIndex)) return true
            }
        }
    }

    return false
}*/