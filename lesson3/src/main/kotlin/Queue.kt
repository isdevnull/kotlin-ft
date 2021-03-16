import java.lang.Exception
import java.util.LinkedList

class CustomQueue<T> {
    private val container = LinkedList<T>()
    val size: Int
        get() = container.size

    fun enqueue(t: T) = container.add(t)

    fun dequeue(): T {
        val res: T
        if (container.size > 0)
            res = container.first().also { container.removeFirst() }
        else
            throw Exception("Queue is empty.")
        return res
    }
}

fun <T> queueOf(vararg elements: T): CustomQueue<T> {
    val q = CustomQueue<T>()
    elements.asList().forEach {q.enqueue(it)}
    return q
}

fun <T> CustomQueue<T>.isEmpty(): Boolean = this.size == 0