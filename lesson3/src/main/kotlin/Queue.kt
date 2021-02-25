import java.lang.Exception
import java.util.LinkedList

class CustomQueue<T> {
    private val container = LinkedList<T>()
    var size: Int = 0
        private set

    fun enqueue(t: T) = container.add(t).also { size++ }

    fun dequeue(): T {
        size--
        val res: T
        if (container.size > 0)
            res = container.first().also { container.removeFirst() }
        else
            throw Exception("Stack is empty.")
        return res
    }
}

fun <T> queueOf(vararg elements: T): CustomQueue<T> {
    val q = CustomQueue<T>()
    elements.asList().forEach {q.enqueue(it)}
    return q
}

fun <T> CustomQueue<T>.isEmpty(): Boolean = this.size == 0