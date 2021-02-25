
fun stackPushPopTest() {
    var s = CustomStack<Int>()
    for (i in 1..1000000) {
        s.push(i)
        check(s.size == i)
    }
    var c: Int = 1000000;
    while (!s.isEmpty()) {
        check(s.pop() == c--)
        check(s.size == c)
    }
    println("stackPushPopTest OK!")
}

fun stackPopEmptyTest() {
    val s = CustomStack<String>()

    check(s.isEmpty())
    try {
        s.pop()
    }
    catch (e: Exception) {
        println("Exception is thrown when stack is empty")
        println("stackPopEmptyTest OK!")
    }
}

fun stackDSLTest() {
    val s = stackOf(1,2,3,4,5)
    var cnt: Int = 5
    while (!s.isEmpty()) {
        check(s.pop() == cnt--)
        check(cnt == s.size)
    }
    println("stackDSLTest OK!")
}

fun queueEnqueueDequeueTest() {
    val q = CustomQueue<Int>()
    for (i in 1..1000000) {
        q.enqueue(i)
        check(q.size == i)
    }
    for (i in 1..1000000) {
        check(q.dequeue() == i)
    }
    check(q.isEmpty())
    println("queueEnqueueDequeueTest OK!")
}

fun queueDequeueEmptyTest() {
    val q = CustomQueue<String>()
    check(q.isEmpty())
    try {
        q.dequeue()
    }
    catch (e: Exception) {
        println("Exception is thrown when queue is empty")
        println("queueDequeueEmptyTest OK!")
    }
}

fun queueDSLTest() {
    val q = queueOf(1,2,3,4,5)
    var cnt:Int = 1
    while (!q.isEmpty()) {
        check(q.dequeue() == cnt++)
    }
    println("queueDSLTest OK!")
}

fun main() {
    stackPushPopTest()
    stackPopEmptyTest()
    stackDSLTest()
    queueEnqueueDequeueTest()
    queueDequeueEmptyTest()
    queueDSLTest()
}