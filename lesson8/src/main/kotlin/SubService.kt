import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce

@ExperimentalCoroutinesApi
fun CoroutineScope.produceEvent(start: Int) = produce {
    var x = start
    while (true) {
        delay(1000)
        send(x++)
    }
}

class SubService {

    @ExperimentalCoroutinesApi
    suspend fun receiveEvent() = withContext(Dispatchers.Default) {
        val issue = produceEvent(1)
        repeat (10) {
            println("You received new issue no. ${issue.receive()} of our magazine.")
        }
        coroutineContext.cancelChildren()
    }
}