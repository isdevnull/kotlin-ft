import kotlin.concurrent.thread

class ConcurrentThread: Thread() {
    override fun run() {
        println("${this.name} with Thread()")
    }
}

class RunnableThread : Runnable {
    override fun run() {
        println("${Thread.currentThread().name} with Runnable.")
    }
}

fun main() {
    val thread1 = ConcurrentThread()
    thread1.start()
    val thread2 = Thread(RunnableThread())
    thread2.start()
    thread(start = true, isDaemon = true) {
        println("${Thread.currentThread().name} with SAM")
    }
    thread(priority = 10) {
        println("${Thread.currentThread().name} with priority.")
    }
}