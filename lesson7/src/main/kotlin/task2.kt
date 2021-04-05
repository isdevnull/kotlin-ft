import kotlin.concurrent.thread

class CommonData {
    private var x = 0
    fun increment() = synchronized(x) {x++}
    fun decrement() = synchronized(x) {x--}
    fun getData() = synchronized(x) {x}
}

fun main() {
    val data = CommonData()
    val threads = mutableListOf<Thread>()
    threads.add(thread(start = true) {
        repeat (1_000_000) {
            data.increment()
        }
    })
    for (i in 1..3) {
        threads.add(thread(start = true) {
            repeat(20) {
                println("Thread: ${Thread.currentThread().id}, value: ${data.getData()}") // output may be mixed
            }
        })
    }
    threads.forEach {it.join()}
    check(data.getData() == 1_000_000)
}