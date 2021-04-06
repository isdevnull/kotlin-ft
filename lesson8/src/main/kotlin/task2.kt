import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val service = SubService()
    launch {
        service.receiveEvent()
    }
    repeat (10) { // to show that we have concurrent execution
        delay(1000)
        println("Other thread does smth here...")
    }
}