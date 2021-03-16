import java.lang.Exception
import java.util.LinkedList

class CustomStack<T> {
    private val container = LinkedList<T>()
    val size: Int
        get() = container.size

    fun push(t: T) = container.add(t)
    fun pop(): T {
        val res:T
        if (container.size > 0)
            res = container.last().also { container.removeLast() }
        else
            throw Exception("Stack is empty.")
        return res
    }
}

fun <T> stackOf(vararg elements: T): CustomStack<T> {
    val s = CustomStack<T>()
    elements.asList().forEach {s.push(it)}
    return s
}

fun <T> CustomStack<T>.isEmpty(): Boolean = this.size == 0