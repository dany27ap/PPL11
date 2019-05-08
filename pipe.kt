import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() = runBlocking <Unit>{
    val vector : ArrayList<Int> = ArrayList()
    for ( i in 1..50){
        vector.add(Random.nextInt(0, 100))
    }

    launch {
        multiplyArray(vector, 3)
    }

    launch {
        vector.sort()
    }

    launch {
        println(vector)
    }
}

fun CoroutineScope.multiplyArray(vector : ArrayList<Int>, alpha : Int) {
    for(i in 0 until vector.size)
        vector[i] *= alpha
}