import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread
import kotlin.random.Random
import kotlin.system.*

fun sum(no : Int) : Int {
    var sum : Int = 0
    for (i in 0 until no){
        sum += i
    }
    return sum
}

fun main() = runBlocking <Unit>  {
    val queueWithNo : ArrayList<Int>  = ArrayList()
    queueWithNo.add(9808)
    queueWithNo.add(69)
    queueWithNo.add(45)

    launch {
        println(sum(queueWithNo.removeAt(0)))
    }

    launch {
        println(sum(queueWithNo.removeAt(0)))
    }

    launch {
        println(sum(queueWithNo.removeAt(0)))
    }


}
